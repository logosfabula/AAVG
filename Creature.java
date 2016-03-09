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
class Creature {
    private final String name;
    private int power;
    private int toughness;
    private CreatureAbility effect = null;
    private boolean tapped;

    
    Creature(String name, CreatureAbility effect){
        this.name = name;
        this.effect = effect;
    }
    
    String getName(){
        return name;
    }
    
    void tap(){
        tapped = true;
    }
    
    void untap(){
        tapped = false;
    }
    
    boolean getTapped(){
        return tapped;
    }
    
    void setTapped(boolean tapped){
        this.tapped = tapped;
    }
    
    int getPower(){
        return power;
    } 
    
    int getToughness(){
        return toughness;
    }
    
    void setPower(int newPower){
        power = newPower;
    }

    void setToughness(int newToughness){
        toughness = newToughness;
    }
    
    Castable getEffect(){
        return effect;
    }
    
    void setEffect(CreatureAbility newEffect){
        effect = newEffect;
    }
    
    void describe(){
        System.out.println("Creature name: " + name);
        System.out.println("Power: " + power);
        System.out.println("Toughess: " + toughness);
        System.out.println("Is tapped? " + (tapped ? "Yes." : "No.") );
        System.out.println("Effect: " + (effect != null ? effect.getType() + effect.getDescription() : "None."));
    }
    
    CreatureAbility getCreatureAbility(){
        return effect;
    }
    
    void setCreatureAbility(CreatureAbility newEffect){
        effect = newEffect;
    }
}