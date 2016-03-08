
/*
 * The MIT License
 *
 * Copyright 2016 logosfabula.
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
 * @author logosfabula
 */
public abstract class Phase {
    Phase nextPhase;
    PhaseStrategy currentStrategy;
    Player currentPlayer;
    Player rivalPlayer;
    
    Phase() {
        currentStrategy = Game.game.phaseManager.getCurrentStrategy();
        currentPlayer = Game.game.turnManager.getCurrentPlayer();
        rivalPlayer = Game.game.turnManager.getRivalPlayer();
    }
    
    
// MIGHT OCCUR WITH A CARD: TO BE IMPLEMENTED...
//    void setCurrentPlayer(Player currentPlayer){
//        this.currentPlayer = currentPlayer;
//        this.rivalPlayer = (currentPlayer == Game.game.player1) ? Game.game.player2 : Game.game.player1;
//    }
    
    void play() throws EmptyDeckException {
        System.out.println(currentPlayer.getName() + "'s " + this.getClass().getName());
    }
    
    void finish() throws EmptyDeckException{
        nextPhase = currentStrategy.selectNextPhase(this.getClass());
        nextPhase.play();
    }
}
