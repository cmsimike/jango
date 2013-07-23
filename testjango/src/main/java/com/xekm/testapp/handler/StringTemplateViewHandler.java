
package com.xekm.testapp.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.view.http.TemplateViewResponse;
import com.xekm.jango.ext.view.template.StringTemplateRenderer;

public class StringTemplateViewHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    return new TemplateViewResponse(new StringTemplateRenderer(
        "$Hello, World!!!"));
  }
}
