package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][]arr = Battleship.getArray();
        short count = 3;
        Scanner scanner = new Scanner(System.in);
        Battleship.inputFieldOnConsole();
        AddShips.inputData(count);

        while (scanner.hasNext()) {
            count--;
            String startCoordinates = scanner.next();
            String endCoordinates1 = scanner.next();
            String[] start = startCoordinates.split("");
            String[] end = endCoordinates1.split("");

            if(start.length == 2 && end.length == 2) {
            short firstStartCoordinates = (short) Battleship.transformationStartFirstCoordinates(start[0]);
            short twoStartCoordinates = (short) Battleship.transformationStartTwoCoordinates(start[1]);
            short firstEndCoordinates = (short) Battleship.transformationEndFirstCoordinates(end[0]);
            short twoEndCoordinates = (short) Battleship.transformationEndTwoCoordinates(end[1]);
            //System.out.print(firstStartCoordinates + " " + twoStartCoordinates + "\n");
            AddShips.addShipsOnField(firstStartCoordinates, twoStartCoordinates , firstEndCoordinates,twoEndCoordinates,arr);
            }
            else if(start.length > 2 && end.length > 2) {
                String newString = startCoordinates.substring(1,3);
                String newString1 = endCoordinates1.substring(1,3);
                int newInt = Integer.parseInt(newString);
                int newInt1 = Integer.parseInt(newString1);
                short firstStartCoordinates = (short) Battleship.transformationStartFirstCoordinates(start[0]);
                short firstEndCoordinates = (short) Battleship.transformationEndFirstCoordinates(end[0]);
                AddShips.addShipsOnField(firstStartCoordinates,(short) newInt , firstEndCoordinates,(short) newInt1, arr);
            }
            else if (start.length > 2 && end.length == 2) {
                String newString = new Scanner(startCoordinates).next().substring(1,3);
                int newInt = Integer.parseInt(newString);
                short firstStartCoordinates = (short) Battleship.transformationStartFirstCoordinates(start[0]);
                short firstEndCoordinates = (short) Battleship.transformationEndFirstCoordinates(end[0]);
                short twoEndCoordinates = (short) Battleship.transformationEndTwoCoordinates(end[1]);
                AddShips.addShipsOnField(firstStartCoordinates,(short) newInt , firstEndCoordinates, twoEndCoordinates, arr);
            }
            else if (start.length == 2 && end.length > 2){
                String newString1 = new Scanner(endCoordinates1).next().substring(1,3);
                int newInt1 = Integer.parseInt(newString1);
                short firstStartCoordinates = (short) Battleship.transformationStartFirstCoordinates(start[0]);
                short twoStartCoordinates = (short) Battleship.transformationStartTwoCoordinates(start[1]);
                short firstEndCoordinates = (short) Battleship.transformationEndFirstCoordinates(end[0]);
                AddShips.addShipsOnField(firstStartCoordinates,twoStartCoordinates, firstEndCoordinates, (short) newInt1, arr);
            }
            if(count < 1){
                break;
            }
            AddShips.inputData(count);

        }
    }
}














