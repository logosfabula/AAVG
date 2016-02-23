
import java.util.Collections;
import java.util.Stack;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
class Deck {
    Stack<Card> cards = new Stack<>();

    void draw(Hand hand) throws EmptyStackException {
        if(!cards.empty()) {
            hand.add(cards.pop());
        } else {
            throw new EmptyStackException();
        }
        
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void shuffle() {
        Collections.shuffle(cards);
    }
}
