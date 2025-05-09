package tomcat.container;

import tomcat.servlet.Servlet;

import java.util.HashMap;
import java.util.Map;

public class ServletRegistry {
    private final Map<String, Servlet> servletMap = new HashMap<>();

    public void register(String path, Servlet servlet) {
        servletMap.put(path, servlet);
    }

    public Servlet getServletByPath(String path) {
        return servletMap.get(path);
    }
}
