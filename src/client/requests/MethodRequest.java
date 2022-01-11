package client.requests;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public interface MethodRequest {
    void save(DataInputStream in, DataOutputStream out);
    void get(DataInputStream in, DataOutputStream out);
    void delete(DataInputStream in, DataOutputStream out);
}
