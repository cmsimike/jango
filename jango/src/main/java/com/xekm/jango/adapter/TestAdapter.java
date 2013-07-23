
package com.xekm.jango.adapter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestAdapter
    extends JangoAdapter
{
  private String              path            = null;
  private String              queryString     = null;
  private Map<String, String> requestHeaders  = null;
  private Map<String, String> responseHeaders = null;

  public TestAdapter(String path, String queryString)
  {
    this.path = path;
    this.queryString = queryString;
    this.requestHeaders = new HashMap<String, String>();
    this.responseHeaders = new HashMap<String, String>();
  }

  public String getPath()
  {
    return this.path;
  }

  @Override
  public String getQueryString()
  {
    return this.queryString;
  }

  @Override
  public String getRequestHeaderHeader(String key)
  {
    // TODO
    return null;
  }

  @Override
  public String getCookieValue(String cookieName)
  {
    return null;// TODO
  }

  @Override
  public Collection<String> getRequestCookieNames()
  {
    // TODO
    return null;
  }

  @Override
  public Collection<String> getRequestHeaderNames()
  {
    // TODO
    return null;
  }
}
