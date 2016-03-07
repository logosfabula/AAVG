
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author logosfabula
 */
public class MainPhase extends Phase{
    GameStack gameStack = Game.game.gameStack;
    int passes = 2;
    Player priorityPlayer = currentPlayer;
    Player nonPriorityPlayer = rivalPlayer;

    @Override
    void play() throws EmptyDeckException{
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
        System.out.println("Your creatures' abilities:");
        priorityPlayer.board.describeAbilities();
        System.out.println("The game's stack:");
        gameStack.describe();
        System.out.println("Type C then number to play a card. Type A then number to play a creature's ability. Type P to pass priority or end phase.");
        
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        
        if (!(gameStack.isEmpty() && "P".equals(choice))){
            if (passes > 0){
                if ("C".equals(choice)){
                    int selectedCard = scan.nextInt();
                    Card playedCard = priorityPlayer.hand.pick(selectedCard - 1);
                    gameStack.addSpell(playedCard.getSpell());
                    passes = 2;
                } 
                else if ("A".equals(choice)){ //TO DO: le abilità delle creature possono essere rigiocate: correggere!
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
            } 
            else {
                priorityPlayer = currentPlayer;
                gameStack.execute();
            }

            play();
        } else {
            finish();
        }
    }
}
