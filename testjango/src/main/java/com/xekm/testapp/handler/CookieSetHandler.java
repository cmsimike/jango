
package com.xekm.testapp.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.view.http.TemplateHtmlViewResponse;
import com.xekm.jango.ext.view.template.StringTemplateRenderer;

public class CookieSetHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    StringBuilder sb = new StringBuilder();
    sb.append("<html><body><dl>");
    for (String s : request.getRequestCookieNames())
    {
      sb.append("<dt>");
      sb.append(s);
      sb.append("</dt>");
      sb.append("<dd>");
      sb.append(request.getRequestCookieValue(s));
      sb.append("</dd>");
    }
    sb.append("<dl></body></html>");

    return new TemplateHtmlViewResponse(new StringTemplateRenderer(
        sb.toString()));
  }
}
