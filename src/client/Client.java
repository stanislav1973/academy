package client;

import client.requests.Request;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client extends ImplementsRequest {
    final String API_ADDRESS = "127.0.0.1";
    final int PORT = 24455;

    public void getClient() {
        System.out.print("Enter action (1 - get a file, 2 - save a file, 3 - delete a file): ");
        try (
                Scanner scanner = new Scanner(System.in);
                Socket socket = new Socket(API_ADDRESS, PORT);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

            String integer = scanner.next();

            switch (integer) {
                case "1":
                  get(inputStream, outputStream);
                    break;
                case "2":
                    save(inputStream, outputStream);
                    break;
                case "3":
                    delete(inputStream, outputStream);
                    break;
                case "exit":
                    System.out.print("The request was sent.");
                    outputStream.writeUTF("exit");
                    break;
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
