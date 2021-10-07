package battleship;

import java.util.Arrays;

public class HelperMethods {
    private String[][] arr = new String[10][10];

    public HelperMethods() {
        for (String[] s : arr) {
            Arrays.fill(s, "~");
        }
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }

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

    protected void twoArray() {
        char[] chars = HelperMethods.verticalMarkup();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(chars[i]);
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("O")) {
                    arr[i][j] = "~";
                }
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }
}
