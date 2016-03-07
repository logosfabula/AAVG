/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
class Card {
    String name;
    Castable spell;
    
    Card(Castable spell){
        this.spell = spell;
    }
    
    Castable getSpell(){
        return spell;
    }
    
    void play(){
        Game.game.gameStack.addSpell(spell);
    }
    
    void describe(){
        System.out.println("Card name: " + name);
        System.out.println("Type: " + spell.getType());
        System.out.println("'" + spell.getDescription() + "'");
    }
}
