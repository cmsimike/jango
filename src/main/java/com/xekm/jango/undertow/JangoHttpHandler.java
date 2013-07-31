
package com.xekm.jango.undertow;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.JangoCookie;
import com.xekm.jango.core.project.JangoProject;

import java.nio.channels.FileChannel;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;

public class JangoHttpHandler
    implements HttpHandler
{
  public JangoProject project;

  public JangoHttpHandler(JangoProject project)
  {
    this.project = project;
  }

  @Override
  public void handleRequest(HttpServerExchange exchange) throws Exception
  {
    HttpResponse response = this.project.handleRequest(new HttpRequest(
        new UnderTowAdapter(exchange), this.project.getConfiguration()));
    exchange.setResponseCode(response.getStatus());
    for (String k : response.getHeaderNames())
    {
      exchange.getResponseHeaders().put(new HttpString(k),
          response.getHeaderValue(k));
    }
    for (JangoCookie c : response.getCookies())
    {
      exchange.setResponseCookie(new UnderTowAdapter.ExchangeCookie(c));
    }
    exchange.getResponseSender().send(response.getContent());
    exchange.endExchange();
  }
}
