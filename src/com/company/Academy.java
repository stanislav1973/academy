package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Academy {
    String findMaximumElementMatrix(int[][] arr) {
        int row = 0;
        int column = 0;
        int max = arr[0][0];

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[k].length; l++) {
                if (arr[k][l] > max) {
                    row = k;
                    column = l;
                    max = arr[k][l];
                }
            }
        }
        return row + " " + column;
    }

    public static void reverse(int[][] array) {

        int[][] arr = new int[3][4];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = array[i].length - 1; j >= 0; j--) {
                arr[i][count] = array[i][j];
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                array[i][j] = arr[i][j];
            }
        }
    }

    //fix the place
    public static int printRow(int[][] array, int number) {
        int row = 0;
        for (int i = 0; i < array.length; i++) {
            int t = 1;
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j - 1] + array[i][j] == 0) {
                    t++;
                }
                if (t >= number) {
                    row = i + 1;
                } else if (array[i][j - 1] < array[i][j]) {
                    t = 1;
                }
            }
            if (row == i + 1) {
                break;
            }
        }
        return row;
    }

    public static String tic_tacCheckString_X_O(String str) {
        int k = 0;
        String space = "---------\n";
        int countXO = 0;
        char[] ch = str.toCharArray();
        System.out.print(space);
        for (int i = 0; i < 3 ; i++) {
            System.out.print("| " + ch[countXO++]);
            System.out.print(" " + ch[countXO++]);
            System.out.print(" " + ch[countXO++] + " |\n");
        }
        System.out.print(space);
        int count = 0;
        String s = "No";
        int i = 0;
        int j = 0;
        char[][] array = new char[3][3];
        boolean b = true;
        while (b) {
            array[i][j] = ch[count];
            if ((array[i][0] == 'X') && (array[i][1] == 'X') && (array[i][2] == 'X')) { k = 3;}
            if ((array[0][j] == 'X') && (array[1][j] == 'X') && (array[2][j] == 'X')) { k = 3; }

            if ((array[0][j] == 'X') && (array[1][1] == 'X') && (array[2][j] == 'X')) { k = 3; }
            if ((array[0][2] == 'X') && (array[1][1] == 'X') && (array[2][0] == 'X')) { k = 3; }
            if(k == 3){ s = "Yes"; b = false;}
            count++; j++;
            if(count == 9){ b= false; }
            if(j > 2 && k != 3){ i++; j = 0; k = 0; System.out.println();}
        }
        return s;
    }
    }
