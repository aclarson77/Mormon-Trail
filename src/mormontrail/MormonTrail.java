/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail;

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

public static void andrewClassTest(){

}

public static void joshuaClassTest(){

}

public static void ajClassTest(){

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
