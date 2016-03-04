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
    
    private Game(){
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }
    
    void setup(){
        InstantSpell omeopathy = new OmeopathySpell();
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
    
    void start (){
        System.out.println("Game started!");
        
        System.out.println("Player 1's cards");
        player1.hand.showCards();
        System.out.println(player1.hand.cards.size());
        
        
        System.out.println("Player 2's cards");
        player2.hand.showCards();
        System.out.println(player2.hand.cards.size());
        
        
        
    }
}
