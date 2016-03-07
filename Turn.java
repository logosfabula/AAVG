
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class Turn {
    Player nextPlayer;
    Player currentPlayer;
    TurnStrategy currentStrategy;
    
    Turn(Player currentPlayer){
        Game.game.turnManager.setCurrentPlayer(currentPlayer);
        currentStrategy = Game.game.turnManager.getNextStrategy();
        nextPlayer = currentStrategy.selectNextPlayer(currentPlayer);
    }
    
    void play() throws EmptyDeckException{
        System.out.println("Player " + currentPlayer.getId() + "'s turn.");
        
        // plays first phase
        Game.game.phaseManager.getNextStrategy().selectNextPhase(new NullPhase().getClass()).play();
        
        // plays next turn
        new Turn(nextPlayer).play();
    }
}
