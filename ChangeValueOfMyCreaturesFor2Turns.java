
import java.util.Iterator;
import java.util.List;

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
public class ChangeValueOfMyCreaturesFor2Turns extends SorcerySpell{
    
    //this.globalObserver.register(new EventAction());  
    
    List<Creature> targetedCreatures;

    @Override
    public void cast() {
        Iterator<Creature> iterator = targetedCreatures.iterator();
        while (iterator.hasNext()){
            Creature target = iterator.next();
            target.setPower(target.getPower() + 1);
        }
        Game.game.globalObserver.register(new EventAction("End Phase"){
            int additionalTurns = 1;
            List<Creature> targets = targetedCreatures;
            @Override
            void run() {
                if (additionalTurns > 0){
                    additionalTurns--;
                }
                else {
                    for (Creature creature : targets){
                        creature.setPower(creature.getPower() - 1);
                    }
                }
            }
        });  
    }

    @Override
    public void prepare() {
        targetedCreatures = caster.board.getCreatures();
    }
}
