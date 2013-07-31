
package com.xekm.jango.core.project;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jregex.Matcher;

import org.apache.commons.configuration.Configuration;

import com.xekm.jango.core.app.JangoApp;
import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.core.middleware.BaseMiddleware;
import com.xekm.jango.ext.http.exception.NotFoundException;
import com.xekm.jango.ext.middleware.NotFoundMiddleware;
import com.xekm.jango.ext.middleware.RedirectMissingTrailingSlashMiddleware;
import com.xekm.jango.ext.middleware.ServerErrorMiddleware;

public abstract class JangoProject
{
  private ProjectRouter        router      = null;
  private List<BaseMiddleware> middlewares = null;
  private Configuration        config      = null;

  public JangoProject()
  {
    this.router = new ProjectRouter();
    this.middlewares = new LinkedList<BaseMiddleware>();
    //this.middlewares.add(new RedirectMissingTrailingSlashMiddleware());
    this.middlewares.add(new ServerErrorMiddleware());
    this.middlewares.add(new NotFoundMiddleware());
    this.installApps(this.getConfiguration());
  }

  public abstract void installApps(Configuration config);

  public abstract Configuration getConfiguration();

  protected void installApp(String mount, JangoApp app)
  {
    this.router.installApp(mount, app);
  }

  public HttpResponse handleRequest(HttpRequest request)
  {
    HttpResponse resp = null;
    try
    {
      BaseHandler h = null;
      resp = this.processRequest(request);

      if (resp != null)
      {
        return resp;
      }

      for (ProjectRouter.ProjectRoute r : this.router.getRoutes())
      {
        Matcher m = r.matcher(request.getPath());
        if (m.matches())
        {
          h = r.getHandler();
          request.setMatcher(m);
          break;
        }
      }
      if (h == null)
      {
        throw new NotFoundException();
      }
      resp = h.preHandle(request);
      if (resp == null)
      {
        try
        {
          resp = h.handle(request);
        }
        catch (Throwable e)
        {
          e.printStackTrace();
          throw e;
        }

        if (resp == null)
        {
          throw new JangoException("Null HttpResponse");
        }
      }
    }
    catch (JangoException e)
    {
      HttpResponse tmp = this.processException(request, e);
      if (tmp != null)
      {
        resp = tmp;
      }
    }
    finally
    {
      HttpResponse tmp = this.processHandler(request, resp);
      if (tmp != null)
      {
        resp = tmp;
      }
      return resp;
    }
  }

  private HttpResponse processRequest(HttpRequest request)
  {
    for (BaseMiddleware middleware : this.middlewares)
    {
      HttpResponse resp = middleware.processRequest(request);
      if (resp != null)
      {
        return resp;
      }
    }
    return null;
  }

  private HttpResponse processException(HttpRequest request,
      JangoException exception)
  {
    List<BaseMiddleware> reversedMiddlewares = new LinkedList<BaseMiddleware>(
        this.middlewares);
    Collections.reverse(reversedMiddlewares);
    for (BaseMiddleware middleware : reversedMiddlewares)
    {
      HttpResponse resp = middleware.processException(request, exception);
      if (resp != null)
      {
        return resp;
      }
    }
    return null;
  }

  private HttpResponse processHandler(HttpRequest request,
      HttpResponse response)
  {
    List<BaseMiddleware> reversedMiddlewares = new LinkedList<BaseMiddleware>(
        this.middlewares);
    Collections.reverse(reversedMiddlewares);
    for (BaseMiddleware middleware : reversedMiddlewares)
    {
      response = middleware.processHandler(request, response);
    }
    return null;
  }
}
