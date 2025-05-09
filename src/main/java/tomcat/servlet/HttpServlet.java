package tomcat.servlet;

import tomcat.http.Request;
import tomcat.http.Response;

public class HttpServlet implements Servlet {
    @Override
    public void service(Request request, Response response) throws Exception {
        String method = request.getMethod();
        if ("GET".equalsIgnoreCase(method)) {
            doGet(request, response);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(request, response);
        } else {
            response.setStatus(501);
            response.write("<h1>501 Method Not Implemented</h1>");
        }
    }

    protected void doGet(Request request, Response response) throws Exception {
        response.setStatus(501);
        response.write("<h1>501 Not Implemented</h1>");
    }

    protected void doPost(Request request, Response response) throws Exception {
        response.setStatus(501);
        response.write("<h1>501 Not Implemented</h1>");
    }
}
