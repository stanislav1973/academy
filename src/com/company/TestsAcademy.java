package com.company;

import java.util.Arrays;
import java.util.List;

public class TestsAcademy {
    public static int testInputTextInt(int i) { //2
        List<String> str = Arrays.asList("Destroyer", "Cruiser", "Submarines", "Battleship", "Aircraft Carrier");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                return i;
            }
        }
        return i;
    }

    public static String testInputTextString(int i, int count) {
        String st = "";
        List<String> str = Arrays.asList("Destroyer", "Cruiser", "Submarines", "Battleship", "Aircraft Carrier");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i && count == 3) {
                st = str.get(i);
            } else if (str.indexOf("Cruiser") == i && count == 2) {
                str.set(i, str.get(0));
                st = str.get(0);
            }
        }
        return st;
    }

    public static int lengthShips(int one, int two) {
        return Math.abs(one - two);
    }

    public static String checkShipSunk() {
        String[][] str = new String[7][7];
        String yes = "NO";
        for (String[] strings : str) {
            Arrays.fill(strings, "~");
        }
        //str[0][0] = "O";
        //str[0][1] = "O";
        //str[0][2] = "O";
        //str[0][3] = "O";
        str[0][4] = "O";
        str[0][5] = "O";
        str[0][6] = "O";

        str[0][2] = "O";
        str[1][2] = "O";
        str[2][2] = "O";
        str[3][2] = "O";
        str[4][2] = "O";
        str[5][2] = "O";
        str[6][2] = "O";
        int coordinates1 = 0;
        int coordinates2 = 2;
        String[][] str1 = Arrays.copyOf(str, str.length);
        System.out.print(Arrays.deepToString(str) + "\n");
        int firstCoordinates = coordinates1, twoCoordinates = coordinates2;
        int firstCoordinates1 = coordinates1, twoCoordinates1 = coordinates2;
            for (int j = 0; j < str.length; j++) {
                if (twoCoordinates == 7){
                    twoCoordinates = coordinates2 - 1;
                    break;
                }
                if (str[firstCoordinates][twoCoordinates].equals("O")) {
                    str[firstCoordinates][twoCoordinates] = "X";
                    twoCoordinates++;
                    yes = "YES";
                }
                else if (str[firstCoordinates][twoCoordinates].equals("~")){
                    twoCoordinates = coordinates2 - 1;
                    break;
                }
            }
        for (int j = 0; j < str.length; j++) {
            if(twoCoordinates == -1){
                break;
            }
           else if (str[firstCoordinates][twoCoordinates].equals("O")) {
                str[firstCoordinates][twoCoordinates] = "X";
                twoCoordinates--;
                yes = "YES";
                if(twoCoordinates == -1){
                    break;
                }
            } else if (str[firstCoordinates][twoCoordinates].equals("~")) {
               //twoCoordinates1 = coordinates1 - 1;
                break;
            }
        }
        //vertical
        for (int j = 0; j < str.length; j++) {
            firstCoordinates1++;
            if(firstCoordinates1 == str.length){
                break;
            }
            if (str[firstCoordinates1][twoCoordinates1].equals("O")) {
                str[firstCoordinates1][twoCoordinates1] = "X";
                //firstCoordinates1++;
                yes = "YES";
            } else if (str[firstCoordinates1][twoCoordinates1].equals("~")) {
                break;
            }
        }
        for (int j = 0; j < str.length; j++) {
            firstCoordinates1--;
            if(firstCoordinates1 == -1){
                break;
            }
            if (str[firstCoordinates1][twoCoordinates1].equals("O")) {
                str[firstCoordinates1][twoCoordinates1] = "X";
                yes = "YES";
            } else if (str[firstCoordinates1][twoCoordinates1].equals("~")) {
                break;
            }
        }
        System.out.print(Arrays.deepToString(str));
        return yes;
    }

}
