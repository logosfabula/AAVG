
import java.util.Scanner;

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
public class MainPhase extends Phase{
    GameStack gameStack;
    int passes = 2;
    Player priorityPlayer = currentPlayer;
    Player nonPriorityPlayer = rivalPlayer;

    public MainPhase() {
        this.gameStack = Game.game.gameStack;
    }

    @Override
    void play() throws EmptyDeckException{
        super.play();
        System.out.println("Priority owned by " + priorityPlayer.getName());
        
        System.out.println("Your life points:");
        System.out.println(priorityPlayer.getLifePoints());
        System.out.println("Your rival's life points:");
        System.out.println(nonPriorityPlayer.getLifePoints());
        System.out.println("Your board:");
        priorityPlayer.board.describe();
        System.out.println("Your rival's board:");
        nonPriorityPlayer.board.describe();
        System.out.println("Your hand:");
        if (gameStack.isEmpty())
            priorityPlayer.hand.describe();
        else
            priorityPlayer.hand.describeInstants();
        System.out.println("Abilities:");
        priorityPlayer.board.describeAbilities();
        System.out.println("The game's stack:");
        gameStack.describe();
        System.out.println("Type C to play a card. Type A to play a creature's ability. Type P to pass priority or end phase.");
        
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        
        if (!(gameStack.isEmpty() && "P".equals(choice))){
            System.out.println("passes: " + passes);
            
            if ("C".equals(choice)){
                System.out.println("Pick one card:");
                int selectedCard = scan.nextInt();
                Card playedCard = priorityPlayer.hand.pick(selectedCard - 1);
                gameStack.addSpell(playedCard.getSpell());
                passes = 2;
            } 
            else if ("A".equals(choice)){ //TO DO: le abilità delle creature possono essere rigiocate: correggere!
                System.out.println("Pick one creature's ability :");
                int selectedCreature = scan.nextInt();
                Creature activatedCreature = priorityPlayer.board.getCreature(selectedCreature);
                gameStack.addSpell(activatedCreature.getEffect());
                passes = 2;
            } 
            else if ("P".equals(choice)){
                passes--;
                priorityPlayer = (priorityPlayer == currentPlayer) ? rivalPlayer : currentPlayer ;
            } 
            else {
                System.out.println("Please type C, A or P.");
            }             
             
            if (passes <= 0){
                priorityPlayer = currentPlayer;
                gameStack.execute();
                passes = 2;
            }

            play();
        } else {
            finish();
        }
    }
}
