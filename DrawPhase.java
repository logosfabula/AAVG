
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public class DrawPhase extends Phase{
    Hand currentHand;
    Deck currentDeck;
    
    public DrawPhase() {
        currentHand = currentPlayer.hand;
        currentDeck = currentPlayer.deck;
    }
    
    @Override
    void play() {
        try {
            currentDeck.draw(currentHand);
        } catch (EmptyDeckException ex) {
            Game.game.gameOver();
        }
        
        finish();
    }
    
}
