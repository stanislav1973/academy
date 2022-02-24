package socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;
    static Scanner scanner = new Scanner(System.in);

    public void getArrayByteClient(DataOutputStream outputStream, String path) {
        try (FileInputStream inputStream = new FileInputStream(path)) {
            byte[] bytes = new byte[inputStream.available()];
            int length = inputStream.read(bytes);
            outputStream.writeInt(length);
            outputStream.write(bytes);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public String pathFileClient() {
        return System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator + "jetbrains" + File.separator + "src" + File.separator + "socket" + File.separator + "client" + File.separator + "data" + File.separator;
    }
    public void testClient(DataInputStream in, DataOutputStream out, String number) {
        switch (number) {
            case "2":
            case "1":
                try {
                    System.out.print("enter name file ");
                    String fileName = scanner.nextLine();
                    out.writeUTF(fileName);
                    out.writeUTF("save");
                    File file = new File(pathFileClient() + fileName);
                    if(file.isFile()) {
                        getArrayByteClient(out, file.getPath());
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                break;
            case "exit":
                try {
                    out.writeUTF("exit");
                    out.writeUTF("exit");
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                break;
        }
    }

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.print("Enter action (1 - get a file, 2 - save a file, 3 - delete a file): ");
            String number = scanner.nextLine();
            new Client().testClient(input, output, number);
            String answer = input.readUTF();
            String answer1 = input.readUTF();
            if(answer.equals("200")) {
                System.out.print("file save in server id = " + answer1);
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
