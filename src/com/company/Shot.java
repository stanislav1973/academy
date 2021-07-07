package com.company;
public class Shot {

    public void getShot(String[][] array) {
        char[] al = Battleship.verticalMarkup();
        int count = 0;
        boolean b = false;
        while (count < 3) {
            String line = new Main().scannerInput();
            String firstCoordinatesShot = line.substring(0, 1);
            char symbol = firstCoordinatesShot.charAt(0);
            String twoCoordinatesShot = line.substring(1);
            int firstCoordinates = Battleship.transformationCoordinates(firstCoordinatesShot);
            int twoCoordinates = Integer.parseInt(twoCoordinatesShot) - 1;
            if (symbol > 75 || symbol < 65 || twoCoordinates < 0 || twoCoordinates > 9) {
                System.out.printf("%s", "Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            Battleship.HorizontalMarkup();
            for (int i = 0; i < array.length; i++) {
                System.out.print(al[i]);
                for (int j = 0; j < array[i].length; j++) {
                    if (array[firstCoordinates][twoCoordinates].equals("O")) {
                        array[firstCoordinates][twoCoordinates] = "X";
                        count = 2;
                        b = true;
                    } else if (array[firstCoordinates][twoCoordinates].equals("~")) {
                        array[firstCoordinates][twoCoordinates] = "M";
                        count = 2;
                        b = false;
                    }
                    System.out.print(" " + array[i][j]);
                }
                System.out.println();
            }
            if(b){
                System.out.print("You hit a ship!\n");
            }
            else System.out.print("You missed!\n");
            count++;
        }
    }
}
