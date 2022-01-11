package server.requests;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public interface MethodRequest {
    void save(String name, DataInputStream in, DataOutputStream out);
    void get(String name, String byName, DataInputStream in, DataOutputStream out);
    void delete(String name, String byName, DataInputStream in, DataOutputStream out);
}
