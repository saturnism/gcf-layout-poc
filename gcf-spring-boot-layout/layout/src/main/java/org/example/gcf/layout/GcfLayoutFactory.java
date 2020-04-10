package org.example.gcf.layout;

import java.io.File;
import org.springframework.boot.loader.tools.Layout;
import org.springframework.boot.loader.tools.LayoutFactory;

public class GcfLayoutFactory implements LayoutFactory {

  @Override
  public Layout getLayout(File source) {
    return new GcfLayout();
  }
}
