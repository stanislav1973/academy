package battleship;

import java.util.Arrays;

public class HelperMethods {

    public static void HorizontalMarkup() {
        System.out.print("  1" + " 2" + " 3" + " 4" + " 5" + " 6" + " 7" + " 8" + " 9" + " 10\n");
    }

    public static char[] verticalMarkup() {
        char[] charArray = new char[10];
        HelperMethods.HorizontalMarkup();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (65 + i);
        }
        return charArray;
    }

    protected void twoArray(String[][]arr) {
        char[] chars = HelperMethods.verticalMarkup();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(chars[i]);
            for (int j = 0; j < arr[i].length; j++) {
                String cell = arr[i][j];
                if (cell.equals("O")) {
                   System.out.print(" ~");
                }
               else { System.out.print(" " + cell);}
            }
            System.out.println();
        }
    }
}
