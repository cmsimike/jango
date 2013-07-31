
package com.xekm.jango.ext.view.template.mustache;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.xekm.jango.ext.view.template.TemplateRenderer;

public class MustacheTemplateRenderer
    implements TemplateRenderer
{

  // TOOD need to fix this so that there is ever only 1 instance of
  // resources.mustache factory
  private Reader              mustacheTemplate;
  private Map<String, String> ctx;

  public MustacheTemplateRenderer(String mustacheTemplate,
      Map<String, String> ctx)
  {
    this.mustacheTemplate = new StringReader(mustacheTemplate);
    this.ctx = ctx;
  }

  public MustacheTemplateRenderer(MustacheClassLoader mustacheTemplate,
      Map<String, String> ctx)
  {
    this.mustacheTemplate = mustacheTemplate.getMustacheTemplate();
    this.ctx = ctx;
  }

  @Override
  public String render()
  {
    StringWriter sWriter = new StringWriter();
    MustacheFactory mf = new DefaultMustacheFactory();
    Mustache mustache = mf.compile(this.mustacheTemplate, "example");
    mustache.execute(sWriter, this.ctx);
    sWriter.flush();
    return sWriter.toString();
  }
}
