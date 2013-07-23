
package com.xekm.jango.core.middleware;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;

public class BaseMiddleware
{

  public HttpResponse processRequest(HttpRequest request)
  {
    return null;
  }

  public HttpResponse processHandler(HttpRequest request,
      HttpResponse response)
  {
    return response;
  }

  public HttpResponse processException(HttpRequest request, JangoException e)
  {
    return null;
  }
}
