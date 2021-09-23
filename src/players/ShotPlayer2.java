package players;

import com.company.AddShips;
import com.company.Battleship;
import com.company.Main;
import players.abstrclass.Shot;

import java.util.Arrays;

import static com.company.Shot.checkShipSunk;

public class ShotPlayer2 extends Shot {
static String[][] copyArrayPlayer1;
static int countPlayer2 = 0;
    @Override
    public void getShot(String[][] arrayPlayer1, String[][] arrayWithoutShipsPlayer1) {
        char[] al = Battleship.verticalMarkup();
        boolean b = false;
        while (countPlayer2 < 17) {
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

            if (arrayPlayer1[firstCoordinates][twoCoordinates].equals("O")) {
                arrayWithoutShipsPlayer1[firstCoordinates][twoCoordinates] = "X";
                arrayPlayer1[firstCoordinates][twoCoordinates] = "X";
                countPlayer2++;
                b = true;
            } else if (arrayPlayer1[firstCoordinates][twoCoordinates].equals("~")) {
                arrayWithoutShipsPlayer1[firstCoordinates][twoCoordinates] = "M";
                arrayPlayer1[firstCoordinates][twoCoordinates] = "M";
                copyArrayPlayer1[firstCoordinates][twoCoordinates] = "M";
            }
            if (b && Arrays.deepEquals(checkShipSunk(copyArrayPlayer1, line), arrayPlayer1)) {
                System.out.print("You sank a ship\n");
                System.out.print("Press Enter and pass the move to another player");
                if (new Main().scannerInput().equals("")) {
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player2.getArrayWithoutShipsPlayer2(), al);
                    System.out.print("---------------------\n");
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player1.getArrayPlayer1(), al);
                    System.out.print("Player 1, it's your turn:\n");
                    new ShotPlayer1().getShot(Player2.getArrayPlayer2(), Player2.getArrayWithoutShipsPlayer2());
                    break;
                }
            } else if (b) {
                System.out.print("You hit a ship!\n");
                System.out.print("Press Enter and pass the move to another player");
                if (new Main().scannerInput().equals("")) {
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player2.getArrayWithoutShipsPlayer2(), al);
                    System.out.print("---------------------\n");
                    Battleship.HorizontalMarkup();
                    AddShips.showArray(Player1.getArrayPlayer1(), al);
                    System.out.print("Player 1, it's your turn:\n");
                    new ShotPlayer1().getShot(Player2.getArrayPlayer2(), Player2.getArrayWithoutShipsPlayer2());
                    break;
                }
            } else System.out.print("You missed!\n");
            System.out.print("Press Enter and pass the move to another player");
            if (new Main().scannerInput().equals("")) {
                Battleship.HorizontalMarkup();
                AddShips.showArray(Player2.getArrayWithoutShipsPlayer2(), al);
                System.out.print("---------------------\n");
                Battleship.HorizontalMarkup();
                AddShips.showArray(Player1.getArrayPlayer1(), al);
                System.out.print("Player 1, it's your turn:\n");
                new ShotPlayer1().getShot(Player2.getArrayPlayer2(), Player2.getArrayWithoutShipsPlayer2());
                break;
            }

            if (countPlayer2 == 17 && Arrays.deepEquals(checkShipSunk(copyArrayPlayer1, line), arrayWithoutShipsPlayer1)) {
                System.out.print("You sank the last ship. You won. Congratulations!");
                countPlayer2++;
            }
        }
    }
}

