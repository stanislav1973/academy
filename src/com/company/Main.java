package com.company;
import players.Player1;

import java.util.Scanner;
public class Main {
    public static int cellsShip = 0;
    public String scannerInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static void main(String[] args) {

new Player1().inputCoordinates();

    }
}

