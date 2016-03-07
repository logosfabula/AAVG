
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public class Turn {
    Player nextPlayer;
    TurnStrategy currentStrategy;
    
    Turn(Player currentPlayer){
        Game.game.turnManager.currentPlayer = currentPlayer;
        currentStrategy = Game.game.turnManager.getNextStrategy();
        nextPlayer = currentStrategy.selectNextPlayer(currentPlayer);
    }
    
    void play(){
        // plays first phase
        Game.game.phaseManager.getNextStrategy().selectNextPhase(null).play();
        
        // plays next turn
        new Turn(nextPlayer).play();
    }
}
