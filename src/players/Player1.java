package players;

import com.company.AddShips;
import com.company.Battleship;
import com.company.Main;
import com.company.Shot;

import java.util.Scanner;

import static com.company.Main.cellsShip;

public class Player1 extends InputCoordinatesShip {
   private static String[][] arrayPlayer1;

    public static String[][] getArrayPlayer1() {
        return arrayPlayer1;
    }

    @Override
    public void inputCoordinates() {
        System.out.print("Player 1, place your ships on the game field\n");
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        arrayPlayer1 = Battleship.getArray();
        boolean[][] arrayPlayer1Boolean = Battleship.addArrayBoolean();
        char[] al = Battleship.verticalMarkup();
        AddShips.showArray(arrayPlayer1,al);
        Battleship.inputText(cellsShip);
        String[][]arrayWithoutShips = Battleship.getArray();
        while (count > 0) {
            String startCoordinates = scanner.next();
            // entering the two coordinate
            String endCoordinates1 = scanner.next();
            // separate character from number
            String  start = startCoordinates.substring(0,1);
            String end = endCoordinates1.substring(0,1);

            int firstStart =  Battleship.transformationCoordinates(start); // первая координата (char)
            int intStart = Integer.parseInt(startCoordinates.substring(1)) - 1; // первая координата (int)

            int endStart =  Battleship.transformationCoordinates(end); // вторая координата (char)
            int intEnd = Integer.parseInt(endCoordinates1.substring(1)) - 1; // вторая координата (int)

            int sub = Math.abs(intStart - intEnd);
            int sub1 = Math.abs(firstStart - endStart);

            if(firstStart != endStart && intStart != intEnd){
                System.out.print("Error! Wrong ship location! Try again:\n");
                continue;
            }

            if(!arrayPlayer1Boolean[firstStart][intStart]){
                System.out.print("Error! You placed it too close to another one. Try again:\n");
                continue;
            }
            if(!arrayPlayer1Boolean[endStart][intEnd]){
                System.out.print("Error! You placed it too close to another one. Try again:\n");
                continue;
            }
            if(sub != count - 1 && count == 5 && sub1 != count - 1) {
                Battleship.errorInputText(cellsShip);
                continue;
            }
            else if (sub != count - 1 && count == 4 && sub1 != count - 1){
                Battleship.errorInputText(cellsShip);
                continue;
            }
            else if (sub != count - 1 && count == 3 && sub1 != count - 1){
                Battleship.errorInputText(cellsShip);
                continue;
            }
            else if (sub != count  && count == 2 && sub1 != count){
                Battleship.errorInputText(cellsShip);
                continue;
            }
            else if (count == 1 && sub != count && sub1 != count){
                Battleship.errorInputText(cellsShip);
                continue;
            }
            AddShips.addShipsOnField(firstStart, intStart , endStart, intEnd, arrayPlayer1);

            if(count == 5){
                Battleship.inputText(++cellsShip);
            }
            else if (count == 4){
                Battleship.inputText(++cellsShip);
            }
            else if (count == 3){
                Battleship.inputText(++cellsShip);
            }
            else if (count == 2){
                Battleship.inputText(++cellsShip);
            }
            count --;
            if(count < 1){
                System.out.print("Press Enter and pass the move to another player");
                scanner.nextLine();
                if(scanner.nextLine().equals("")){
                    new Player2().inputCoordinates();
                }
            }
            Battleship.checkArray(firstStart, intStart, endStart, intEnd, arrayPlayer1Boolean);
        }
    }

    @Override
    public String scannerInput() {
        return null;
    }
}
