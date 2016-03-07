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
public class TurnManager {
    Stack<TurnStrategy> strategies = new Stack<>();
    Player currentPlayer;
    Player rivalPlayer;
    
    void addTurnStrategy(TurnStrategy newTurnStrategy){
        strategies.push(newTurnStrategy);
    }
    
    void setCurrentPlayer(Player newCurrentPlayer){
        this.currentPlayer = newCurrentPlayer;
        rivalPlayer = ((currentPlayer == Game.game.player1) ? Game.game.player2 : Game.game.player1);
    }
    
    Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    Player getRivalPlayer(){
        return rivalPlayer;
    }
    
    int getCurrentPlayerID(){
        return currentPlayer.getId();
    }
    
    int getRivalPlayerID(){
        return rivalPlayer.getId();
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
