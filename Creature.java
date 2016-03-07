/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
class Creature {
    private final String name;
    private int power;
    private int toughness;
    private CreatureAbility effect = null;
    private boolean tapped;

    
    Creature(String name, CreatureAbility effect){
        this.name = name;
        this.effect = effect;
    }
    
    String getName(){
        return name;
    }
    
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
    
    Castable getEffect(){
        return effect;
    }
    
    void setEffect(CreatureAbility newEffect){
        effect = newEffect;
    }
    
    void describe(){
        System.out.println("Creature name: " + name);
        System.out.println("Power: " + power);
        System.out.println("Toughess: " + toughness);
        System.out.println("Is tapped? " + (tapped ? "Yes." : "No.") );
        System.out.println("Effect: " + (effect != null ? effect.getType() + effect.getDescription() : "None."));
    }
}