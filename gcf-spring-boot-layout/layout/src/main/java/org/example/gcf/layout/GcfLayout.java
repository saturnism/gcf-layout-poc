package org.example.gcf.layout;

import java.io.IOException;
import org.springframework.boot.loader.tools.CustomLoaderLayout;
import org.springframework.boot.loader.tools.Layouts;
import org.springframework.boot.loader.tools.LibraryScope;
import org.springframework.boot.loader.tools.LoaderClassesWriter;

public class GcfLayout extends Layouts.Jar implements CustomLoaderLayout {

  @Override
  public String getLauncherClassName() {
    return "org.example.gcf.loader.GcfLauncher";
  }

  @Override
  public boolean isExecutable() {
    return false;
  }

  @Override
  public void writeLoadedClasses(LoaderClassesWriter writer) throws IOException {
    writer.writeLoaderClasses();
    writer.writeLoaderClasses("META-INF/loader/loader.jar");
  }
}
