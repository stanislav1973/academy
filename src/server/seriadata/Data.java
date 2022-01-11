package server.seriadata;

import server.ImplementsRequest;

import java.io.*;
import java.util.Map;

public class Data extends ImplementsRequest {
    public void write(Map<String, String> map) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(pathFileServer() + "map.data");
        ObjectOutputStream stream = new ObjectOutputStream(outputStream);
        stream.writeObject(map);
        stream.close();
        outputStream.close();
    }

    public void read(Map<String, String> map) throws IOException {
        FileInputStream stream = new FileInputStream(pathFileServer() + "map.data");
        ObjectInputStream inputStream = new ObjectInputStream(stream);
        try {
            Object o = inputStream.readObject();
            String str = o.toString().replace("{", "").replace("}", "").
                    replace(",", "").replace("=", " ");
            String[] arr = str.split("\\s");
            int count = 0;
            for (int i = 1; i < arr.length; i += 2) {
                map.put(arr[count], arr[i]);
                count = count + 2;
            }
        } catch (ClassNotFoundException e) {
            System.out.print(e.getMessage());
        }
        inputStream.close();
    }

   public void getBinaryData(int id, String nameFile) {
        File fileMap = new File(pathFileServer() + "map.data");
        try {
            boolean b1 = fileMap.createNewFile();
            if (b1) {
                setOutFile(String.valueOf(id), nameFile);
                write(getOutFile());
            }
            if (!b1) {
                read(getOutFile());
                setOutFile(String.valueOf(id), nameFile);
                write(getOutFile());
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
