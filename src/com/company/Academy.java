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
        boolean b_X = false;
        boolean b_O = false;
        final char X = 'X';
        final char O = 'O';
        int countX = 0;
        int countO = 0;
        int count_ = 0;
        String answer = "";
        for(char t : ch){
            if(t == X){
                countX++;
            }
            if(t == O){
                countO++;
            }
            if(t == '_'){
                count_++;
            }
        }

        if((ch[0] == X && ch[1] == X && ch[2] == X) || (ch[3] == X && ch[4] == X && ch[5] == X) || (ch[6] == X && ch[7] == X && ch[8] == X)
        && Math.abs(countX - countO) < 2){
        answer = "X wins";
            b_X = true;
        }
        if((ch[0] == X && ch[3] == X && ch[6] == X) || (ch[1] == X && ch[4] == X && ch[7] == X) || (ch[2] == X && ch[5] == X && ch[8] == X)
                && Math.abs(countX - countO) < 2){
            answer = "X wins";
            b_X = true;
        }
        if((ch[0] == X && ch[4] == X && ch[8] == X) || (ch[2] == X && ch[4] == X && ch[6] == X)
                && Math.abs(countX - countO) < 2){
            answer = "X wins";
            b_X = true;
        }

        if((ch[0] == O && ch[1] == O && ch[2] == O) || (ch[3] == O && ch[4] == O && ch[5] == O) || (ch[6] == O && ch[7] == O && ch[8] == O)
                && Math.abs(countX - countO) < 2){
            answer = "O wins";
            b_O = true;
        }
        if((ch[0] == O && ch[3] == O && ch[6] == O) || (ch[1] == O && ch[4] == O && ch[7] == O) || (ch[2] == O && ch[5] == O && ch[8] == O)
                && Math.abs(countX - countO) < 2){
            answer = "O wins";
            b_O = true;
        }
        if((ch[0] == O && ch[4] == O && ch[8] == O) || (ch[2] == O && ch[4] == O && ch[6] == O)
                && Math.abs(countX - countO) < 2){
            answer = "O wins";
            b_X = true;
        }
        if (b_X && b_O  || Math.abs(countX - countO) > 1) {
            answer = "Impossible";
        }
        if(!b_X && !b_O && count_ > 0 && Math.abs(countX - countO) < 2){
            answer = "Game not finished";
        }
        if(!b_X && !b_O && count_ < 1 && Math.abs(countX - countO) < 2){
            answer = "Draw";
        }
        return answer;
    }
}