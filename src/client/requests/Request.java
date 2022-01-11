package client.requests;

public enum Request {
    GET(1), SAVE(2), DELETE(3), EXIT(4);
    private final int request;

    Request(int request) {
        this.request = request;
    }

    public int getRequest() {
        return request;
    }
}
