
package com.xekm.jango.core.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import jregex.Matcher;

import org.apache.commons.configuration.Configuration;

import com.xekm.jango.adapter.JangoAdapter;

public class HttpRequest
{
  private JangoAdapter        adapter         = null;
  private Matcher             matcher         = null;
  private Map<String, String> queryParameters = null;
  private String              queryString     = null;
  private Configuration       configuration   = null;

  public HttpRequest(JangoAdapter adapter, Configuration config)
  {
    this.adapter = adapter;
    this.queryParameters = new HashMap<String, String>();
    this.parseQueryParameters(this.adapter.getQueryString());
    this.queryString = this.adapter.getQueryString();

    this.configuration = config;
  }

  public String getQueryString()
  {
    return this.queryString;
  }

  public String getQueryParameter(String name)
  {
    return this.queryParameters.get(name);
  }

  public String getNamedPathParameter(String name)
  {
    return this.matcher.group(name);
  }

  public void setMatcher(Matcher m)
  {
    this.matcher = m;
  }

  public String getPath()
  {
    return this.adapter.getPath();
  }

  public Configuration getConfiguration()
  {
    return this.configuration;
  }

  public Collection<String> getRequestCookieNames()
  {
    return this.adapter.getRequestCookieNames();
  }

  public String getRequestCookieValue(String name)
  {
    return this.adapter.getCookieValue(name);
  }

  private void parseQueryParameters(String qs)
  {
    if (qs != null && qs.length() > 0)
    {
      String[] tokens = qs.split("&");
      for (String s : tokens)
      {
        String[] kv = s.split("=");
        this.queryParameters.put(kv[0], kv[1]);
      }
    }
  }
}
