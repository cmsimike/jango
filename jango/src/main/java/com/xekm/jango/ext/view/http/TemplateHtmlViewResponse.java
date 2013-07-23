
package com.xekm.jango.ext.view.http;

import com.xekm.jango.ext.view.template.TemplateRenderer;

public class TemplateHtmlViewResponse
    extends TemplateViewResponse
{
  public TemplateHtmlViewResponse(TemplateRenderer view)
  {
    super(view);
    this.addHeader("Content-Type", "text/html");
  }
}
