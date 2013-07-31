
package com.xekm.jango.core.http;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpResponse
{
  private int                 status          = 0;
  private String              content         = null;
  private Map<String, String> responseHeaders = null;
  private List<JangoCookie>   responseCookies = null;

  public HttpResponse()
  {
    this("");
  }

  public HttpResponse(String content)
  {
    this(content, 200);
  }

  public HttpResponse(String content, int status)
  {
    this.status = status;
    this.content = content;
    this.responseHeaders = new HashMap<String, String>();
    this.responseCookies = new LinkedList<JangoCookie>();
  }

  public HttpResponse(int status)
  {
    this("", status);
  }

  public void addHeader(String k, String v)
  {
    this.responseHeaders.put(k, v);
  }

  public void setContent(String s)
  {
    this.content = s;
  }

  public String getContent()
  {
    return this.content;
  }

  public int getStatus()
  {
    return this.status;
  }

  public Set<String> getHeaderNames()
  {
    return this.responseHeaders.keySet();
  }

  public String getHeaderValue(String name)
  {
    return this.responseHeaders.get(name);
  }

  public void setCookieValue(String name, String value)
  {
    this.responseCookies.add(new JangoCookie(name, value));
  }

  public List<JangoCookie> getCookies()
  {
    return this.responseCookies;
  }
}
