package players;

import com.company.AddShips;
import com.company.Battleship;
import com.company.Shot;

import java.util.Scanner;

public class Player2 extends InputCoordinatesShip{
    private static String[][] arrayPlayer2;

    public static String[][] getArrayPlayer2() {
        return arrayPlayer2;
    }

    @Override
    public void inputCoordinates() {
        int count = 5; // ship input counter
        arrayPlayer2 = Battleship.getArray();
        boolean[][] arrayPlayer2Boolean = Battleship.addArrayBoolean();
        String[][]arrayWithoutShipsPlayer2 = Battleship.getArray();
        System.out.print("Player 2, place your ships to the game field\n");
        char[] al = Battleship.verticalMarkup();
        Battleship.HorizontalMarkup();
        AddShips.showArray(arrayPlayer2,al);
        int cellsShip = 0;
        Battleship.inputText(cellsShip);
        String[][]s = new Player1().getArrayPlayer1();
        Scanner scanner = new Scanner(System.in);
        while (count > 0) {
        String startCoordinates = scanner.next();
        // entering the two coordinate
        String endCoordinates1 = scanner.next();
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

        if(!arrayPlayer2Boolean[firstStart][intStart]){
            System.out.print("Error! You placed it too close to another one. Try again:\n");
            continue;
        }
        if(!arrayPlayer2Boolean[endStart][intEnd]){
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
        AddShips.addShipsOnField(firstStart, intStart , endStart, intEnd,arrayPlayer2);

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
        count--;
        if(count < 1){
            System.out.printf("%s","Press Enter and pass the move to another player");
            scanner.nextLine();
            if(scanner.nextLine().equals("")){
                Battleship.getEmptyArray();
                System.out.print("---------------------\n");
                Battleship.HorizontalMarkup();
               // AddShips.showArray(Player1.getArrayPlayer1(),al);
            }
            System.out.printf("%s\n", "Take a shot!");
            new Shot().getShot(arrayPlayer2,arrayWithoutShipsPlayer2);
            //count--;
        }
        Battleship.checkArray(firstStart, intStart, endStart, intEnd, arrayPlayer2Boolean);
    }
    }

    @Override
    public String scannerInput() {
        return null;
    }
}
