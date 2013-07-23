
package com.xekm.testother;

import com.xekm.jango.core.app.JangoApp;
import com.xekm.testother.handler.RunOther;

public class TestOtherApp
    extends JangoApp
{
  public TestOtherApp()
  {
    super();

    this.installRoute("runother/$", new RunOther());
  }

}
