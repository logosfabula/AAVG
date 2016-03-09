
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



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
class Game {
    public static final Game game = new Game();
    final Player player1;
    final Player player2;
    
    final GameStack gameStack;
    
    final TurnManager turnManager;
    final PhaseManager phaseManager;
    
    final Observer globalObserver;
    
    
    
    private Game(){
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        turnManager = new TurnManager();
        phaseManager = new PhaseManager();
        gameStack = new GameStack();
        globalObserver = new Observer();
    }
    
    void setup() throws EmptyDeckException{
        InstantSpell homeopathy = new HomeopathySpell();
        Card omeopathyCard = new Card(homeopathy);
        
        /* builds player 1's deck */
        for (int i = 0; i < 50; i++){
            player1.deck.cards.push(omeopathyCard);
        }
        
        /* builds player 2's deck */
        for (int i = 0; i < 50; i++){
            player2.deck.cards.push(omeopathyCard);
        }
        
        /* creates player 1's hand */
        for (int i = 0; i < player1.handLimit; i++){
            player1.deck.draw(player1);
        }
        
        /* creates player 2's hand */
        for (int i = 0; i < player2.handLimit; i++){
            player2.deck.draw(player2);
        }
    }
    
    void start(){
        System.out.println("Game started!"); 

        try {
            // start game
            new Turn(player1).play();
        } catch (EmptyDeckException ede) {
            gameOver(ede);
        }
    }
    
    void gameOver(Exception e){
        if (e instanceof EmptyDeckException){
            EmptyDeckException ede = (EmptyDeckException)e;
            System.out.println(ede.outOfCardsPlayer.getName() + " Decked-Out.");
            System.out.println(getOtherPlayer(ede.outOfCardsPlayer).getName() + " won.");
        }
        
        System.exit(0);
    }
    
    Player getOtherPlayer(Player thisPlayer){
        return thisPlayer == player1 ? player2 : player1;
    }
    
    class Observer {
        List<EventAction> actions = new ArrayList<>();
        
        void register(EventAction action){
            actions.add(action);
        }
        
        void update(String trigger){
            Iterator<EventAction> iterator = actions.iterator();
            while (iterator.hasNext()){
                EventAction ea = iterator.next();
                if (ea.event == trigger){
                    ea.run();
                }
            }
        }    
    }
}