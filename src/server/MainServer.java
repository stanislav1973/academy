package server;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServer implements Runnable{
    public static void main(String[] args) {
        MainServer server = new MainServer();
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(server);
        service.shutdown();

    }

    @Override
    public void run() {
        System.out.print("Start server\n");
        Server server = new Server();
        server.getServer();
    }
}
