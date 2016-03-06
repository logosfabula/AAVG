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
    Castable spell;
    
    Card(Castable spell){
        this.spell = spell;
    }
    
    void play(){
        Game.game.gameStack.addSpell(spell);
    }
}
