package battleship;

import java.util.Arrays;

public class NewPlayer {
   public  String[][] newPlayer = new String[10][10];

    public NewPlayer() {
        for (String[] s : newPlayer) {
            Arrays.fill(s, "~");
        }
    }

    public void printFieldTwo(String[][]newPlayer) {
        char[] chars = HelperMethods.verticalMarkup();
        new Player().print(chars, newPlayer);
    }
    public void getCheckShotTwo(Search search, Coordinate coordinate, String[][]arr){
        if(new Player().checkHit(coordinate,arr)) {
            arr[coordinate.getX()][coordinate.getY()] = "X";
            boolean b = search.isSearchHorizontal(search,arr);
            boolean b1 = search.isSearchVertical(search,arr);
            if(!b && !b1 && (Player.countHitPlayer == 17 || Player.countHitNewPlayer == 17)){
                System.out.print("You sank the last ship. You won. Congratulations!");
            }
            else if (!b && !b1) {
                System.out.print("You sank a ship!\n");
            } else {
                System.out.print("You hit a ship!\n");
            }
        } else {
            arr[coordinate.getX()][coordinate.getY()] = "M";
            System.out.print("You missed!\n");
        }
    }
}
