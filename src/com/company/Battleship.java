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
}
