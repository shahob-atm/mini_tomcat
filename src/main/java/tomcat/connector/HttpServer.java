package tomcat.connector;

import tomcat.container.DispatcherServlet;
import tomcat.container.ServletRegistry;
import tomcat.container.WebAppClassLoader;
import tomcat.container.WebXmlParser;
import tomcat.servlet.Servlet;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class HttpServer {
    public void start(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        String webAppPath = "src/main/java/tomcat/webapps";
        ServletRegistry registry = new ServletRegistry();
        DispatcherServlet dispatcher = new DispatcherServlet(registry);

        Map<String, String> mappings = WebXmlParser.parse(webAppPath + "/web.xml");
        WebAppClassLoader loader = new WebAppClassLoader(webAppPath);

        for (Map.Entry<String, String> entry : mappings.entrySet()) {
            String path = entry.getKey();
            String className = entry.getValue();
            Class<?> clazz = loader.loadServletClass(className);
            Servlet servlet = (Servlet) clazz.getDeclaredConstructor().newInstance();
            registry.register(path, servlet);
        }

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new RequestProcessor(socket, dispatcher)).start();
        }
    }
}
