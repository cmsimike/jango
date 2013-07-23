
package com.xekm.testapp.handler;

import org.apache.commons.configuration.Configuration;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.view.http.TemplateViewResponse;
import com.xekm.jango.ext.view.template.StringTemplateRenderer;
import com.xekm.jango.ext.view.template.TemplateRenderer;

public class PrintDebugStatusHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    Configuration config = request.getConfiguration();

    String debug = config.getString("debug");

    TemplateRenderer ren = new StringTemplateRenderer(debug);
    HttpResponse r = new TemplateViewResponse(ren);
    return r;
  }
}
