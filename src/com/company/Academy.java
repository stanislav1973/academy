package com.company;

public class Academy {
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
        System.out.print("Enter the coordinates: ");
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
                System.out.print("Draw");
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
