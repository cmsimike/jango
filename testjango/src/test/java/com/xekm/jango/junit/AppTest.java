
package com.xekm.jango.junit;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.xekm.jango.adapter.TestAdapter;
import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;
import com.xekm.testapp.TestProject;

@RunWith(JUnit4.class)
public class AppTest
{
  private TestProject testProject;

  @Before
  public void setup()
  {
    testProject = new TestProject();
  }

  @Test
  public void testBasicResponse()
  {
    HttpResponse resp = r("/");
    Assert.assertEquals(resp.getStatus(), 200);
    Assert.assertEquals(resp.getContent(), "Hello, World!");
  }

  @Test
  public void testSetHeader()
  {
    HttpResponse resp = r("/test-header/", "k=1&v=1");

    for (String k : resp.getHeaderNames())
    {
      if ("1".equalsIgnoreCase(k))
      {
        Assert.assertEquals("1", resp.getHeaderValue(k));
        return;
      }
    }
    Assert.assertTrue(false);
  }

  @Test
  public void test301()
  {
    HttpResponse resp = r("/301/");

    for (String k : resp.getHeaderNames())
    {
      if ("Location".equalsIgnoreCase(k))
      {
        Assert.assertEquals("http://www.google.com", resp.getHeaderValue(k));
        return;
      }
    }
    Assert.assertTrue(false);
  }

  @Test
  public void testStringTemplateViewRenderer()
  {
    HttpResponse resp = r("/stvh/");
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("$Hello, World!!!", resp.getContent());
  }

  @Test
  public void testMustacheTemplateViewRenderer()
  {
    HttpResponse resp = r("/mtvh/", "name=mike");
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("<b>mike</b>", resp.getContent());
  }

  @Test
  public void testMustacheTemplateViewFromClasspathRenderer()
  {
    HttpResponse resp = r("/mtvch/", "name=mike3");
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("text/plain", resp.getHeaderValue("Content-Type"));
    Assert.assertEquals("Hello2text, mike3", resp.getContent());
  }

  @Test
  public void testMustacheTemplateHtmlViewFromClasspathRenderer()
  {
    HttpResponse resp = r("/mthvch/", "name=mike17");
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("text/html", resp.getHeaderValue("Content-Type"));
    Assert.assertEquals(
        "<html><head></head><body><div><b>Hello256, mike17</b></div></body></html>",
        resp.getContent());
  }

  @Test
  public void testDebugConfigDump()
  {
    HttpResponse resp = r("/debug/", "name=mike17");
    Assert.assertEquals(200, resp.getStatus());
    Assert.assertEquals("true", resp.getContent());
  }

  private HttpRequest h(String path, String querystring)
  {
    return new HttpRequest(new TestAdapter(path, querystring),
        this.testProject.getConfiguration());
  }

  private HttpResponse r(String path)
  {
    return this.r(path, null);
  }

  private HttpResponse r(String path, String queryString)
  {
    return testProject.handleRequest(h(path, queryString));
  }
}
