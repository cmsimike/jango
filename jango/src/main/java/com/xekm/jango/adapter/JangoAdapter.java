
package com.xekm.jango.adapter;

import java.util.Collection;

public abstract class JangoAdapter
{
  public abstract String getPath();

  public abstract String getQueryString();

  public abstract String getRequestHeaderHeader(String key);

  public abstract String getCookieValue(String cookieName);

  public abstract Collection<String> getRequestCookieNames();

  public abstract Collection<String> getRequestHeaderNames();
}
