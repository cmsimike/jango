
package com.xekm.testapp;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.Configuration;

import com.xekm.jango.core.project.JangoProject;
import com.xekm.testother.TestOtherApp;

public class TestProject
    extends JangoProject
{
  public TestProject()
  {
    super();
  }

  @Override
  public Configuration getConfiguration()
  {
    BaseConfiguration config = new BaseConfiguration();
    config.setProperty("debug", "true");
    return config;
  }

  @Override
  public void installApps(Configuration config)
  {
    this.installApp("^/", new TestApp());
    this.installApp("/mount/", new TestOtherApp());
  }

}
