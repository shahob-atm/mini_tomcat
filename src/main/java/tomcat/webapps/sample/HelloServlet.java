package tomcat.webapps.sample;

import tomcat.connector.Request;
import tomcat.connector.Response;
import tomcat.servlet.HttpServlet;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(Request request, Response response) throws Exception {
        response.setStatus(200);
        response.write("<html><body><h1>Hello from HelloServlet!</h1></body></html>");
    }
}
