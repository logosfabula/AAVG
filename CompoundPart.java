/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */

import java.util.List;
import java.util.ArrayList;

public abstract class CompoundPart extends Component {
    private List<Component> children = new ArrayList<>();

    public CompoundPart(String string) {
        super(string);
    }
    
    @Override
    void operation(){
        int childrensNo = children.size();
        for (int i = 0; i < childrensNo; i++){
            children.get(i).operation();
        }
    }
    
    @Override
    void add(Component c){
        children.add(c);
    }
    
    @Override
    void remove(Component c){
        children.remove(c);
    }
    
}
