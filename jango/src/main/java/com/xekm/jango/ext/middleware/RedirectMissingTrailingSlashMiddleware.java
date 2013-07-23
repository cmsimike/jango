
package com.xekm.jango.ext.middleware;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.middleware.BaseMiddleware;
import com.xekm.jango.ext.http.PermanentRedirectHttpResponse;

public class RedirectMissingTrailingSlashMiddleware
    extends BaseMiddleware
{
  @Override
  public HttpResponse processRequest(HttpRequest request)
  {
    if (!request.getPath().endsWith("/"))
    {
      String queryString = "";
      if (request.getQueryString().length() > 0)
      {
        queryString = "?" + request.getQueryString();
      }
      return new PermanentRedirectHttpResponse(request.getPath() + "/"
          + queryString);
    }
    return null;
  }
}
