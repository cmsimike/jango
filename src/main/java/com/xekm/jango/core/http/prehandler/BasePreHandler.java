
package com.xekm.jango.core.http.prehandler;

import com.xekm.jango.core.http.HttpRequest;
import com.xekm.jango.core.http.HttpResponse;

public abstract class BasePreHandler
{

  /**
   * <p>
   * Allows each handler to have distinct checks before
   * {@link com.xekm.jango.core.http.handler.BaseHandler#handle(com.xekm.jango.core.http.HttpRequest)}
   * is called.
   * </p>
   * <p>
   * If an {@link com.xekm.jango.core.http.HttpResponse} is returned, the
   * response is returned right away. TODO decide if the middleware chaion
   * should be called.
   * </p>
   * 
   * @param request
   * @return An {@link HttpResponse} which will prevent the
   * {@link com.xekm.jango.core.http.handler.BaseHandler#handle(com.xekm.jango.core.http.HttpRequest)}
   * from being called, or null which will allow the request to continue to
   * {@link com.xekm.jango.core.http.handler.BaseHandler#handle(com.xekm.jango.core.http.HttpRequest)}
   */
  public abstract HttpResponse preHandle(HttpRequest request);
}
