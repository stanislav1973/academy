package com.company;

import com.company.inputships.InputShips;

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
        for (int i = 0; i < array.length; i++) {
            System.out.print(al[i]);
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }

    public static void checkArray(int i0, int j1, int i2, int j3,boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(j1 > j3){
                    int k = j1;
                    j1 = j3;
                    j3 = k;
                }
                 if (i0 > i2){
                    int t = i0;
                    i0 = i2;
                    i2 = t;
                }
                if(!array[i][j]){
                    continue;
                }
                array[i][j] = i < i0 - 1 || i > i2 + 1 || j < j1 - 1 || j > j3 + 1;
            }
        }
    }

}
