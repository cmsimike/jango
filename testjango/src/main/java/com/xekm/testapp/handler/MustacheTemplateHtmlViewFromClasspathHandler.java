
package com.xekm.testapp.handler;

import java.util.HashMap;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.core.http.exception.JangoException;
import com.xekm.jango.core.http.handler.BaseHandler;
import com.xekm.jango.ext.view.http.TemplateHtmlViewResponse;
import com.xekm.jango.ext.view.template.mustache.MustacheClassLoader;
import com.xekm.jango.ext.view.template.mustache.MustacheTemplateRenderer;

public class MustacheTemplateHtmlViewFromClasspathHandler
    extends BaseHandler
{

  @Override
  public HttpResponse handle(final HttpRequest request) throws JangoException
  {
    return new TemplateHtmlViewResponse(new MustacheTemplateRenderer(
        new MustacheClassLoader("junit/index3.mustache"),
        new HashMap<String, String>()
        {
          {
            put("name", request.getQueryParameter("name"));
          }
        }));
  }
}
