package com.company;

import java.util.Arrays;
import java.util.List;

public class TestsAcademy {
    public static int testInputTextInt(int i) { //2
        List<String> str = Arrays.asList("Destroyer","Cruiser","Submarines","Battleship","Aircraft Carrier");
        for (int j = 0; j < str.size(); j++) {
            if (str.indexOf(str.get(j)) == i) {
                return i;
            }
        }
        return i;
    }

    public static String testInputTextString(int i, int count) {
        //int count1 = testInputTextInt(count);
        String st = "";
        List<String> str = Arrays.asList("Destroyer","Cruiser","Submarines","Battleship","Aircraft Carrier");
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

}
