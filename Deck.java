import java.util.Collections;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
class Deck {
    Stack<Card> cards = new Stack<>();

    void draw(Hand hand) throws EmptyDeckException {
        if(!cards.empty()) {
            hand.add(cards.pop());
        } else {
            throw new EmptyDeckException();
        }
    }
    
    void shuffle() {
        Collections.shuffle(cards);
    }
}
