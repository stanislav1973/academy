package com.company;

import java.util.Arrays;
import java.util.List;

public class TestsAcademy {
    public static int testInputTextInt(int i) { //2
        List<String> str = Arrays.asList("Aircraft Carrier ", "Battleship", "Submarines", "Cruiser", "Destroyer");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                return i;
            }
        }
        return i;
    }

    public static String testInputTextString(int i, int count) {
        int count1 = testInputTextInt(count);
        String st = "";
        List<String> str = Arrays.asList("Aircraft Carrier", "Battleship", "Submarines", "Cruiser", "Destroyer");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i) {
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i && count1 == 3) {
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i && count1 == 2) {
                str.set(i, str.get(count1));
                st = str.get(i);
            } else if (str.indexOf(str.get(j)) == i) {
                st = str.get(i);
            }
       }
        return st;
    }
    public static int lengthShips(int firstS, int firstE, int twoS, int twoE) {
        int sum = firstS + twoS;
        int sum1 = firstE + twoE;
        return sum1 + 1;
    }
}
