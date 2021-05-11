package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String space = "---------\n";
//        int count = 0;
//        System.out.print("Enter cells:");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        sc.close();
//        char[] t = str.toCharArray() ;
//        System.out.print(space);
//        for (int i = 0; i < 3 ; i++) {
//            System.out.print("| " + t[count++]);
//            System.out.print(" " + t[count++]);
//            System.out.print(" " + t[count++] + " |\n");
//        }
//        System.out.print(space);

        String s = Academy.tic_tacCheckString_X_O("___OXX_O_");
        System.out.print("\n" + s);
    }
}






