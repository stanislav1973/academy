package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void mainMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    public static void menuOption_1(int option, String[][] str, int numberRowForPrice, int numberSeatForPrice) {
            if (option == 1) {
                System.out.println("Cinema:");
                for (int i = 1; i < str[0].length + 1; i++) {
                    if (i == 1) {
                        System.out.print("  ");
                    }
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int i = 0; i < str.length; i++) {
                    System.out.print(i + 1);
                    for (int j = 0; j < str[i].length; j++) {
                        str[i][j] = " S";
                        System.out.print(str[i][j]);
                    }
                    System.out.println();
                }
                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("0. Exit");
            }
            if (option == 2) {
                if (str.length * str[0].length <= 60 || numberRowForPrice <= 4) {
                    System.out.print("Ticket price:" + "$" + "10\n");
                } else System.out.print("Ticket price:" + "$" + "8\n");

                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("0. Exit");
            }
        }
    public static void main(String[] args) {
        int numberRowForPrice = 0;
        int numberSeatForPrice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seat = sc.nextInt();
        String[][] str = new String[row][seat];
        mainMenu();
        int option = sc.nextInt();
        if (option == 1) {
            menuOption_1(option, str, numberRowForPrice, numberSeatForPrice);
        }
        if (option == 2) {
            System.out.println("Enter a row number:");
            numberRowForPrice = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            numberSeatForPrice = sc.nextInt();
            menuOption_1(option, str, numberRowForPrice, numberSeatForPrice);
        }
    }
}



