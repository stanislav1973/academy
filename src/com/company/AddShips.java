package com.company;

public class AddShips {
    public static void inputText(int i) {
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
                if(startTwo == j && endTwo == j && startOfFirstCoordinates <= endOfFirstCoordinates){
                    array[startOfFirstCoordinates][endTwo] = "O";
                    startOfFirstCoordinates++;
                }
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    public static String test(String s){
        return s.substring(7);
    }
    public static int test1(String s){
        return Integer.parseInt(s.substring(5));
    }
    public static short test2(int i, int k){
        return (short) Math.abs(i - k);
    }

}
