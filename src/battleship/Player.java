package battleship;

import com.company.list.InputShips;
import com.company.list.Movement;

import java.util.Arrays;

public class Player {

    private final String[][] array = new String[10][10];
    NewPlayer newPlayer;
    private boolean isBooleans = true;
    public static int countHitPlayer = 0;
    public static int countHitNewPlayer = 0;
    public Player() {
        newPlayer = new NewPlayer();
        for (String[] s : array) {
            Arrays.fill(s, "~");
        }
    }

    public void printField() {
        char[] chars = HelperMethods.verticalMarkup();
        print(chars, array);
    }

    public void print(char[] chars, String[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(chars[i]);
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(" " + arrays[i][j]);
            }
            System.out.println();
        }
    }

    public void addShipsToTheField(PlaceShips placeShips, String[][] arrays) {
        if (placeShips.getFirstCoordinate().getY() > placeShips.getTwoCoordinate().getY()) {
            int i = placeShips.getTwoCoordinate().getY();
            placeShips.getTwoCoordinate().setY(placeShips.getFirstCoordinate().getY());
            placeShips.getFirstCoordinate().setY(i);
        } else if (placeShips.getFirstCoordinate().getX() > placeShips.getTwoCoordinate().getX()) {
            int i = placeShips.getTwoCoordinate().getX();
            placeShips.getTwoCoordinate().setX(placeShips.getFirstCoordinate().getX());
            placeShips.getFirstCoordinate().setX(i);
        }
        if (placeShips.getFirstCoordinate().getX() == placeShips.getTwoCoordinate().getX()) {
            for (int i = placeShips.getFirstCoordinate().getY(); i <= placeShips.getTwoCoordinate().getY(); i++) {
                arrays[placeShips.getFirstCoordinate().getX()][i] = "O";
            }
        } else if (placeShips.getFirstCoordinate().getY() == placeShips.getTwoCoordinate().getY()) {
            for (int i = placeShips.getFirstCoordinate().getX(); i <= placeShips.getTwoCoordinate().getX(); i++) {
                arrays[i][placeShips.getTwoCoordinate().getY()] = "O";
            }
        }
    }

    public boolean checkAdjacentCell(int x, int y, int x1, int y1, boolean b) {
        for (Movement movement : Movement.values()) {
            try {
                if (b) {
                    if (array[x + movement.getX()][y + movement.getY()].equals("O") || array[x1 + movement.getX()][y1 + movement.getY()].equals("O")) {
                        return true;
                    }
                } else {
                    if (newPlayer.newPlayer[x + movement.getX()][y + movement.getY()].equals("O") || newPlayer.newPlayer[x1 + movement.getX()][y1 + movement.getY()].equals("O")) {
                        return true;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        return false;
    }

    public boolean isSizeShip(PlaceShips placeShips, int size) {
        int x = placeShips.getFirstCoordinate().getX();
        int y = placeShips.getFirstCoordinate().getY();
        int x_1 = placeShips.getTwoCoordinate().getX();
        int y_1 = placeShips.getTwoCoordinate().getY();
        return size == Math.abs(x - x_1) + 1 || size == Math.abs(y - y_1) + 1;
    }

    public void checkForInputErrors(int size, boolean b) throws WrongLengthShipException, WrongCloseShipException, WrongLocationException {
        PlaceShips placeShips = PlaceShips.inputTwoCoordinate();
        if (checkAdjacentCell(placeShips.getFirstCoordinate().getX(), placeShips.getFirstCoordinate().getY(), placeShips.getTwoCoordinate().getX(), placeShips.getTwoCoordinate().getY(), b)) {
            throw new WrongCloseShipException();
        }
        if (placeShips.getFirstCoordinate().getX() != placeShips.getTwoCoordinate().getX()
                && placeShips.getFirstCoordinate().getY() != placeShips.getTwoCoordinate().getY()) {
            throw new WrongLocationException();
        }
        if (!isSizeShip(placeShips, size)) {
            throw new WrongLengthShipException();
        }
        if (b) {
            addShipsToTheField(placeShips, array);
        } else {
            addShipsToTheField(placeShips, newPlayer.newPlayer);
        }
    }

    public void startTheGame(boolean b) {
        if (b) {
            printField();
        } else {
            new NewPlayer().printFieldTwo(newPlayer.newPlayer);
        }
        for (InputShips ships : InputShips.values()) {
            System.out.printf("Enter the coordinates of the %s (%d cells)\n", ships.getShip(), ships.getNumberShip());
            while (true) {
                try {
                    checkForInputErrors(ships.getNumberShip(), b);
                    if (b) {
                        printField();
                    } else {
                        new NewPlayer().printFieldTwo(newPlayer.newPlayer);
                    }
                    break;
                } catch (WrongCloseShipException e) {
                    System.out.print("Error! You placed it too close to another one. Try again:\n");
                } catch (WrongLocationException e) {
                    System.out.print("Error! Wrong ship location! Try again:\n");
                } catch (WrongLengthShipException e) {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n", ships.getShip());
                }
            }
        }
    }

    public void getCheckShot() throws WrongLengthShipException {
        HelperMethods.scanner();
        if (isBooleans) {
            new HelperMethods().twoArray(newPlayer.newPlayer);
            HelperMethods.stringDelimiter();
            printField();
            System.out.print("Player 1, it's your turn:\n");
        } else {
            new HelperMethods().twoArray(array);
            HelperMethods.stringDelimiter();
            new NewPlayer().printFieldTwo(newPlayer.newPlayer);
            System.out.print("Player 2, it's your turn:\n");
        }
        Coordinate coordinate = Coordinate.inputOneCoordinate();
        Search search = new Search(coordinate.getX(), coordinate.getY());
        if (isBooleans) {
            isBooleans = false;
            if(checkHit(coordinate, newPlayer.newPlayer)){
                countHitPlayer++;
            }
            newPlayer.getCheckShotTwo(search, coordinate, newPlayer.newPlayer);
        } else {
            isBooleans = true;
            if(checkHit(coordinate, array)){
                countHitNewPlayer++;
            }
            newPlayer.getCheckShotTwo(search, coordinate, array);

        }
    }

   public void getShot() {
        while (true) {
            try {
                getCheckShot();
                break;
            } catch (WrongLengthShipException e) {
                System.out.print("Error! You entered the wrong coordinates! Try again:\n");
            }
        }
    }

    public boolean checkHit(Coordinate coordinate, String[][] arr) {
        return arr[coordinate.getX()][coordinate.getY()].equals("O");
    }
}
