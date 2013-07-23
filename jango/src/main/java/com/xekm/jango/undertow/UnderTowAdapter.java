
package com.xekm.jango.undertow;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.xekm.jango.adapter.JangoAdapter;
import com.xekm.jango.core.http.JangoCookie;

import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.Cookie;
import io.undertow.util.HttpString;

public class UnderTowAdapter
    extends JangoAdapter
{
  private HttpServerExchange exchange;

  public UnderTowAdapter(HttpServerExchange exchange)
  {
    this.exchange = exchange;
  }

  @Override
  public String getPath()
  {
    return this.exchange.getRelativePath();
  }

  @Override
  public String getQueryString()
  {
    return this.exchange.getQueryString();
  }

  @Override
  public String getRequestHeaderHeader(String key)
  {
    return this.exchange.getRequestHeaders().getFirst(new HttpString(key));
  }

  @Override
  public String getCookieValue(String cookieName)
  {
    Cookie c = this.exchange.getRequestCookies().get(cookieName);
    if (c != null)
    {
      return c.getValue();
    }
    return null;
  }

  @Override
  public Collection<String> getRequestCookieNames()
  {
    return this.exchange.getRequestCookies().keySet();
  }

  @Override
  public Collection<String> getRequestHeaderNames()
  {
    List<String> toReturn = new LinkedList<String>();
    for (HttpString s : this.exchange.getRequestHeaders().getHeaderNames())
    {
      toReturn.add(s.toString());
    }
    return toReturn;
  }

  public static class ExchangeCookie
      implements Cookie
  {

    private JangoCookie cookie;

    public ExchangeCookie(JangoCookie cookie)
    {
      this.cookie = cookie;
    }

    @Override
    public String getName()
    {
      return this.cookie.getName();
    }

    @Override
    public String getValue()
    {
      return this.cookie.getValue();
    }

    @Override
    public Cookie setValue(String value)
    {
      return this;
    }

    @Override
    public String getPath()
    {
      return this.cookie.getPath();
    }

    @Override
    public Cookie setPath(String path)
    {
      return this;
    }

    @Override
    public String getDomain()
    {
      return this.cookie.getDomain();
    }

    @Override
    public Cookie setDomain(String domain)
    {
      return this;
    }

    @Override
    public Integer getMaxAge()
    {
      return this.cookie.getMaxAge();
    }

    @Override
    public Cookie setMaxAge(Integer maxAge)
    {
      return this;
    }

    @Override
    public boolean isDiscard()
    {
      return this.cookie.isDiscard();
    }

    @Override
    public Cookie setDiscard(boolean discard)
    {
      return this;
    }

    @Override
    public boolean isSecure()
    {
      return this.cookie.isSecure();
    }

    @Override
    public Cookie setSecure(boolean secure)
    {
      return this;
    }

    @Override
    public int getVersion()
    {
      return this.cookie.getVersion();
    }

    @Override
    public Cookie setVersion(int version)
    {
      return this;
    }

    @Override
    public boolean isHttpOnly()
    {
      return this.cookie.isHttpOnly();
    }

    @Override
    public Cookie setHttpOnly(boolean httpOnly)
    {
      return this;
    }

    @Override
    public Date getExpires()
    {
      return this.cookie.getExpires();
    }

    @Override
    public Cookie setExpires(Date expires)
    {
      return this;
    }

    @Override
    public String getComment()
    {
      return this.cookie.getComment();
    }

    @Override
    public Cookie setComment(String comment)
    {
      return this;
    }
  }
}
