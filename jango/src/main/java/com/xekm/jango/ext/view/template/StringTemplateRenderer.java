
package com.xekm.jango.ext.view.template;

public class StringTemplateRenderer
    implements TemplateRenderer
{
  private String template;

  public StringTemplateRenderer(String s)
  {
    this.template = s;
  }

  public String render()
  {
    return this.template;
  }
}
