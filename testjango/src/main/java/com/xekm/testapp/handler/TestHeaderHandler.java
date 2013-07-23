
package com.xekm.testapp.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;

public class TestHeaderHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    HttpResponse r = new HttpResponse();
    r.addHeader(request.getQueryParameter("k"),
        request.getQueryParameter("v"));
    return r;
  }
}
