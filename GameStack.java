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
    Stack<Castable> castables = new Stack<>();
    
    void addSpell(Castable spell){
        castables.add(spell);
    }
    
    boolean isEmpty(){
        return castables.isEmpty();
    }
    
    void describe(){
        if (!castables.isEmpty()){
            for (Castable castable : castables){
                System.out.println(castable.getName());
                System.out.println(castable.getType());
                System.out.println(castable.getDescription());
            }
        } else {
            System.out.println("Empty.");
        }
    }
    
    void execute(){
        for (Castable castable : castables){
            castable.cast();
        }
    }
}
