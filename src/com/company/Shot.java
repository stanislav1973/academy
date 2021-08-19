package com.company;

public class Shot {

    public void getShot(String[][] arrayWithShips, String[][] arrayWithoutShips) {
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
            if (arrayWithShips[firstCoordinates][twoCoordinates].equals("O")) {
                arrayWithoutShips[firstCoordinates][twoCoordinates] = "X";
                b = true;
            } else if (arrayWithShips[firstCoordinates][twoCoordinates].equals("~")) {
                arrayWithoutShips[firstCoordinates][twoCoordinates] = "M";
                b = false;

            }

            if (b) {
                System.out.print("You hit a ship! Try again:\n");
                count++;
            } else System.out.print("You missed! Try again:\n");

//            for (int i = 0; i < arrayWithShips.length; i++) {
//                for (int j = 0; j < arrayWithShips[i].length; j++) {
//
//                    if (arrayWithShips[firstCoordinates][twoCoordinates].equals("O")) {
//                        arrayWithShips[firstCoordinates][twoCoordinates] = "X";
//                    } else if (arrayWithShips[firstCoordinates][twoCoordinates].equals("~")) {
//                        arrayWithShips[firstCoordinates][twoCoordinates] = "M";
//                    }
//                }
//            }
            if (count == 17) {
                System.out.print("You sank the last ship. You won. Congratulations!");
            }
        }
    }
}
