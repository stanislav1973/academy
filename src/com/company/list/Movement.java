package com.company.list;

public enum Movement {
    A(1,1),
    B(0,1),
    C(-1,1),
    D(1,0),
    E(-1,0),
    G(0,-1),
    J(1,-1),
    I(-1,-1);
    private final int x;
    private final int y;

    Movement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
