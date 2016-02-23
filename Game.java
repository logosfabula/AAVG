/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
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
