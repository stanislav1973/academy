package battleship;

import com.company.list.Move;

import java.util.Scanner;

public class Coordinate {
    Search search;
     private int x;
     private int y;

    public Coordinate(String s) {
        x = s.charAt(0) - 65;
        y = Integer.parseInt(s.substring(1)) - 1;
        search = new Search(x,y);
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public static Coordinate inputOneCoordinate()throws WrongLengthShipException{
        Scanner scanner = new Scanner(System.in);
         String one = scanner.next();
         String d = one.substring(1);
        int integer = Integer.parseInt(d) - 1;
        if(integer > 9 || integer < 0){
            throw new WrongLengthShipException();
        }
       return new Coordinate(one);
    }
}
