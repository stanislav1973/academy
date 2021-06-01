package com.company;

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

    public static void tic_tacCheckString_X_O(String str) {
        String space = "---------\n";
        int countXO = 0;
        char[] ch = str.toCharArray();
        System.out.print(space);
        for (int i = 0; i < 3; i++) {
            System.out.print("| " + ch[countXO++]);
            System.out.print(" " + ch[countXO++]);
            System.out.print(" " + ch[countXO++] + " |\n");
        }
        System.out.print(space);
    }

    public static void getCoordinates(String str, int firstCoordinates, int twoCoordinates, boolean moveX, boolean moveO) {
        int countGame = 0;
            String space = "---------\n";
            char[] ch = str.toCharArray();
            int count = 0;
            char[][] array = new char[3][3];
            for (int k = 0; k < array.length; k++) {
                for (int l = 0; l < array[k].length; l++) {
                    array[k][l] = ch[count++];
                }
            }
        while (countGame < 9) {
            if (array[firstCoordinates - 1][twoCoordinates - 1] == 'X' || array[firstCoordinates - 1][twoCoordinates - 1] == 'O') {
                System.out.print("This cell is occupied! Choose another one!\n");
                countGame--;
            }

            if (array[firstCoordinates - 1][twoCoordinates - 1] == ' '&& moveX) {
                System.out.print(space);
                for (int i = 0; i < array.length; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < array[i].length; j++) {
                        if (i == firstCoordinates - 1 && j == twoCoordinates - 1 && array[i][j] == ' ') {
                            moveX = false;
                            array[firstCoordinates - 1][twoCoordinates - 1] = 'X';
                            System.out.print(array[firstCoordinates - 1][twoCoordinates - 1] + " ");
                            continue;
                        }
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println("|");
                }
                System.out.print(space);
            }
            if (array[firstCoordinates - 1][twoCoordinates - 1] == ' '&& moveO) {
                System.out.print(space);
                for (int i = 0; i < array.length; i++) {
                    System.out.print("| ");
                    for (int j = 0; j < array[i].length; j++) {
                        if (i == firstCoordinates - 1 && j == twoCoordinates - 1 && array[i][j] == ' ') {
                            moveX = true;
                            array[firstCoordinates - 1][twoCoordinates - 1] = 'O';
                            System.out.print(array[firstCoordinates - 1][twoCoordinates - 1] + " ");
                            continue;
                        }
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println("|");
                }
                System.out.print(space);
            }

            countGame ++;
            if(countGame == 9){
                break;
            }
            System.out.print("Enter the coordinates: ");
           String s =  Main.scanner();
           String[] strArray = s.split(" ");
           firstCoordinates = Integer.parseInt(strArray[0]);
           twoCoordinates = Integer.parseInt(strArray[1]);

        }
    }
}
