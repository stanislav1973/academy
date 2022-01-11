package client;

import client.requests.MethodRequest;
import client.requests.Request;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplementsRequest implements MethodRequest {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void save(DataInputStream inputStream, DataOutputStream outputStream) {

        System.out.print("Enter name of the file: ");
        try {
            boolean answer;
            String nameFile = scanner.next();
            outputStream.writeUTF(nameFile);
            outputStream.writeUTF(Request.SAVE.name());
            int id = new Random().nextInt();
            outputStream.writeInt(id);

            System.out.print("Enter name of the file to be saved on server: ");
            scanner.nextLine();
            scanner.nextLine();
            System.out.print("The request was sent.\n");
            File file = new File(pathFileClient() + nameFile);
            answer = inputStream.readBoolean();
            if (file.isFile()) {
                if(!answer) {
                    outputStream.writeBoolean(true);
                    getArrayByteClient(outputStream, pathFileClient() + nameFile);
                }
            } else {
                outputStream.writeBoolean(false);
            }

            int code = inputStream.readInt();
            outputStream.close();
            inputStream.close();
            if (code == 200) {
                System.out.print("Response says that file is saved! ID = " + id);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void get(DataInputStream inputStream, DataOutputStream outputStream) {
        System.out.print("Do you want to get the file by name or by id (1 - name, 2 - id): ");
        try {
            int code;
            String id = scanner.next();
            if(id.equals("1")) {
                System.out.print("Enter name ");
                String nameFile = scanner.next();
                    outputStream.writeUTF(nameFile);
                    outputStream.writeUTF(Request.GET.name());
                    outputStream.writeInt(1);
                    System.out.print("The request was sent.\n");
                    code = inputStream.readInt();
                    if (code == 200) {
                        writeBytesClient(inputStream);
                    }
            }
            else if(id.equals("2")) {
                System.out.print("Enter id ");
                String nameFile = scanner.next();
                outputStream.writeUTF(nameFile);
                outputStream.writeUTF(Request.GET.name());
                outputStream.writeInt(2);
                System.out.print("The request was sent.\n");
                code = inputStream.readInt();
                if(code == 200) {
                    writeBytesClient(inputStream);
                }
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void delete(DataInputStream inputStream, DataOutputStream outputStream) {
        int code;
        System.out.print("Do you want to delete the file by name or by id (1 - name, 2 - id): ");
        try {
            String id = scanner.next();
            if(id.equals("1")) {
                System.out.print("Enter name ");
                String nameFile = scanner.next();
                outputStream.writeUTF(nameFile);
                outputStream.writeUTF(Request.DELETE.name());
                outputStream.writeInt(1);
                System.out.print("The request was sent.\n");
                code = inputStream.readInt();
                if(code == 200) {
                    System.out.print("The response says that this file was deleted successfully!");
                }
                else {
                    System.out.print("The response says that this file is not found!");
                }
            }
            else if(id.equals("2")) {
                System.out.print("Enter id ");
                String idFile = scanner.next();
                outputStream.writeUTF(idFile);
                outputStream.writeUTF(Request.DELETE.name());
                outputStream.writeInt(2);
                System.out.print("The request was sent.\n");
                code = inputStream.readInt();
                if(code == 200) {
                    System.out.print("The response says that this file was deleted successfully!");
                }
                else {
                    System.out.print("The response says that this file is not found!");
                }
            }
            outputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public String pathFileClient() {
        return System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator + "newserver1" + File.separator + "src" + File.separator + "client" + File.separator + "data" + File.separator;
    }

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
    private void writeBytesClient(DataInputStream in) {
       // ExecutorService service = Executors.newFixedThreadPool(4);
        //service.submit(() -> {
            try {
                int length = in.readInt();
                byte[] message = new byte[length];
                in.readFully(message, 0, message.length);
                System.out.print("The file was downloaded! Specify a name for it: ");
                String nameFile = scanner.next();
                DataOutputStream outputStream1 = new DataOutputStream(new FileOutputStream(pathFileClient() + nameFile));
                outputStream1.write(message);
                System.out.print("File saved on the hard drive!");
                outputStream1.close();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
       // });
       // service.shutdown();
    }
}
