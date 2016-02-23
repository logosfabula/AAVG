/**
 *
 * @author AAVG
 */
public class Player {
    int lifePoints = 20;
    Board field = new Board();
    Deck deck = new Deck();
    Hand hand = new Hand();
    
    Player() {
        for (int i = 0; i < 5; i++){
            deck.draw(hand);
        }
    }
    
    int getLifePoints(){
        return lifePoints;
    }
    
    void setLifePoints(int lp){
        lifePoints = lp;
    }
}
