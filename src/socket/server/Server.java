package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        System.out.print("Start server");
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                DataInputStream input = new DataInputStream(socket.getInputStream());
                service.submit(() -> {
                    try {
                        String file = input.readUTF();
                        new Session(socket).test(input, output, file);
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                });
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        service.shutdown();
    }
}

class Session {
    Socket socket;
    public Session(Socket socket) {
        this.socket = socket;
    }

    public String pathFileServer() {
        return System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator + "jetbrains" + File.separator + "src" + File.separator + "socket" + File.separator + "server" + File.separator + "data" + File.separator;
    }
    protected void writeBytes(String name, DataInputStream in) throws IOException {
        int length = in.readInt();
        byte[] message = new byte[length];
        in.readFully(message, 0, message.length);
        DataOutputStream outputStream1 = new DataOutputStream(new FileOutputStream(pathFileServer() + name, false));
        outputStream1.write(message);
        outputStream1.close();
    }
    public void test(DataInputStream in, DataOutputStream out, String file) throws IOException {
        String option = in.readUTF();
        switch (option) {
            case "save":
            case "get":
                File f = new File(pathFileServer() + file);
                if(!f.isFile()) {
                    writeBytes(file, in);
                    message(out, "200", String.valueOf(new Random(2).nextInt()));
                }
                break;
            case "exit":
                message(out, option, file);
                Runtime.getRuntime().exit(0);
                break;
            default:
                System.out.print("input again");
        }
        socket.close();
        out.close();
    }
    void message(DataOutputStream out, String option, String file) {
        try {
            out.writeUTF(option);
            out.writeUTF(file);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
