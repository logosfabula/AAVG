/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public abstract class CreatureSpell extends Spell {

    String creatureName;
    int creaturePower;
    int creatureToughness;
    Castable creatureAbility;

    public CreatureSpell() {
        this.type = "Creature";
    }
    
    String getCreatureName(){
        return creatureName;
    }
    
    int getCreaturePower(){
        return creaturePower;
    }
    
    int getCreatureToughness(){
        return creatureToughness;
    }
    
    Castable getCreatureAbility(){
        return creatureAbility;
    }
}
