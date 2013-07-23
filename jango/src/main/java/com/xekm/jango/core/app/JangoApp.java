
package com.xekm.jango.core.app;

import com.xekm.jango.core.http.handler.BaseHandler;

public abstract class JangoApp
{
  private AppRouter router = null;

  public JangoApp()
  {
    this.router = new AppRouter();
  }

  protected void installRoute(String s, BaseHandler h)
  {
    this.router.installRoute(s, h);
  }

  protected void installRoute(String s, BaseHandler h, String name)
  {
    this.router.installRoute(s, h);
  }

  public AppRouter getRouter()
  {
    return this.router;
  }
}
