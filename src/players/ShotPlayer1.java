package players;

import com.company.AddShips;
import com.company.Battleship;
import com.company.Main;
import players.abstrclass.Shot;

import java.util.Arrays;

import static com.company.Shot.checkShipSunk;

public class ShotPlayer1 extends Shot {
    static String[][] copyArrayPlayer2;
    static int countPlayer1 = 0;
    @Override
    public void getShot(String[][] arrayPlayer2, String[][] arrayWithoutShipsPlayer2) {
        char[] al = Battleship.verticalMarkup();
        boolean b = false;
        while (countPlayer1 < 17) {
            String line = new Main().scannerInput();
            String firstCoordinatesShot = line.substring(0, 1);
            char symbol = firstCoordinatesShot.charAt(0);
            String twoCoordinatesShot = line.substring(1);
            int firstCoordinates = Battleship.transformationCoordinates(firstCoordinatesShot);
            int twoCoordinates = Integer.parseInt(twoCoordinatesShot) - 1;
            if (symbol > 75 || symbol < 65 || twoCoordinates < 0 || twoCoordinates > 9) {
                System.out.printf("%s", "Error! You entered the wrong coordinates! Try again:\n");
                continue;
            }
            if (arrayPlayer2[firstCoordinates][twoCoordinates].equals("O")) {
                arrayWithoutShipsPlayer2[firstCoordinates][twoCoordinates] = "X";
                arrayPlayer2[firstCoordinates][twoCoordinates] = "X";
                countPlayer1++;
                b = true;
            } else if (arrayPlayer2[firstCoordinates][twoCoordinates].equals("~")) {
                arrayWithoutShipsPlayer2[firstCoordinates][twoCoordinates] = "M";
                arrayPlayer2[firstCoordinates][twoCoordinates] = "M";
                copyArrayPlayer2[firstCoordinates][twoCoordinates] = "M";
            }


            if (b && Arrays.deepEquals(checkShipSunk(copyArrayPlayer2, line), arrayPlayer2)) {
                System.out.print("You sank a ship!\n");
                System.out.print("Press Enter and pass the move to another player");
                if (new Main().scannerInput().equals("")) {
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player1.getArrayWithoutShipsPlayer1(), al);
                    System.out.print("---------------------\n");
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player2.getArrayPlayer2(), al);
                    System.out.print("Player 2, it's your turn:\n");
                    new ShotPlayer2().getShot(Player1.getArrayPlayer1(), Player1.getArrayWithoutShipsPlayer1());
                    break;
                }
            } else if (b) {
                System.out.print("You hit a ship!\n");
                System.out.print("Press Enter and pass the move to another player");
                if (new Main().scannerInput().equals("")) {
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player1.getArrayWithoutShipsPlayer1(), al);
                    System.out.print("---------------------\n");
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player2.getArrayPlayer2(), al);
                    System.out.print("Player 2, it's your turn:\n");
                    new ShotPlayer2().getShot(Player1.getArrayPlayer1(), Player1.getArrayWithoutShipsPlayer1());
                    break;
                }
            } else
                System.out.print("You missed!\n");
            System.out.print("Press Enter and pass the move to another player");
            if (new Main().scannerInput().equals("")) {
                Battleship.HorizontalMarkup();
                AddShips.showArray(Player1.getArrayWithoutShipsPlayer1(), al);
                System.out.print("---------------------\n");
                Battleship.HorizontalMarkup();
                AddShips.showArray(Player2.getArrayPlayer2(), al);
                System.out.print("Player 2, it's your turn:\n");
                new ShotPlayer2().getShot(Player1.getArrayPlayer1(), Player1.getArrayWithoutShipsPlayer1());
                break;
            }

            if (countPlayer1 == 17 && Arrays.deepEquals(checkShipSunk(copyArrayPlayer2, line), arrayPlayer2)) {
                System.out.print("You sank the last ship. You won. Congratulations!");
                countPlayer1++;

            }
        }
    }
}

