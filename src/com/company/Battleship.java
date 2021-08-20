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
    static void inputFieldOnConsole(){
        String[][] arr = Battleship.getArray();
        char[] alphabet = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();
        AddShips.showArray(arr, alphabet);
    }
    static int transformationCoordinates(String startFirst){
        int i;
        int k = 0;
        char j = startFirst.charAt(0);
        char[] h = verticalMarkup();
        for (i = 0; i < h.length; i++) {
            if(h[i] == j){
                k = i;
            }
        }
        return k;
    }
    static boolean[][] addArrayBoolean(){
        boolean[][] arrBoolean = new boolean[10][10];
        for(boolean[]b : arrBoolean){
            Arrays.fill(b,true);
        }
        return arrBoolean;
    }
    public static void getEmptyArray(){
        char[] al = Battleship.verticalMarkup();
        String[][] array = new String[10][10];
        Battleship.HorizontalMarkup();
        for (int i = 0; i < array.length; i++) {
            System.out.print(al[i]);
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "~";
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }
    }
}
