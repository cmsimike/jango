
package com.xekm.jango.core.http;

import java.util.Date;

public class JangoCookie
{
  private String  name     = null;
  private String  value    = null;
  private String  path     = "/";
  private String  domain   = null;
  private Integer maxAge   = null;
  private boolean discard  = false;
  private boolean secure   = false;
  private int     version  = 0;
  private boolean httpOnly = false;
  private Date    expires  = null;
  private String  comment  = null;

  public JangoCookie(String name, String value)
  {
    this.name = name;
    this.value = value;
  }

  public String getName()
  {
    return this.name;
  }

  public String getValue()
  {
    return this.value;
  }

  public JangoCookie setValue(String value)
  {
    this.value = value;
    return this;
  }

  public String getPath()
  {
    return this.path;
  }

  public JangoCookie setPath(String path)
  {
    this.path = path;
    return this;
  }

  public String getDomain()
  {
    return this.domain;
  }

  public JangoCookie setDomain(String domain)
  {
    this.domain = domain;
    return this;
  }

  public Integer getMaxAge()
  {
    return this.maxAge;
  }

  public JangoCookie setMaxAge(Integer maxAge)
  {
    this.maxAge = maxAge;
    return this;
  }

  public boolean isDiscard()
  {
    return this.discard;
  }

  public JangoCookie setDiscard(boolean discard)
  {
    this.discard = discard;
    return this;
  }

  public boolean isSecure()
  {
    return this.secure;
  }

  public JangoCookie setSecure(boolean secure)
  {
    this.secure = secure;
    return this;
  }

  public int getVersion()
  {
    return this.version;
  }

  public JangoCookie setVersion(int version)
  {
    this.version = version;
    return this;
  }

  public boolean isHttpOnly()
  {
    return this.httpOnly;
  }

  public JangoCookie setHttpOnly(boolean httpOnly)
  {
    this.httpOnly = httpOnly;
    return this;
  }

  public Date getExpires()
  {
    return this.expires;
  }

  public JangoCookie setExpires(Date expires)
  {
    this.expires = expires;
    return this;
  }

  public String getComment()
  {
    return this.comment;
  }

  public JangoCookie setComment(String comment)
  {
    this.comment = comment;
    return this;
  }
}
