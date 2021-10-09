package battleship;

import com.company.list.Move;

public class Search {
    private int stepX;
    private int stepY;
    Move move;

    public Search(int x, int y) {
        this.move = Move.UP;
        this.stepX = x;
        this.stepY = y;
    }

    void turnSearch() {
        this.move = move.turn();
    }

    public void search() {
        stepX = stepX + move.getX();
        stepY = stepY + move.getY();
    }

    public int getStepX() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX = stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY = stepY;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public boolean isSearchHorizontal(Search coordinate, String[][] arr) {
        int x = coordinate.stepX;
        int y = coordinate.stepY;
            try {
            while (!arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                search();
                if (arr[coordinate.stepX][coordinate.stepY].equals("O")) {
                    return true;
                }
                if (arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                    turnSearch();
                    search();
                    try {
                    while (!arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                        search();
                        if (arr[coordinate.stepX][coordinate.stepY].equals("O")) {
                            return true;
                        }
                    }
                    } catch (ArrayIndexOutOfBoundsException ignore){}
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {

        }
        coordinate.stepX = x;
        coordinate.stepY = y;
        return false;
    }

    public boolean isSearchVertical(Search coordinate, String[][] arr) {
        turnSearch();
        try {
            while (!arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                search();
                if (arr[coordinate.stepX][coordinate.stepY].equals("O")) {
                    return true;
                }
                if (arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                    turnSearch();
                    search();
                    try {
                        while (!arr[coordinate.stepX][coordinate.stepY].equals("~")) {
                            search();

                            if (arr[coordinate.stepX][coordinate.stepY].equals("O")) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {}
                }
            }
        } catch (ArrayIndexOutOfBoundsException ignore) {}
        return false;
    }
}
