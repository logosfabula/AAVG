
import java.util.Collections;
import java.util.Stack;
import java.util.*;

/**
 *
 * @author AAVG
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
