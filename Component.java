/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
abstract class Component {
    
    String name;
    
    Component(String string){
        this.name = string;
    }
    
    abstract void operation();
    
    void add(Component component) throws SinglePartException {
        if (this instanceof SinglePart)
            throw new SinglePartException();
    }
    
    void remove(Component component) throws SinglePartException {
        if (this instanceof SinglePart)
            throw new SinglePartException();
    }
    
    Component getChild(int index){
        return null;
    }
    
}
