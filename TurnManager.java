import java.util.EmptyStackException;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public class TurnManager {
    Stack<TurnStrategy> strategies = new Stack<>();
    Player currentPlayer;
    
    void addTurnStrategy(TurnStrategy newTurnStrategy){
        strategies.push(newTurnStrategy);
    }
    
    TurnStrategy getNextStrategy(){
        TurnStrategy nextTurnStrategy;
        try {
            nextTurnStrategy = strategies.pop();
        }
        catch (EmptyStackException ese){
            nextTurnStrategy = new DefaultTurnStrategy();
        }
        
        return nextTurnStrategy;
    }
}
