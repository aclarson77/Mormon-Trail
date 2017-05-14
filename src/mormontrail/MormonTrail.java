/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail;

import mormontrail.model.Actor;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.Player;
import mormontrail.model.Question;
import mormontrail.model.RandomEvent;
import mormontrail.model.RegularSceneType;

/**
 *
 * @author andrew
 */
public class MormonTrail {


public static void teamClassTest(){
    Player playerOne = new Player();
        
    playerOne.setName("Fred Flinstone");
    playerOne.setBestScore(20);
        
    String playerInfo = playerOne.toString();
    System.out.println(playerInfo);
        
}

public static void andrewClassTest(){
    
    // Actor Class 
    Actor actorOne = new Actor();
    
    actorOne.setName("Parley Pratt");
    actorOne.setDescription("Man of God");
    actorOne.setCoordinates("Winter Quarters");
    actorOne.setHealth("Your health gets better when you pray");
    
    String actorInfo = actorOne.toString();
    System.out.println(actorInfo);
    
    //Game Class
    Game gameOne = new Game();
    
    gameOne.setBestScore(100);
    gameOne.setNamePlayer("Not sure what this attribute is for");
    gameOne.setSaveLog("Parley Pratt saved game");
    
    String gameInfo = gameOne.toString();
    System.out.println(gameInfo);
    
    //InventroyItem Class
    InventoryItem suppliesInWagaon = new InventoryItem();
    
    suppliesInWagaon.setInventoryType("Hammer");
    suppliesInWagaon.setQuantityInStock(10);
    suppliesInWagaon.setRequiredAmount(15);
    suppliesInWagaon.setMaxAmount(50);
    suppliesInWagaon.setAmount(5);
    
    String suppliesInfo = suppliesInWagaon.toString();
    System.out.println(suppliesInfo);
}

public static void joshuaClassTest(){

}

public static void ajClassTest(){

    //QUESTION Class  - A.J. Hess - Testing functions
    Question questionOne = new Question();
    
    questionOne.setQuestion("Do you?");
    questionOne.setPossibleAnswer("Maybe?");
    questionOne.setCorrectAnswer("No.");
    
    String questionInfo = questionOne.toString();
    System.out.println(questionInfo);
    
    //REGULAR SCENE TYPE Class  - A.J. Hess - Testing functions
    RegularSceneType sceneOne = new RegularSceneType();
    
    sceneOne.setScenario("Do you want to cross the river?");
    sceneOne.setDescription("You are at a river you need to cross.");
    sceneOne.setSymbol("@##@@#@#   ...I don't know what this symbol thing is here for.");
    
    String sceneInfo = sceneOne.toString();
    System.out.println(sceneInfo);
    
     //RANDOM EVENT Class  - A.J. Hess - Testing functions
    RandomEvent eventOne = new RandomEvent();
    
    eventOne.setPositiveEvent("You found an abandoned wagon with a spare wagon wheel!");
    eventOne.setNegativeEvent("You forgot to pray. Half of your food is stolen by Indians.");
    eventOne.setNothingHappens("............*****pitter-patter of rain falling on the prarie*****........");
 
    String eventInfo = eventOne.toString();
    System.out.println(eventInfo);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        teamClassTest();
        andrewClassTest();
        joshuaClassTest();
        ajClassTest();
        
        
        
    }
    
}
