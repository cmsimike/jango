
package com.xekm.jango.core.app;

import java.util.LinkedList;
import java.util.List;

import com.xekm.jango.core.http.handler.BaseHandler;

public class AppRouter
{
  private List<AppRoute> routes;

  public AppRouter()
  {
    this.routes = new LinkedList<AppRoute>();
  }

  public void installRoute(String s, BaseHandler h)
  {
    this.routes.add(new AppRoute(s, h));
  }

  public void installRoute(String s, BaseHandler h, String name)
  {
    this.routes.add(new AppRoute(s, h, name));
  }

  public List<AppRoute> getRoutes()
  {
    return this.routes;
  }

  public class AppRoute
  {
    private String      s    = null;
    private BaseHandler h    = null;
    private String      name = null;

    public AppRoute(String s, BaseHandler h)
    {
      this.s = s;
      this.h = h;
      this.name = null;
    }

    public AppRoute(String s, BaseHandler h, String name)
    {
      this(s, h);
      this.name = name;
    }

    public String getPath()
    {
      return this.s;
    }

    public BaseHandler getHandler()
    {
      return this.h;
    }

    public String toString()
    {
      return "Path: " + this.s + " for handler" + this.h;
    }

  }
}
