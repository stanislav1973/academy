package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static String str;

    public static String scanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void scannerInput() {
        boolean b = true;
        int count = 0;
        System.out.print("Enter the coordinates: ");
        try {
            Scanner sc = new Scanner(System.in);
            int firstCoordinates = sc.nextInt();
            int twoCoordinates = sc.nextInt();
            Academy.getCoordinates(str, firstCoordinates, twoCoordinates, true,true);
        } catch (InputMismatchException e) {
            System.out.print("You should enter numbers!\n");
            scannerInput();
        }
        catch (RuntimeException e){
            System.out.print("Coordinates should be from 1 to 3!\n");
            scannerInput();
        }
    }

    public static void main(String[] args) {
        str = "         \n";
        Academy.tic_tacCheckString_X_O(str);
        scannerInput();
    }
}






