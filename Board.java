
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
class Board {
    List<Creature> creatures = new LinkedList<>();
    
    public List getCreatures(){
        return creatures;
    }
    
    Creature getCreature(int position){
        return creatures.get(position - 1);
    }
    
    void describe(){
        System.out.println("Creatures on the board:");
        int i = 0;
        if (!creatures.isEmpty()){
            for (Creature creature : creatures){
                System.out.println(++i + ")");
                creature.describe();
            }
        } else {
            System.out.println("None.");
        }
    }
    
    void describeAbilities(){
        System.out.println("Available creatures with abilities:");
        int i = 1;
        Iterator<Creature> iterator = creatures.iterator();
        
        while (iterator.hasNext()){
            Creature creature = iterator.next();
            if (creature.getEffect() != null){
                System.out.println(i + ")");
                creature.getName();
                creature.getEffect().getDescription();
            }
            i++;
        }
    }
}