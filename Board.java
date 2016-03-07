
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
class Board {
    List<Creature> creatures = new ArrayList<>();
    
    public List getCreatures(){
        return creatures;
    }
    
    Creature getCreature(int position){
        return creatures.get(position - 1);
    }
    
    void describe(){
        System.out.println("Creatures on the board:");
        int i = 1;
        for (Creature creature : creatures){
            System.out.println(i++ + ")");
            creature.describe();
        }
    }
    
    void describeAbilities(){
        System.out.println("Creatures with abilities:");
        int i = 1;
        for (Creature creature : creatures){
            if (creature.getEffect() != null){
                System.out.println(i + ")");
                creature.getName();
                creature.getEffect().getDescription();
            }
            i++;
        }
    }
}