/*
 * The MIT License
 *
 * Copyright 2016 Antonio Panfili, Francesco Gemin, Vladimyr Tarquini e Anton Maria Prati.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Antonio Panfili, Francesco Gemin, Vladimyr Tarquini e Anton Maria Prati
 */
public class DefaultPhaseStrategy implements PhaseStrategy {
    Phase nextPhase;
    @Override
    public Phase selectNextPhase(Class currentPhaseClass) {
        Class npc = NullPhase.class;
        
        if (currentPhaseClass.equals(NullPhase.class)) {
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
        else { //includes NextPhase
            nextPhase = new NullPhase();
        }

        return nextPhase;
    }
}
