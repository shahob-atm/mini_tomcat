package tomcat.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Request {
    private final String method;
    private final String path;

    public Request(InputStream input) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();
        String[] parts = line.split(" ");
        this.method = parts[0];
        this.path = parts[1];
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }
}
