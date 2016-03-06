
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public class UntapPhase extends Phase{

    Board currentBoard;

    public UntapPhase() {
        currentBoard = currentPlayer.board;
    }
            
    @Override
    void play() {
        for (Creature creature : currentBoard.creatures) {
            creature.untap();
        }
        
        finish();
    }
    
}
