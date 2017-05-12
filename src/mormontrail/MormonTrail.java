/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail;

import mormontrail.model.Player;

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
