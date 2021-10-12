package battleship;
public class Game {
    public Player player;

    public Game() {
        player = new Player();


    }

    public void getStart()  {
        int COUNT_SHIPS = 17;
            System.out.print("Player 1, place your ships on the game field\n");
            player.startTheGame(true);
            HelperMethods.scanner();
        System.out.print("Player 2, place your ships on the game field\n");
        player.startTheGame(false);
        while (Player.countHitPlayer < COUNT_SHIPS || Player.countHitNewPlayer < COUNT_SHIPS) {
            player.getShot();
        }
    }
}


