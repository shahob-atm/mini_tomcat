package tomcat.connector;

import tomcat.container.DispatcherServlet;
import tomcat.http.Request;
import tomcat.http.Response;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RequestProcessor implements Runnable {
    private final Socket socket;
    private final DispatcherServlet dispatcher;

    public RequestProcessor(Socket socket, DispatcherServlet dispatcher) {
        this.socket = socket;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream(); OutputStream output = socket.getOutputStream()) {
            Request request = new Request(input);
            Response response = new Response(output);
            dispatcher.dispatch(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
