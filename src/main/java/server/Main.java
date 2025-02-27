package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.MainServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet();
        Server server = new Server(8080);


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainServlet), "/mirror");

        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}