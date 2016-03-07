import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author logosfabula
 */
class Hand {
    List<Card> cards = new ArrayList<>();
    int maxSize;
    
    Hand(int maxSize){
        this.maxSize = maxSize;
    }
    
    void add(Card card){
        cards.add(card);
        checkHandSize(maxSize);
    }
    
    void discard(Card card){
        cards.remove(cards.indexOf(card));
    }
    
    Card pick(int position){
        return cards.remove(position);
    }
    
    void promptDiscard(){
        System.out.println("discard one card, please.");
    }
    
    void checkHandSize(int size) {
        if (cards.size() > size)
            promptDiscard();
    }
    
    void describe(){
        System.out.println("Creatures on the board:");
        int i = 1;
        for (Card card : cards){
            System.out.println(i++ + ")");
            card.describe();
        }
    }
    
    void describeInstants(){
        System.out.println("Creatures on the board:");
        int i = 1;
        for (Card card : cards){
            if ("Instant".equals(card.getSpell().getType())){
                System.out.println(i++ + ")");
                card.describe();
            }
        }
    }
}