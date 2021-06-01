package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[0];
    public static void scanner() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static int[] scannerInput() {
        Scanner sc = new Scanner(System.in);
        try {
            arr = new int[2];
            String s = sc.nextLine();
            String[]strAr = s.split(" ");
            int firstCoordinates = Integer.parseInt(strAr[0]);
            int twoCoordinates = Integer.parseInt(strAr[1]);
            arr[0] = firstCoordinates;
            arr[1] = twoCoordinates;
        } catch (NumberFormatException e) {
            System.out.print("You should enter numbers!\n");
            System.out.print("Enter the coordinates: ");
            scannerInput();
        }
        return arr;
    }
        public static void inputMethod() {
                System.out.print("Enter the coordinates: ");
            try {
                arr = scannerInput();
            } catch (RuntimeException e) {
                System.out.print("This cell is occupied! Choose another one!\n");
                scannerInput();
            }
        }
    public static void main(String[] args) {
        String str = "         \n";
        Academy.tic_tacCheckString_X_O(str);
        inputMethod();
        Academy.getCoordinates(str, arr[0], arr[1], true, true);
    }
}








