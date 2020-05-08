package org.example.gcf.loader;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.jar.JarFile;

public class GcfLauncher extends JarLauncher implements HttpFunction {
  private final HttpFunction delegate;
  private ClassLoader loader;

  public GcfLauncher() throws Exception {
    JarFile.registerUrlProtocolHandler();

    loader = createClassLoader(getClassPathArchives());

    Class<?> clazz = loader
        .loadClass("org.springframework.cloud.function.adapter.gcloud.FunctionInvoker");
    delegate = (HttpFunction) clazz.getConstructor().newInstance();
  }
  @Override
  public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
  	Thread.currentThread().setContextClassLoader(loader);
    delegate.service(httpRequest, httpResponse);
  }
}
