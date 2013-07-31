
package com.xekm.jango.ext.http;

import com.xekm.jango.core.http.HttpResponse;

public class PermanentRedirectHttpResponse
    extends HttpResponse
{
  public PermanentRedirectHttpResponse(String location)
  {
    super(301);
    this.addHeader("Location", location);
  }
}
