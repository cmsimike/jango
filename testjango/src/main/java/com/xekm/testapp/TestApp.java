
package com.xekm.testapp;

import com.xekm.jango.core.app.JangoApp;
import com.xekm.testapp.handler.BasicHandler;
import com.xekm.testapp.handler.CookieIncrementHandler;
import com.xekm.testapp.handler.CookieSetHandler;
import com.xekm.testapp.handler.DatePathHandler;
import com.xekm.testapp.handler.MustacheTemplateHtmlViewFromClasspathHandler;
import com.xekm.testapp.handler.MustacheTemplateViewFromClasspathHandler;
import com.xekm.testapp.handler.MustacheTemplateViewHandler;
import com.xekm.testapp.handler.PrintDebugStatusHandler;
import com.xekm.testapp.handler.QueryHandler;
import com.xekm.testapp.handler.ReturnNullHanlder;
import com.xekm.testapp.handler.StringTemplateViewHandler;
import com.xekm.testapp.handler.TestHeaderHandler;

public class TestApp
    extends JangoApp
{
  public TestApp()
  {
    super();

    this.installRoute("$", new BasicHandler());
    this.installRoute("query/$", new QueryHandler());
    this.installRoute("null/$", new ReturnNullHanlder());
    this.installRoute("test-header/$", new TestHeaderHandler());
    this.installRoute("301/$",
        new com.xekm.testapp.handler.PermanentRedirectHandler());
    this.installRoute("({year}\\d\\d\\d\\d)/({month}\\d\\d)/({day}\\d\\d)/$",
        new DatePathHandler());
    this.installRoute("stvh/$", new StringTemplateViewHandler());
    this.installRoute("mtvh/$", new MustacheTemplateViewHandler());
    this.installRoute("mtvch/$",
        new MustacheTemplateViewFromClasspathHandler());
    this.installRoute("mthvch/$",
        new MustacheTemplateHtmlViewFromClasspathHandler());
    this.installRoute("debug/$", new PrintDebugStatusHandler());

    this.installRoute("cookie-dump/$", new CookieSetHandler());
    this.installRoute("cookie-inc/$", new CookieIncrementHandler());
  }

}
