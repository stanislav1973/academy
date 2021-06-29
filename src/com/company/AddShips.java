package com.company;

import java.util.Arrays;

public class AddShips {
    public static void inputText(int i) {
            System.out.print("Enter the coordinates of the Aircraft Carrier (" + i + " cells):\n");
    }


    public static void addShipsOnField(short startOfFirstCoordinates, short startOfTwoCoordinates, short endOfFirstCoordinates, short endOfTwoCoordinates,String[][]array) {
        char[] alphabet = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();
        short startTwo = (short)(startOfTwoCoordinates - 1);
        short endTwo = (short) (endOfTwoCoordinates - 1);
        int countVertical = startTwo;
        int countVertical_1 = startTwo;
        int countHorizontal = startOfFirstCoordinates;
        int countHorizontal_1 = startOfFirstCoordinates;

        while (startOfFirstCoordinates == endOfFirstCoordinates && countVertical <= endTwo){
            array[startOfFirstCoordinates][countVertical] = "O";
            countVertical++;
        }
        while (startOfFirstCoordinates == endOfFirstCoordinates && countVertical_1 >= endTwo){
            array[endOfFirstCoordinates][countVertical_1] = "O";
            countVertical_1--;
        }
        while (countHorizontal <= endOfFirstCoordinates && startTwo == endTwo){
            array[countHorizontal][startTwo] = "O";
            countHorizontal++;
        }
        while (countHorizontal_1 >= endOfFirstCoordinates && startTwo == endTwo){
            array[countHorizontal_1][startTwo] = "O";
            countHorizontal_1--;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
    // Tests
    public static String test(String s){
        return s.substring(7);
    }
    public static int test1(String s){
        return Integer.parseInt(s.substring(5));
    }
    public static short test2(int i, int k){
        return (short) Math.abs(i - k);
    }
    public static String[][] testArray(String [][]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "~";
            }
        }
        return array;
    }
}
