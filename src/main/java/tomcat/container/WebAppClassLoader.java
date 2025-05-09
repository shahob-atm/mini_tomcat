package tomcat.container;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class WebAppClassLoader extends URLClassLoader {
    public WebAppClassLoader(String webAppPath) throws Exception {
        super(new URL[]{new File(webAppPath + "/WEB-INF/classes").toURI().toURL()});
    }

    public Class<?> loadServletClass(String className) throws ClassNotFoundException {
        return loadClass(className);
    }
}
