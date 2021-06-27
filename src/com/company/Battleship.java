package com.company;

import java.util.Arrays;

class Battleship {
    public static String[][] getArray(){
        String [][]arr = new String[10][10];
        for (String[] strings : arr) {
            Arrays.fill(strings, "~");
        }
        return arr;
    }
    static void HorizontalMarkup(){
        System.out.print("  1" + " 2" + " 3" + " 4" + " 5" + " 6" + " 7" + " 8" + " 9" + " 10\n");
    }
    static char[] verticalMarkup() {
        char[]charArray = new char[10];
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (65 + i);
        }
        return charArray;
    }
    static void inputFieldByConsole(){
        String[][] arr = Battleship.getArray();
        char[] alphabet = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(alphabet[i]);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }
}
