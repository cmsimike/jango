
package com.xekm.jango.ext.http;

import com.xekm.jango.core.http.HttpResponse;

public class NotFoundHttpResponse
    extends HttpResponse
{
  public NotFoundHttpResponse()
  {
    super("404 not found", 404);
  }
}
