import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Antonio Panfili, Francesco Gemin, Vladimyr Tarquini e Anton Maria Prati
 */
class Hand {
    List<Card> cards = new ArrayList<>();
    int cardLimit;
    
    Hand(int maxSize){
        this.cardLimit = maxSize;
    }
    
    void setCardLimit(int newLimit){
        cardLimit = newLimit;
    }
    
    int getCardLimit(){
        return cardLimit;
    }
    
    int getSize(){
        return cards.size();
    }
    
    void add(Card card){
        cards.add(card);
        checkHandSize(cardLimit);
    }
    
    Card pick(int position){
        return cards.remove(position);
    }
    
    void promptDiscard(){
        describe();
        System.out.println("Discard one card, please.");
        Scanner scan = new Scanner(System.in);
        int cardNumber = scan.nextInt();
        pick(cardNumber - 1);
    }
    
    void checkHandSize(int size) {
        int s = cards.size();
        if (cards.size() > size)
            promptDiscard();
    }
    
    void describe(){
        System.out.println("Cards in hand:");
        int i = 0;
        for (Card card : cards){
            System.out.println(++i + ")");
            card.describe();
        }
    }
    
    void describeInstants(){
        System.out.println("Instant spell cards in hand:");
        int i = 1;
        for (Card card : cards){
            if ("Instant".equals(card.getSpell().getType())){
                System.out.println(i++ + ")");
                card.describe();
            }
        }
    }
}