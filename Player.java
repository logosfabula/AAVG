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
public class Player {

    String name;
    /* initial stats */
    int lifePoints = 20;
    int handLimit = 7;
    
    Board board = new Board();
    Deck deck = new Deck();
    Hand hand = new Hand(handLimit);
    
    Player(String name) {
        this.name = name;
    }
    
    String getName(){
        return this.name;
    }
    
    int getLifePoints(){
        return lifePoints;
    }
    
    void setLifePoints(int lp) throws DeadPlayerException{
        lifePoints = lp;
        
        if (lifePoints <= 0){
            throw new DeadPlayerException(this);
        }
    }
}
