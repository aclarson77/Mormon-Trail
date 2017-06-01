/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import mormontrail.MormonTrail;
import mormontrail.model.Player;

/**
 *
 * @author Andrew
 */
class GameControl {


    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        MormonTrail.setPlayer(player);
        
        return player;   
    }

    static void createNewGame(Player player) {
        System.out.println("\n*** createNewGame stub fucntion called ***");

    }
}
    

