/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class Player {
    String name;
    int lifePoints = 20;
    Board field = new Board();
    Deck deck = new Deck();
    Hand hand = new Hand();
    
    Player(String name) {
        this.name = name;
    }
    
    int getLifePoints(){
        return lifePoints;
    }
    
    void setLifePoints(int lp){
        lifePoints = lp;
    }
}
