
import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
class Game {
    public static final Game game = new Game();
    Player player1;
    Player player2;
    
    GameStack gameStack;
    
    TurnManager turnManager;
    PhaseManager phaseManager;
    
    private Game(){
        player1 = new Player("Player 1", 1);
        player2 = new Player("Player 2", 2);
    }
    
    void setup() throws EmptyDeckException{
        InstantSpell omeopathy = new HomeopathySpell();
        Card omeopathyCard = new Card(omeopathy);
        
        /* builds player 1's deck */
        for (int i = 0; i < 50; i++){
            player1.deck.cards.push(omeopathyCard);
        }
        
        /* builds player 2's deck */
        for (int i = 0; i < 50; i++){
            player2.deck.cards.push(omeopathyCard);
        }
        
        /* creates player 1's hand */
        for (int i = 0; i < 5; i++){
            player1.deck.draw(player1.hand);
        }
        
        player1.hand.discard(omeopathyCard);
        
        /* creates player 2's hand */
        for (int i = 0; i < 5; i++){
            player2.deck.draw(player2.hand);
        }
    }
    
    void start(){
        System.out.println("Game started!");
        
        System.out.println("Player 1's cards");
        player1.hand.describe();
        System.out.println(player1.hand.cards.size());
        
        System.out.println("Player 2's cards");
        player2.hand.describe();
        System.out.println(player2.hand.cards.size());     

        try {
            // start game
            new Turn(player1).play();
        } catch (EmptyDeckException ex) {
            gameOver("empty deck");
        }
    }
    
    void gameOver(String cause){
        if ("empty deck".equals(cause)){
            if (player1.deck.isEmpty()){
                System.out.println("Player 2 wins");
            } 
            else {
                System.out.println("Player 1 wins");
            }
        }
        
        System.exit(0);
    }
}