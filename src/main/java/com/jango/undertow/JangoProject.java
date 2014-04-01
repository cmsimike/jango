package com.jango.undertow;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public abstract class JangoProject implements HttpHandler {
  private static String OPTIONS_PORT = "port";
  private static int OPTIONS_PORT_DEFAULT = 8080;

  @Override
  public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {

  }

  private CommandLine parseCommandLine(String[] args) {
    try {
      Options options = new Options();
      options.addOption(OPTIONS_PORT, true, "the port to listen to");

      GnuParser parser = new GnuParser();
      CommandLine cmd = parser.parse(options, args);
      return cmd;
    } catch (ParseException e) {
      System.err.println(e);
    }
    return null;
  }

  public void run(String[] args) {
    CommandLine cmd = this.parseCommandLine(args);
    if (cmd == null) {
      throw new Error("ugh");
    }

    String port = cmd.getOptionValue(OPTIONS_PORT, Integer.toString(OPTIONS_PORT_DEFAULT));

    System.err.println("port read is: " + port);

    Undertow server = Undertow.builder()
        .addHttpListener(8080, "localhost")
        .setHandler(new HttpHandler() {
          @Override
          public void handleRequest(final HttpServerExchange exchange) throws Exception {
//            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
//            exchange.getResponseSender().send("Hello World");
          }
        }).build();
    server.start();
  }
}
