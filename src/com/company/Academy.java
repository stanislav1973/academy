package com.company;

import java.util.InputMismatchException;
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

            if (array[firstCoordinates - 1][twoCoordinates - 1] == ' ' && moveX) {
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
            if (array[firstCoordinates - 1][twoCoordinates - 1] == ' ' && moveO) {
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
            String endGame = theEndInput(array);
            if (endGame.equals("X wins") || endGame.equals("O wins")) {
                System.out.print(endGame);
                break;
            }
            countGame++;
            if (countGame == 9) {
                break;
            }
            System.out.print("Enter the coordinates: ");
                int[]arr = Main.scannerInput();
                firstCoordinates = arr[0];
                twoCoordinates = arr[1];
        }
    }

    public static String theEndInput(char[][] array) {
        final char X = 'X';
        final char O = 'O';
        int count = 0;
        char[] ch = new char[9];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                ch[count++] = array[i][j];
            }
        }
        String answer = "";
        if ((ch[0] == X && ch[1] == X && ch[2] == X) || (ch[3] == X && ch[4] == X && ch[5] == X) || (ch[6] == X && ch[7] == X && ch[8] == X)) {
            answer = "X wins";
        }
        if ((ch[0] == X && ch[3] == X && ch[6] == X) || (ch[1] == X && ch[4] == X && ch[7] == X) || (ch[2] == X && ch[5] == X && ch[8] == X)) {
            answer = "X wins";
        }
        if ((ch[0] == X && ch[4] == X && ch[8] == X) || (ch[2] == X && ch[4] == X && ch[6] == X)) {
            answer = "X wins";
        }

        if ((ch[0] == O && ch[1] == O && ch[2] == O) || (ch[3] == O && ch[4] == O && ch[5] == O) || (ch[6] == O && ch[7] == O && ch[8] == O)) {
            answer = "O wins";
        }
        if ((ch[0] == O && ch[3] == O && ch[6] == O) || (ch[1] == O && ch[4] == O && ch[7] == O) || (ch[2] == O && ch[5] == O && ch[8] == O)) {
            answer = "O wins";
        }
        if ((ch[0] == O && ch[4] == O && ch[8] == O) || (ch[2] == O && ch[4] == O && ch[6] == O)) {
            answer = "O wins";
        }
        return answer;
    }
}

