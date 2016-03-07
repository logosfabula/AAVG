/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
class Creature {
    private int power;
    private int toughness;
    private Castable effect;
    private boolean tapped;
    
    
    void tap(){
        tapped = true;
    }
    
    void untap(){
        tapped = false;
    }
    
    boolean getTapped(){
        return tapped;
    }
    
    void setTapped(boolean tapped){
        this.tapped = tapped;
    }
    
    int getPower(){
        return power;
    } 
    
    int getToughness(){
        return toughness;
    }
    
    void setPower(int newPower){
        power = newPower;
    }

    void setToughness(int newToughness){
        toughness = newToughness;
    }
}