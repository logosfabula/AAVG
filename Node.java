/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AAVG
 */
interface Node {
    abstract void operation();
    void add(Node node) throws SinglePartException, UnsupportedPartException;
    void remove(Node node) throws SinglePartException, UnsupportedPartException;
    Node getChild(int index);
}
