package battleship;

import com.company.list.InputShips;
import com.company.list.Movement;

import java.util.Arrays;

public class Player {
    private final String[][] array = new String[10][10];
    HelperMethods helperMethods;

    public Player() {
        helperMethods = new HelperMethods();
        for (String[] s : array) {
            Arrays.fill(s, "~");
        }
    }

    public void printField() {
        char[] chars = HelperMethods.verticalMarkup();
        print(chars, array);
    }

    public static void print(char[] chars, String[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(chars[i]);
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public void addShipsToTheField(PlaceShips placeShips) {
        if(placeShips.getFirstCoordinate().getY() > placeShips.getTwoCoordinate().getY()){
            int i  = placeShips.getTwoCoordinate().getY();
            placeShips.getTwoCoordinate().setY(placeShips.getFirstCoordinate().getY());
            placeShips.getFirstCoordinate().setY(i);
        }
        else if(placeShips.getFirstCoordinate().getX() > placeShips.getTwoCoordinate().getX()){
            int i = placeShips.getTwoCoordinate().getX();
            placeShips.getTwoCoordinate().setX(placeShips.getFirstCoordinate().getX());
            placeShips.getFirstCoordinate().setX(i);
        }
        if (placeShips.getFirstCoordinate().getX() == placeShips.getTwoCoordinate().getX()) {
            for (int i = placeShips.getFirstCoordinate().getY(); i <= placeShips.getTwoCoordinate().getY(); i++) {
                array[placeShips.getFirstCoordinate().getX()][i] = "O";
            }
        }
        else if(placeShips.getFirstCoordinate().getY() == placeShips.getTwoCoordinate().getY()){
            for (int i = placeShips.getFirstCoordinate().getX(); i <= placeShips.getTwoCoordinate().getX(); i++) {
                array[i][placeShips.getTwoCoordinate().getY()] = "O";
            }
        }
    }

    protected boolean checkAdjacentCell(int x, int y) {
        for (Movement movement : Movement.values()) {
            try {
                if (array[x + movement.getX()][y + movement.getY()].equals("O")) {
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
        }
        return false;
    }

    protected boolean isSizeShip(PlaceShips placeShips,int size) {
        int x = placeShips.getFirstCoordinate().getX();
        int y = placeShips.getFirstCoordinate().getY();
        int x_1 = placeShips.getTwoCoordinate().getX();
        int y_1 = placeShips.getTwoCoordinate().getY();
        return size == Math.abs(x - x_1) + 1 || size == Math.abs(y - y_1) + 1;
    }

    protected void checkForInputErrors(int size) throws WrongLengthShipException, WrongCloseShipException, WrongLocationException {
        PlaceShips placeShips = PlaceShips.inputTwoCoordinate();

        if(checkAdjacentCell(placeShips.getFirstCoordinate().getX(),placeShips.getFirstCoordinate().getY())){
            throw new WrongCloseShipException();
        }
        if(placeShips.getFirstCoordinate().getX() != placeShips.getTwoCoordinate().getX()
                && placeShips.getFirstCoordinate().getY() != placeShips.getTwoCoordinate().getY()){
            throw new WrongLocationException();
        }
        if (!isSizeShip(placeShips,size)) {
            throw new WrongLengthShipException();
        }
        addShipsToTheField(placeShips);
    }

    protected void startTheGame(){
        printField();
        for (InputShips ships : InputShips.values()) {
            System.out.printf("Enter the coordinates of the %s (%d cells)\n",ships.getShip(),ships.getNumberShip());
            while (true) {
                try {
                    checkForInputErrors(ships.getNumberShip());
                    printField();
                    break;
                }  catch (WrongCloseShipException e) {
                    System.out.print("Error! You placed it too close to another one. Try again:\n");
                } catch (WrongLocationException e) {
                    System.out.print("Error! Wrong ship location! Try again:\n");
                } catch (WrongLengthShipException e) {
                    System.out.printf("Error! Wrong length of the %s! Try again:\n",ships.getShip());
                }
            }
        }
    }
    protected void getCheckShot() throws WrongLengthShipException{
        Coordinate coordinate = Coordinate.inputOneCoordinate();
        if(array[coordinate.getX()][coordinate.getY()].equals("O")){
            array[coordinate.getX()][coordinate.getY()] = "X";
            helperMethods.setArr(array);
            helperMethods.twoArray();
            System.out.print("You hit a ship!\n");
        }
        else { array[coordinate.getX()][coordinate.getY()] = "M";
            helperMethods.setArr(array);
            helperMethods.twoArray();
        System.out.print("You missed!\n");
        }
        printField();
    }
    void getShot(){
        while (true) {
            try {
                getCheckShot();
                break;
            } catch (WrongLengthShipException e) {
                System.out.print("Error! You entered the wrong coordinates! Try again:\n");
            }
        }
    }
}
