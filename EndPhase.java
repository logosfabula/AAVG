/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class EndPhase extends Phase{

    @Override
    void play() throws EmptyDeckException {
        // Triggers end-turn effects
        
        finish();
    }
    
}
