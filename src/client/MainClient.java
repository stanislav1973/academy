package client;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClient implements Runnable{
    public static void main(String[] args) {
        MainClient client = new MainClient();
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(client);
        service.shutdown();

    }

    @Override
    public void run() {
        Client client = new Client();
        System.out.print("Enter action (1 - get a file, 2 - save a file, 3 - delete a file): ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        client.getClient(number);
    }
}
