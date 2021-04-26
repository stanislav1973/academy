package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int currentIncome;
    protected static String[][] stringArray;

    public static void mainMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void menuOption_1(int option, String[][] str, int numberRowForPrice, int numberSeatForPrice, int countTicket) {
        stringArray = str;
        int row = str.length;
        int seat = str[0].length;
        int count = 1;
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
                System.out.print(count++);
                for (int j = 0; j < str[i].length; j++) {
                    if (numberRowForPrice - 1 == i && numberSeatForPrice - 1 == j && stringArray[i][j] == null) {
                        stringArray[i][j] = " B";
                        System.out.print(str[i][j]);
                        continue;
                    } else if (numberRowForPrice != 0 && numberSeatForPrice != 0 && i == (numberRowForPrice - 1) && j == (numberSeatForPrice - 1)) {
                        String y = stringArray[i][j].replace(" S", " B");
                        stringArray[i][j] = y;
                        System.out.print(stringArray[i][j]);
                        continue;
                    } else if (stringArray[i][j] != null && stringArray[i][j].equals(" B")) {
                        stringArray[i][j] = " B";
                        System.out.print(stringArray[i][j]);
                        continue;
                    }
                    stringArray[i][j] = " S";
                    System.out.print(stringArray[i][j]);
                }
                System.out.println();
            }
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
        }
        if (option == 2) {
            if (stringArray.length * stringArray[0].length <= 60 || numberRowForPrice <= 4) {
                currentIncome = currentIncome + 10;
                //stringArray[numberRowForPrice - 1][numberSeatForPrice - 1] = " B";
                System.out.printf("Ticket price: $%d\n", 10);
            } else {
                currentIncome = currentIncome + 8;
                //stringArray[numberRowForPrice - 1][numberSeatForPrice - 1] = " B";
                System.out.printf("Ticket price: $%d\n", 8);
            }

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
        }
        if (option == 3) {
            String p = "%";
            System.out.printf("Number of purchased tickets: %d\n", countTicket);
            float percentage = (float) (100 * countTicket) / (seat * row);
            System.out.printf("Percentage: %.2f%s\n", percentage, p);

            System.out.printf("Current income $%d\n", currentIncome);
            String s = String.format("Total income: $%d\n", (row * seat) * 10);
            System.out.print(s);

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
        }
    }

    public static void main(String[] args) {
        int numberRowForPrice = 0;
        int numberSeatForPrice = 0;
        int countTicket = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seat = sc.nextInt();
        String[][] str = new String[row][seat];
        mainMenu();
        int option = sc.nextInt();
        while (option != 0) {
            if (option == 2) {
                System.out.println("Enter a row number:");
                numberRowForPrice = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                numberSeatForPrice = sc.nextInt();

                if(str[numberRowForPrice - 1][numberSeatForPrice - 1] == null){
                    str[numberRowForPrice - 1][numberSeatForPrice - 1] = " B";
                    menuOption_1(option, str, numberRowForPrice, numberSeatForPrice, countTicket);
                    countTicket++;
                }
               else if(str[numberRowForPrice - 1][numberSeatForPrice - 1].equals(" B")){
                    System.out.println("That ticket has already been purchased!");
                    System.out.println("Enter a row number:");
                    numberRowForPrice = sc.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    numberSeatForPrice = sc.nextInt();
                }
                else  menuOption_1(option, str, numberRowForPrice, numberSeatForPrice, countTicket);
                countTicket++;
            }
            if (option == 1) {
                menuOption_1(option, str, numberRowForPrice, numberSeatForPrice, countTicket);
            }
            if (option == 3) {
                menuOption_1(option, str, numberRowForPrice, numberSeatForPrice, countTicket);
            }
            option = sc.nextInt();
        }
    }
}



