
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class DrawPhase extends Phase{
    Hand currentHand = currentPlayer.hand;
    Deck currentDeck = currentPlayer.deck;
    
    @Override
    void play() throws EmptyDeckException {
        currentDeck.draw(currentHand);
    
        finish();
    }
    
}
