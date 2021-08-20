package com.company;

import java.util.Arrays;
import java.util.List;

public class TestsAcademy {
    public static int testInputTextInt(int i) { //2
        List<String> str = Arrays.asList("Destroyer", "Cruiser", "Submarines", "Battleship", "Aircraft Carrier");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                return i;
            }
        }
        return i;
    }

    public static String testInputTextString(int i, int count) {
        String st = "";
        List<String> str = Arrays.asList("Destroyer", "Cruiser", "Submarines", "Battleship", "Aircraft Carrier");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i && count == 3) {
                st = str.get(i);
            } else if (str.indexOf("Cruiser") == i && count == 2) {
                str.set(i, str.get(0));
                st = str.get(0);
            }
        }
        return st;
    }

    public static int lengthShips(int one, int two) {
        return Math.abs(one - two);
    }

    public static String[][] checkShipSunk(String line,String[][]arrayWithShips) {
        arrayWithShips[3][4] = "O";
        arrayWithShips[3][5] = "O";

        arrayWithShips[0][4] = "O";
        arrayWithShips[0][5] = "O";
        arrayWithShips[0][6] = "O";

        arrayWithShips[1][2] = "O";
        arrayWithShips[2][2] = "O";
        arrayWithShips[3][2] = "O";
        arrayWithShips[4][2] = "O";

        arrayWithShips[0][0] = "O";
        arrayWithShips[1][0] = "O";
        arrayWithShips[2][0] = "O";
        arrayWithShips[3][0] = "O";

        arrayWithShips[6][0] = "O";
        arrayWithShips[6][1] = "O";
        arrayWithShips[6][2] = "O";

        arrayWithShips[6][4] = "O";
        arrayWithShips[6][5] = "O";
        arrayWithShips[6][6] = "O";
        String firstCoordinatesShot = line.substring(0, 1);
        String twoCoordinatesShot = line.substring(1);
        int coordinate1 = Battleship.transformationCoordinates(firstCoordinatesShot);
        int coordinate2 = Integer.parseInt(twoCoordinatesShot) - 1;

        System.out.print(Arrays.deepToString(arrayWithShips) + "\n");
        int twoCoordinates = coordinate2;
        int firstCoordinates1 = coordinate1;
            for (int j = 0; j < arrayWithShips.length; j++) {
                if (twoCoordinates == 7) {
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
