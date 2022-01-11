package server;

import server.seriadata.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends ImplementsRequest {
    Data data = new Data();
    final int PORT = 24455;

    protected void getServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                     DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {

                    String nameFile = inputStream.readUTF();
                    if (nameFile.equals("exit")) {
                        break;
                    }
                    String request = inputStream.readUTF();
                    int id = inputStream.readInt();
                    switch (request) {
                        case "SAVE":
                            File file = new File(pathFileServer() + nameFile);
                            if (file.isFile()) {
                                outputStream.writeBoolean(true);
                                outputStream.writeInt(403);
                                break;
                            } else {
                                outputStream.writeBoolean(false);
                            }
                                save(nameFile, inputStream, outputStream);
                                setOutFile(String.valueOf(id), nameFile);
                                data.getBinaryData(id, nameFile);
                                break;
                        case "GET":
                            ExecutorService service = Executors.newFixedThreadPool(4);
                            String byName1;
                            if (id == 1) {
                                byName1 = "BY_NAME";
                            } else {
                                byName1 = "BY_ID";
                            }
                                get(nameFile, byName1, inputStream, outputStream);
                            break;
                        case "DELETE":
                            String byName;
                            if (id == 1) {
                                byName = "BY_NAME";
                            } else {
                                byName = "BY_ID";
                            }
                            delete(nameFile, byName, inputStream, outputStream);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
}

