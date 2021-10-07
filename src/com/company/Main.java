package com.company;
import battleship.*;
import com.company.list.InputShips;

import java.util.Scanner;
public class Main {
    public static int cellsShip = 0;

    public String scannerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void main(String[] args) throws WrongLengthShipException {
        // new Player1().inputCoordinates();

    }
}
