package com.company;

import java.util.Arrays;

public class Shot {

    public void getShot(String[][] arrayWithShips, String[][] arrayWithoutShips) {
        String[][] a = Battleship.getArray();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (arrayWithShips[i][j].equals("O")) {
                    a[i][j] = "O";
                }
            }
        }
        char[] al = Battleship.verticalMarkup();
        int count = 0;
        boolean b = false;
        while (count < 17) {
            String line = new Main().scannerInput();
            String firstCoordinatesShot = line.substring(0, 1);
            char symbol = firstCoordinatesShot.charAt(0);
            String twoCoordinatesShot = line.substring(1);
            int firstCoordinates = Battleship.transformationCoordinates(firstCoordinatesShot);
            int twoCoordinates = Integer.parseInt(twoCoordinatesShot) - 1;
            if (symbol > 75 || symbol < 65 || twoCoordinates < 0 || twoCoordinates > 9) {
                System.out.printf("%s", "Error! You entered the wrong coordinates! Try again:\n");
                continue;
            }
            Battleship.HorizontalMarkup();
            for (int i = 0; i < arrayWithoutShips.length; i++) {
                System.out.print(al[i]);
                for (int j = 0; j < arrayWithoutShips[i].length; j++) {
                    if (arrayWithShips[firstCoordinates][twoCoordinates].equals("O")) {
                        arrayWithoutShips[firstCoordinates][twoCoordinates] = "X";
                        arrayWithShips[firstCoordinates][twoCoordinates] = "X";
                        b = true;
                        count++;
                    } else if (arrayWithShips[firstCoordinates][twoCoordinates].equals("~")) {
                        arrayWithoutShips[firstCoordinates][twoCoordinates] = "M";
                        b = false;
                    }
                    System.out.print(" " + arrayWithoutShips[i][j]);
                }
                System.out.println();
            }
            if (count == 17 && Arrays.deepEquals(checkShipSunk(a, line), arrayWithShips)) {
                System.out.print("You sank the last ship. You won. Congratulations!");
                    count++;
            } else if (b && Arrays.deepEquals(checkShipSunk(a, line), arrayWithShips)) {
                System.out.print("You sank a ship! Specify a new target:\n");

            } else if (b) {

                System.out.print("You hit a ship! Try again:\n");

            } else System.out.print("You missed! Try again:\n");
        }

    }

    public static String[][] checkShipSunk(String[][] arrayWithShips, String line) {
        String firstCoordinatesShot = line.substring(0, 1);
        String twoCoordinatesShot = line.substring(1);
        int coordinate1 = Battleship.transformationCoordinates(firstCoordinatesShot);
        int coordinate2 = Integer.parseInt(twoCoordinatesShot) - 1;

        int twoCoordinates = coordinate2;
        int firstCoordinates1 = coordinate1;
        for (int j = 0; j < arrayWithShips.length; j++) {
            if (twoCoordinates == arrayWithShips.length) {
                twoCoordinates = coordinate2 - 1;
                break;
            }
            if (arrayWithShips[coordinate1][twoCoordinates].equals("O")) {
                arrayWithShips[coordinate1][twoCoordinates] = "X";
                twoCoordinates++;

            } else if (arrayWithShips[coordinate1][twoCoordinates].equals("~")) {
                twoCoordinates = coordinate2 - 1;
                break;
            }
        }
        for (int j = 0; j < arrayWithShips.length; j++) {
            if (twoCoordinates == -1) {
                break;
            } else if (arrayWithShips[coordinate1][twoCoordinates].equals("O")) {
                arrayWithShips[coordinate1][twoCoordinates] = "X";
                twoCoordinates--;
                if (twoCoordinates == -1) {
                    break;
                }
            } else if (arrayWithShips[coordinate1][twoCoordinates].equals("~")) {
                break;
            }
        }
        //vertical
        for (int j = 0; j < arrayWithShips.length; j++) {
            firstCoordinates1++;
            if (firstCoordinates1 == arrayWithShips.length) {
                break;
            }
            if (arrayWithShips[firstCoordinates1][coordinate2].equals("O")) {
                arrayWithShips[firstCoordinates1][coordinate2] = "X";
            } else if (arrayWithShips[firstCoordinates1][coordinate2].equals("~")) {
                break;
            }
        }
        for (int j = 0; j < arrayWithShips.length; j++) {
            firstCoordinates1--;
            if (firstCoordinates1 == -1) {
                break;
            }
            if (arrayWithShips[firstCoordinates1][coordinate2].equals("O")) {
                arrayWithShips[firstCoordinates1][coordinate2] = "X";
            } else if (arrayWithShips[firstCoordinates1][coordinate2].equals("~")) {
                break;
            }
        }
        return arrayWithShips;
    }

}
