
package com.xekm.jango.core.project;

import java.util.LinkedList;
import java.util.List;

import jregex.Matcher;
import jregex.Pattern;

import com.xekm.jango.core.app.AppRouter;
import com.xekm.jango.core.app.JangoApp;
import com.xekm.jango.core.http.handler.BaseHandler;

public class ProjectRouter
{
  private List<ProjectRoute> routes = null;

  public ProjectRouter()
  {
    this.routes = new LinkedList<ProjectRoute>();
  }

  public void installApp(String mount, JangoApp app)
  {
    for (AppRouter.AppRoute appRoute : app.getRouter().getRoutes())
    {
      this.routes.add(new ProjectRoute(
          new Pattern(mount + appRoute.getPath()), appRoute.getHandler()));
    }
  }

  public List<ProjectRoute> getRoutes()
  {
    return this.routes;
  }

  public class ProjectRoute
  {
    private Pattern     p    = null;
    private BaseHandler h    = null;
    private String      name = null;

    public ProjectRoute(Pattern p, BaseHandler h)
    {
      this.p = p;
      this.h = h;
      this.name = null;
    }

    public ProjectRoute(Pattern p, BaseHandler h, String name)
    {
      this(p, h);
      this.name = name;
    }

    public Matcher matcher(String path)
    {
      Matcher m = p.matcher(path);
      return m;
    }

    public BaseHandler getHandler()
    {
      return this.h;
    }

    public String toString()
    {
      return "Path: " + this.p + " for handler" + this.h;
    }

  }
}
