package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][]arr = Battleship.getArray();
        short count = 2;
        Scanner scanner = new Scanner(System.in);
        Battleship.inputFieldOnConsole();
        AddShips.inputData(count);

        while (scanner.hasNext()) {
            count--;
            String startCoordinates = scanner.next();
            String endCoordinates1 = scanner.next();
            String[] start = startCoordinates.split("");
            String[] end = endCoordinates1.split("");
            short firstStartCoordinates = (short) Battleship.transformationStartFirstCoordinates(start[0]);
            short twoStartCoordinates = (short) Battleship.transformationStartTwoCoordinates(start[1]);
            short firstEndCoordinates = (short) Battleship.transformationEndFirstCoordinates(end[0]);
            short twoEndCoordinates = (short) Battleship.transformationEndTwoCoordinates(end[1]);
            System.out.print(firstStartCoordinates + " " + twoStartCoordinates + "\n");
            AddShips.addShipsOnField(firstStartCoordinates, twoStartCoordinates , firstEndCoordinates,twoEndCoordinates,arr);
            if (count < 1) {
                break;
            }
            AddShips.inputData(count);

        }
    }
}














