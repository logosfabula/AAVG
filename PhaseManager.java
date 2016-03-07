
import java.util.EmptyStackException;
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
public class PhaseManager {
    Stack<PhaseStrategy> strategies = new Stack<>();
    PhaseStrategy currentStrategy = null;
    
    void addPhaseStrategy(PhaseStrategy newPhaseStrategy){
        strategies.push(newPhaseStrategy);
    }
    
    PhaseStrategy getNextStrategy(){
        PhaseStrategy nextPhaseStrategy;
        try {
            nextPhaseStrategy = strategies.pop();
        }
        catch (EmptyStackException ese){
            nextPhaseStrategy = new DefaultPhaseStrategy();
        }
        
        currentStrategy = nextPhaseStrategy;
        return nextPhaseStrategy;
    }
    
    PhaseStrategy getCurrentStrategy(){
        return currentStrategy;
    }
}
