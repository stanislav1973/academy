package battleship;

public class Game {
   public Player player;
    public Game() {
        player = new Player();


    }
    public void getStart() {
        player.startTheGame();
        System.out.print("The game starts!\n");
        player.printField();
        System.out.print("Take a shot!\n");
        player.getShot();
    }
}

