package tomcat.servlet;

import tomcat.http.Request;
import tomcat.http.Response;

public interface Servlet {
    void service(Request request, Response response) throws Exception;
}
