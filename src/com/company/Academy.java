package com.company;

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
        for (int i = 0; i < array.length ; i++) {
            int count = 0;
            for (int j = array[i].length - 1; j >= 0; j--) {
                arr[i][count] = array[i][j];
                count++;
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                array[i][j] = arr[i][j];
            }
        }
    }
    public static void printCorners(int[][]array){
        int[][]arr = new int[2][2];
        int row = 0;
        for (int i = 0; i < arr.length ; i++) {
            int count = array.length;
            for (int j = 0; j < arr[i].length ; j++) {
                arr[i][j] = array[row][array.length - count];
                count  = count - 2;
            }
            row = arr.length;
        }

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                array[i][j] = arr[i][j];
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}