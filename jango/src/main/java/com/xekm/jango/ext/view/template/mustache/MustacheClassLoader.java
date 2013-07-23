
package com.xekm.jango.ext.view.template.mustache;

import java.io.Reader;
import java.io.StringReader;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

public class MustacheClassLoader
{
  private String base = "mustache";
  private String path = null;

  public MustacheClassLoader(String path)
  {
    this.path = path;
  }

  public Reader getMustacheTemplate()
  {
    try
    {
      MustacheFactory mf = new DefaultMustacheFactory(this.base);
      return mf.getReader(this.path);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return new StringReader("exception in MustacheClassLoader");
    }
  }
}
