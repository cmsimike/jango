
package com.xekm.jango.ext.view.http;

import com.xekm.jango.core.http.HttpResponse;
import com.xekm.jango.ext.view.template.TemplateRenderer;

public class TemplateViewResponse
    extends HttpResponse
{
  public TemplateViewResponse(TemplateRenderer view)
  {
    super(view.render());
    this.addHeader("Content-Type", "text/plain");
  }
}
