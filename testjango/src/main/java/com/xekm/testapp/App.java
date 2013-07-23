
package com.xekm.testapp;

import com.xekm.jango.undertow.JangoHttpHandler;
import io.undertow.Undertow;

public class App
{

  public static void main(final String[] args)
  {
    Undertow server = Undertow.builder().addListener(8080, "localhost").setHandler(
        new JangoHttpHandler(new TestProject())).build();
    server.start();
  }
}
