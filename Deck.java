
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
    }
    
    void shuffle() {
        Collections.shuffle(cards);
    }
}
