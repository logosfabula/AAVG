/**
 *
 * @author AAVG
 */
public class Game {
    static final Game game = new Game();
    Player player1;
    Player player2;
    private Game(){
        player1 = new Player();
        player2 = new Player();
    }
    
    void start (){
        System.out.println("Game started!");
    }
}
