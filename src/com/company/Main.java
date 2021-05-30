package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String scanner(){
        Scanner s = new Scanner(System.in);;
        return s.nextLine();
    }
    public static void inputScanner() {
        Scanner s = new Scanner(System.in);
        try {
        String number = s.nextLine();
        String[] i = number.split(" ");
        int first = Integer.parseInt(i[0]);
        int two = Integer.parseInt(i[1]);
            Academy.getCoordinates("___OXX_O_",first,two);
        } catch (NumberFormatException e) {
            System.out.print("You should enter numbers!\n");
            System.out.print("Enter the coordinates: ");
            inputScanner();
        }
        catch (RuntimeException e){
            System.out.print("Coordinates should be from 1 to 3!\n");
            System.out.print("Enter the coordinates: ");
            inputScanner();
        }
    }
    public static void main(String[] args) {
       // String str = scanner();
        Academy.tic_tacCheckString_X_O("___OXX_O_");
        System.out.print("Enter the coordinates: ");
        inputScanner();

    }
}






