
package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
static int cellsShip = 5;
    public String scannerInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    public void inputCoordinates(){
        Scanner scanner = new Scanner(System.in);
        int count = 5; // ship input counter
        String[][]arr = Battleship.getArray();
        boolean[][] arrBoolean = Battleship.addArrayBoolean();
        String[][]arrayWithoutShips = Battleship.getArray();
        while (count > 0) {
            // entering the first coordinate
            String startCoordinates = scanner.next();
            // entering the two coordinate
            String endCoordinates1 = scanner.next();
            // separate character from number
            String  start = startCoordinates.substring(0,1);
            String end = endCoordinates1.substring(0,1);

            int intStart = Integer.parseInt(startCoordinates.substring(1)) - 1;
            int intEnd = Integer.parseInt(endCoordinates1.substring(1)) - 1;

            int firstStart =  Battleship.transformationCoordinates(start);
            int endStart =  Battleship.transformationCoordinates(end);

            int sum = Math.abs(intStart - intEnd);
            int sum1 = Math.abs(firstStart - endStart);

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

            if(sum != count - 1 && count == 5 && sum1 != count - 1) {
                System.out.print("Error! Wrong length of the Aircraft Carrier! Try again:\n");
                continue;
            }
            else if (sum != count - 1 && count == 4 && sum1 != count - 1){
                System.out.print("Error! Wrong length of the Battleship! Try again:\n");
                continue;
            }
            else if (sum != count - 1 && count == 3 && sum1 != count - 1){
                System.out.print("Error! Wrong length of the Submarines ! Try again:\n");
                continue;
            }
            else if (sum != count  && count == 2 && sum1 != count){
                System.out.print("Error! Wrong length of the Cruiser! Try again:\n");
                continue;
            }
            else if (count == 1 && sum != count && sum1 != count){
                System.out.print("Error! Wrong length of the Destroyer! Try again:\n");
                continue;
            }

            AddShips.addShipsOnField(firstStart, intStart , endStart, intEnd,arr);

            if(count == 5){
                System.out.print("Enter the coordinates of the Battleship (4 cells):\n");
            }
            else if (count == 4){
                System.out.print("Enter the coordinates of the Submarines (3 cells):\n");
            }
            else if (count == 3){
                System.out.print("Enter the coordinates of the Cruiser (3 cells):\n");
            }
            else if (count == 2){
                System.out.print("Enter the coordinates of the Destroyer (2 cells):\n");
            }
            count--;
            if(count < 1){
                    System.out.printf("%s\n", "The game starts!");
                    AddShips.getEmptyArray();
                    System.out.printf("%s\n", "Take a shot!");
                        new Shot().getShot(arr,arrayWithoutShips);
            }
            AddShips.checkArray(firstStart, intStart, endStart, intEnd, arrBoolean);
        }
    }

    public static void main(String[] args) {
        Battleship.inputFieldOnConsole();
        AddShips.inputText(cellsShip);
       new Main().inputCoordinates();

    }
}

