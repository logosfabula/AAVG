/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class DefaultTurnStrategy implements TurnStrategy {

    @Override
    public Player selectNextPlayer(Player currentPlayer){
        Player nextPlayer;
        if (currentPlayer == Game.game.player1) {
            nextPlayer = Game.game.player2;
        } else {
            nextPlayer = Game.game.player1;
        }
        return nextPlayer;
    }
}
