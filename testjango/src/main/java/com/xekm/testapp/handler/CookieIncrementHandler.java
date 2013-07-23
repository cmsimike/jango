
package com.xekm.testapp.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.view.http.TemplateHtmlViewResponse;
import com.xekm.jango.ext.view.template.StringTemplateRenderer;

public class CookieIncrementHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {

    String sCurrentCount = request.getRequestCookieValue("jangocount");
    if (sCurrentCount == null)
    {
      sCurrentCount = "0";
    }
    int currentCount = Integer.parseInt(sCurrentCount);
    currentCount++;
    HttpResponse res = new TemplateHtmlViewResponse(
        new StringTemplateRenderer("count should now be " + currentCount));
    res.setCookieValue("jangocount", Integer.toString(currentCount));
    return res;
  }
}
