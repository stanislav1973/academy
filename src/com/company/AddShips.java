package com.company;

public class AddShips {
    public static void inputData(int i) {
        System.out.print("Enter the coordinates of the Aircraft Carrier (" + i + " cells):\n");
    }

    public static void addShipsOnField(short startOfFirstCoordinates, short startOfTwoCoordinates, short endOfFirstCoordinates, short endOfTwoCoordinates,String[][]array) {
        char[] alphabet = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();
        short startTwo = (short)(startOfTwoCoordinates - 1);
        short endTwo = (short) (endOfTwoCoordinates - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < array[i].length; j++) {
                if(startOfFirstCoordinates == i && startTwo <= endTwo && endOfFirstCoordinates == i) {
                        array[startOfFirstCoordinates][startTwo] = "O";
                    startTwo++;
                }
                if(startTwo == j && endTwo == j && startOfFirstCoordinates <= endOfTwoCoordinates){
                    array[startOfFirstCoordinates][endTwo] = "O";
                    startOfFirstCoordinates++;
                }
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
}
