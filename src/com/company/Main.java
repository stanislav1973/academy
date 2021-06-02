package com.company;
import java.util.Scanner;

public class Main {
        public static int[] scannerInput() {
        int[] arr = new int[2];
        Scanner sc = new Scanner(System.in);
        try {
            String s = sc.nextLine();
            String[]strAr = s.split(" ");
            arr[0] = Integer.parseInt(strAr[0]);
            arr[1] = Integer.parseInt(strAr[1]);

        } catch (NumberFormatException e) {
            System.out.print("You should enter numbers!\n");
            System.out.print("Enter the coordinates: ");
            return scannerInput();
        }
        if(arr[0] > 3 || arr[1] > 3){
            System.out.print("Coordinates should be from 1 to 3!\n");
            System.out.print("Enter the coordinates: ");
            return scannerInput();
        }
        return arr;
    }
    public static void main(String[] args) {
        String str = "         \n";
        Academy.tic_tacCheckString_X_O(str);
        int[]arr = scannerInput();
        Academy.getCoordinates(str, arr[0], arr[1], true, true);
    }

}










