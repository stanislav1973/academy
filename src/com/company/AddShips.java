package com.company;

import battleship.Player;

public class AddShips {

    public static void addShipsOnField(int startOfFirstCoordinates, int startOfTwoCoordinates, int endOfFirstCoordinates,int endOfTwoCoordinates, String[][] array) {
        char[] al = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();

        int countHorizontales = startOfTwoCoordinates;
        int countHorizontales_1 = startOfTwoCoordinates;
        int countVertical = startOfFirstCoordinates;
        int countVertical_1 = startOfFirstCoordinates;

        while (countHorizontales <= endOfTwoCoordinates) {
            array[startOfFirstCoordinates][countHorizontales] = "O";
            countHorizontales++;
        }
        while (countHorizontales_1 >= endOfTwoCoordinates) {
            array[endOfFirstCoordinates][countHorizontales_1] = "O";
            countHorizontales_1--;
        }
        while (countVertical <= endOfFirstCoordinates) {
            array[countVertical][startOfTwoCoordinates] = "O";
            countVertical++;
        }
        while (countVertical_1 >= endOfFirstCoordinates) {
            array[countVertical_1][startOfTwoCoordinates] = "O";
            countVertical_1--;
        }
        showArray(array, al);
    }

    public static void showArray(String[][] array, char[] al) {
        Player.print(al, array);
    }
}
    
