
package com.xekm.testother.handler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;

public class RunOther
    extends BaseHandler
{

  @Override
  public HttpResponse handle(HttpRequest request) throws JangoException
  {
    return new HttpResponse("Hello, World! From other");
  }
}
