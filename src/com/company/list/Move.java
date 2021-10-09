package com.company.list;

public enum Move {
    UP(0,1),
    LIFT(-1,0),
    RIGHT(1,0),
    DOWN(0,-1);

    private final int x;
    private final int y;

    Move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Move turn() {
        switch (this){
            case UP:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return LIFT;
            default: return UP;
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
