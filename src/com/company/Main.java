package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
static int cellsShip = 5;

    public static void inputCoordinates(){
        int count = 5;
        String[][]arr = Battleship.getArray();
        boolean[][] arrBoolean = Battleship.checkArrayBoolean();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String startCoordinates = scanner.next();
            String endCoordinates1 = scanner.next();
            String  start = startCoordinates.substring(0,1);
            int intStart = Integer.parseInt(startCoordinates.substring(1)) - 1;

            String end = endCoordinates1.substring(0,1);
            int intEnd = Integer.parseInt(endCoordinates1.substring(1)) - 1;

            short firstStart = (short) Battleship.transformationCoordinates(start);
            short endStart = (short) Battleship.transformationCoordinates(end);


            int sum = Math.abs(intStart - intEnd) + 1;
            int sum1 = Math.abs(firstStart - endStart) + 1;


            if(firstStart != endStart && intStart != intEnd){
                System.out.print("Error! Wrong ship location! Try again:\n");
                continue;
            }

            if(!arrBoolean[firstStart][intStart]){
                System.out.print("Error! You placed it too close to another one. Try again:\n");
                continue;
            }
            if(!arrBoolean[endStart][intEnd]){
                System.out.print("Error! You placed it too close to another one. Try again:\n");
                continue;
            }

            if((sum != cellsShip ) && (sum1 != cellsShip)) {
                AddShips.inputText1(cellsShip);
                continue;
            }
            count--;
            AddShips.addShipsOnField(firstStart, (short) intStart , endStart, (short) intEnd,arr);

            if(count < 1){
                break;
            }
            cellsShip--;
            if(count == 2){
                cellsShip++;
            }
            AddShips.inputText(cellsShip);
            AddShips.checkArray(firstStart,intStart,endStart,intEnd,arrBoolean);
        }
    }
    public static void main(String[] args) {
        Battleship.inputFieldOnConsole();
        AddShips.inputText(cellsShip);
       inputCoordinates();
    }
}














