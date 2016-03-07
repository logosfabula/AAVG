/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
public class DefaultPhaseStrategy implements PhaseStrategy {
    
    @Override
    public Phase selectNextPhase(Class currentPhaseClass) {
        Phase nextPhase = null;
        if (currentPhaseClass == null) {
            nextPhase = new DrawPhase();
        }
        else if (currentPhaseClass.equals(DrawPhase.class)) {
            nextPhase = new UntapPhase();
        } 
        else if (currentPhaseClass.equals(UntapPhase.class)) {
            nextPhase = new CombatPhase();
        } 
        else if (currentPhaseClass.equals(CombatPhase.class)) {
            nextPhase = new MainPhase();
        } 
        else if (currentPhaseClass.equals(MainPhase.class)) {
            nextPhase = new EndPhase();
        } 

        return nextPhase;
    }
}
