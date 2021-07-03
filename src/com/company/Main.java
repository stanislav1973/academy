package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
static int cellsShip = 5;
    public static void inputCoordinates(){
        int count = 5;
        String[][]arr = Battleship.getArray();
        boolean[][] arrBoolean = new boolean[10][10];
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String startCoordinates = scanner.next();
            String endCoordinates1 = scanner.next();

            String  start = startCoordinates.substring(0,1);
            int intStart = Integer.parseInt(startCoordinates.substring(1));

            String end = endCoordinates1.substring(0,1);
            int intEnd = Integer.parseInt(endCoordinates1.substring(1));

            short firstStart = (short) Battleship.transformationCoordinates(start);
            short endStart = (short) Battleship.transformationCoordinates(end);

            String arrayBoolean = AddShips.testArray(arrBoolean,firstStart,intStart,endStart,intEnd);
            if(arrayBoolean.equals("false") && count != 5){
                System.out.print("Error");
                continue;
            }
            int sum = Math.abs(intStart - intEnd) + 1;
            int sum1 = Math.abs(firstStart - endStart) + 1;

            if(!arrBoolean[firstStart][intStart - 1] && !arrBoolean[endStart][intEnd - 1]){
                System.out.print("Error");
                continue;
            }

            if(firstStart != endStart && intStart != intEnd){
                System.out.print("Error! Wrong ship location! Try again:\n");
                continue;
            }

            if((sum != cellsShip ) && (sum1 != cellsShip)) {
                AddShips.inputText1(cellsShip);
                continue;
            }
            count--;
            AddShips.addShipsOnField(firstStart, (short) intStart , endStart, (short) intEnd,arr);

            arrBoolean[firstStart][intStart - 1] = false;
            arrBoolean[endStart][intEnd -1] = false;

            if(count < 1){
                break;
            }
            cellsShip--;
            if(count == 2) {
                cellsShip++;
            }
            AddShips.inputText(cellsShip);
        }
    }
    public static void main(String[] args) {
        Battleship.inputFieldOnConsole();
        AddShips.inputText(cellsShip);
       inputCoordinates();
    }
}














