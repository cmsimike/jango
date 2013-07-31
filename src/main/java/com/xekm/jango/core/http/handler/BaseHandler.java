
package com.xekm.jango.core.http.handler;

import java.util.ArrayList;
import java.util.List;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.prehandler.BasePreHandler;

public abstract class BaseHandler
{
  private List<BasePreHandler> preHandlers = null;

  public BaseHandler()
  {
    this.preHandlers = new ArrayList<BasePreHandler>();
  }

  /**
   * Override this method in the subclass and add subclasses of
   * {@link BasePreHandler}.
   */
  private void installPreHandlers()
  {

  }

  public HttpResponse preHandle(HttpRequest request)
  {
    for (BasePreHandler h : this.preHandlers)
    {
      HttpResponse res = h.preHandle(request);
      if (res != null)
      {
        return res;
      }
    }

    return null;
  }

  public abstract HttpResponse handle(HttpRequest request)
      throws JangoException;

  public String toString()
  {
    return this.getClass().getSimpleName();
  }
}
