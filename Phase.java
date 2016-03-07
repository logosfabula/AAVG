
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public abstract class Phase {
    Phase nextPhase;
    PhaseStrategy currentStrategy;
    Player currentPlayer;
    Player rivalPlayer;
    
    Phase(){
        currentStrategy = Game.game.phaseManager.getCurrentStrategy();
        nextPhase = currentStrategy.selectNextPhase(this.getClass());
        currentPlayer = Game.game.turnManager.getCurrentPlayer();
        rivalPlayer = Game.game.turnManager.getRivalPlayer();
    }
    
//    void setCurrentPlayer(Player currentPlayer){
//        this.currentPlayer = currentPlayer;
//        this.rivalPlayer = (currentPlayer == Game.game.player1) ? Game.game.player2 : Game.game.player1;
//    }
    
    abstract void play();
    
    void finish(){
        nextPhase.play();
    }
}
