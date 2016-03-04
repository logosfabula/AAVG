import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class GameStack {
    Stack<Castable> cards = new Stack<>();
    
    void addSpell(Castable spell){
        cards.add(spell);
    }
}
