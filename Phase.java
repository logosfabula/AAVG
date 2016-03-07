
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public abstract class Phase {
    Phase nextPhase;
    PhaseStrategy currentStrategy;
    Player currentPlayer;
    
    Phase(){
        currentStrategy = Game.game.phaseManager.getNextStrategy();
        nextPhase = currentStrategy.selectNextPhase(this.getClass());
        currentPlayer = Game.game.turnManager.currentPlayer;
    }
    
    void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }
    
    abstract void play();
    
    void finish(){
        // plays next phase
        Game.game.phaseManager.getNextStrategy().selectNextPhase(null).play();
    }
}
