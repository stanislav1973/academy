package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        System.out.print("Enter cells:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] t = str.toCharArray() ;
        System.out.print("---------\n");

        for (int i = 0; i < 3 ; i++) {
            System.out.print("| " + t[count++]);
            System.out.print(" " + t[count++]);
            System.out.print(" " + t[count++] + " |");
            System.out.print("\n");
        }
        System.out.print("---------");
        }
    }





