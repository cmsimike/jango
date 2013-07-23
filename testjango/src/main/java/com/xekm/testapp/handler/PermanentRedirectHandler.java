
package com.xekm.testapp.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.http.PermanentRedirectHttpResponse;

public class PermanentRedirectHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    return new PermanentRedirectHttpResponse("http://www.google.com");
  }
}
