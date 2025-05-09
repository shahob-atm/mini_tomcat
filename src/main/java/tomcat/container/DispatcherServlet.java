package tomcat.container;

import tomcat.http.Request;
import tomcat.http.Response;
import tomcat.servlet.Servlet;

public class DispatcherServlet {
    private final ServletRegistry registry;

    public DispatcherServlet(ServletRegistry registry) {
        this.registry = registry;
    }

    public void dispatch(Request request, Response response) throws Exception {
        Servlet servlet = registry.getServletByPath(request.getPath());
        if (servlet != null) {
            servlet.service(request, response);
        } else {
            response.setStatus(404);
            response.write("<h1>404 Not Found</h1>");
        }
    }
}
