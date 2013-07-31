
package com.xekm.jango.ext.middleware;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.middleware.BaseMiddleware;
import com.xekm.jango.ext.http.ServerErrorHttpResponse;

public class ServerErrorMiddleware
    extends BaseMiddleware
{
  @Override
  public HttpResponse processException(HttpRequest request, JangoException e)
  {
    return new ServerErrorHttpResponse();
  }
}
