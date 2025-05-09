package tomcat.http;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Response {
    private final OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setStatus(int statusCode) {
        write("HTTP/1.1 " + statusCode + " OK\r\nContent-Type: text/html\r\n\r\n");
    }

    public void write(String content) {
        try {
            output.write(content.getBytes(StandardCharsets.UTF_8));
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
