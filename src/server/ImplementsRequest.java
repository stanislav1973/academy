package server;

import server.requests.MethodRequest;
import server.seriadata.Data;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplementsRequest implements MethodRequest, Serializable {
    private static final long serialVersionUID = 1L;
    Map<String, String> inFile = new TreeMap<>();
   private final Map<String, String> outFile = new TreeMap<>();

    @Override
    public void save(String name, DataInputStream in, DataOutputStream out) {
        boolean flag;
        try {
            flag = in.readBoolean();
            File file = new File(pathFileServer() + name);
            boolean b = file.createNewFile();
            if (b && flag) {
                writeBytes(name, in);
                out.writeInt(200);
            } else if (!flag) {
                out.writeInt(200);
            } else {
                writeBytes(name, in);
                out.writeInt(403);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void get(String nameFile, String byName, DataInputStream inputStream, DataOutputStream outputStream) {
        Data data = new Data();
        try {
            data.read(outFile);
            String string = getOutFile().get(nameFile) != null ? getOutFile().get(nameFile) : nameFile;
            File file = new File(pathFileServer() + string);
            if (file.isFile()) {
                outputStream.writeInt(200);
                if (byName.equals("BY_NAME")) {
                    for (String name : getOutFile().values()) {
                        if (nameFile.equals(name)) {
                            getArrayByteServer(outputStream, pathFileServer() + nameFile);
                        }
                    }
                } else if (byName.equals("BY_ID")) {
                    for (Map.Entry<String, String> key : getOutFile().entrySet()) {
                        if (nameFile.equals(key.getKey())) {
                            nameFile = getOutFile().get(key.getKey());
                            getArrayByteServer(outputStream, pathFileServer() + nameFile);
                        }
                    }
                }
            } else {
                outputStream.writeInt(404);
            }
            outputStream.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public void delete(String nameFile, String byName, DataInputStream inputStream, DataOutputStream outputStream) {
        Data data = new Data();
        try {
            data.read(inFile);
            String string = getInFile().get(nameFile) != null ? getInFile().get(nameFile) : nameFile;
            File file = new File(pathFileServer() + string);
            if (file.isFile()) {
                outputStream.writeInt(200);
                if (byName.equals("BY_NAME")) {
                    for (Map.Entry<String, String> name : getInFile().entrySet()) {
                        if (nameFile.equals(name.getValue())) {
                            getInFile().remove(name.getKey(), name.getValue());
                            boolean b = file.delete();
                            if (b) {
                                ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathFileServer() + "map.data"));
                                stream.writeObject(getInFile());
                            }
                            break;
                        }
                    }
                }
                if(byName.equals("BY_ID")) {
                    for (Map.Entry<String, String> name : getInFile().entrySet()) {
                        if (nameFile.equals(name.getKey())) {
                            getInFile().remove(name.getKey(), name.getValue());
                            boolean b = file.delete();
                            if (b) {
                                ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathFileServer() + "map.data"));
                                stream.writeObject(getInFile());
                            }
                            break;
                        }
                    }
                }
            }
            else {
                outputStream.writeInt(403);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public String pathFileServer() {
        return System.getProperty("user.home") + File.separator + "IdeaProjects" + File.separator + "newserver1" + File.separator + "src" + File.separator + "server" + File.separator + "data" + File.separator;
    }

    public Map<String, String> getOutFile() {
        return outFile;
    }

    public void setOutFile(String id, String nameFile) {
        this.outFile.put(id, nameFile);
    }

    public Map<String, String> getInFile() {
        return inFile;
    }

    public void setInFile(Map<String, String> inFile) {
        this.inFile = inFile;
    }

    private void writeBytes(String name, DataInputStream in) throws IOException {
        int length = in.readInt();
        byte[] message = new byte[length];
        in.readFully(message, 0, message.length);
        DataOutputStream outputStream1 = new DataOutputStream(new FileOutputStream(pathFileServer() + name));
        outputStream1.write(message);
        outputStream1.close();
    }
    public void getArrayByteServer(DataOutputStream outputStream, String pathFile) {
        try (FileInputStream input = new FileInputStream(pathFile)) {
            byte[] bytes = new byte[input.available()];
            int length = input.read(bytes);
                    outputStream.writeInt(length);
                    outputStream.write(bytes);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
}

