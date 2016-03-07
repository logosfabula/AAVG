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
    int id;
    String name;
    int lifePoints = 20;
    Board board = new Board();
    Deck deck = new Deck();
    Hand hand = new Hand(7);
    
    Player(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    int getId(){
        return id;
    }
    
    int getLifePoints(){
        return lifePoints;
    }
    
    void setLifePoints(int lp) throws DeadPlayerException{
        lifePoints = lp;
        
        if (lifePoints <= 0){
            throw new DeadPlayerException(this);
        }
    }
}
