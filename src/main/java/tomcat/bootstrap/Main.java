package tomcat.bootstrap;

import tomcat.connector.HttpServer;

public class Main {
    public static void main(String[] args) throws Exception {
        new HttpServer().start(8080);
    }
}
