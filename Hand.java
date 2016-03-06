import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AAVG
 */
class Hand {
    List<Card> cards = new ArrayList<>();
    
    void add(Card card) {
        cards.add(card);
        checkHandSize(7);
    }
    
    void discard(Card card) {
        cards.remove(cards.indexOf(card));
    }
    
    void showCards() {
        Iterator iterator = cards.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    void promptDiscard(){
        System.out.println("discard one card, please.");
    }
    
    void checkHandSize(int size) {
        if (cards.size() > size)
            promptDiscard();
    }
}