package battleship;

import java.util.Scanner;

public class PlaceShips {
    final private Coordinate firstCoordinate;
    final private Coordinate twoCoordinate;

    public PlaceShips(String firstCoordinate, String twoCoordinate) {
        Coordinate coordinate = new Coordinate(firstCoordinate);
        Coordinate coordinate1 = new Coordinate(twoCoordinate);
        this.firstCoordinate = coordinate;
        this.twoCoordinate = coordinate1;
    }

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }

    public Coordinate getTwoCoordinate() {
        return twoCoordinate;
    }

    public static PlaceShips inputTwoCoordinate() throws WrongLengthShipException {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.next();
        String two = scanner.next();
        String s = one.substring(1);
        String s1 = two.substring(1);
        int integer = Integer.parseInt(s) - 1;
        int integer1 = Integer.parseInt(s1) - 1;
        if (integer > 9 || integer < 0 || integer1 > 9 || integer1 < 0) {
            throw new WrongLengthShipException();
        }
        return new PlaceShips(one, two);
    }
}
