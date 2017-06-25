/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import java.util.ArrayList;
import mormontrail.MormonTrail;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.Map;
import mormontrail.model.Player;
import mormontrail.model.Wagon;
import mormontrail.model.InventoryType;

/**
 *
 * @author Andrew
 */
public class GameControl {

    public static void createNewGame(Player player) {
    Game game = new Game();
    MormonTrail.setCurrentGame(game);
    
    game.setPlayer(player);
    
    ArrayList<InventoryItem> inventoryList = GameControl.createInventoryList();
    game.setInventory(inventoryList);
    
    Wagon wagon = new Wagon();
    game.setWagon(wagon);
    
    Map map = MapControl.createMap();
    game.setMap(map);
    
    MapControl.movePlayerToStartingLocation(map);
    }
    
    public static ArrayList<InventoryItem> createInventoryList() {
        
        ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();
        
//        InventoryItem food = new InventoryItem();
//        food.setInventoryType(InventoryType.food);
//        food.setQuantity(0);
//        food.setName("Pig");
//        // what to assign for required amount?
//        food.setRequiredQuantity(0);
//        inventory[InventoryType.food.ordinal()] = food;
//        
//        InventoryItem ammo = new InventoryItem();
//        ammo.setInventoryType(InventoryType.ammo);
//        ammo.setQuantity(0);
//        // what to assign for required amount?
//        ammo.setRequiredQuantity(0);
//        inventory[InventoryType.ammo.ordinal()] = ammo;
//        
//        InventoryItem clothes = new InventoryItem();
//        clothes.setInventoryType(InventoryType.clothes);
//        clothes.setQuantity(0);
//        // what to assign for required amount?
//        clothes.setRequiredQuantity(0);
//        inventory[InventoryType.clothes.ordinal()] = clothes;
        
        return inventory;
    }
        
    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        MormonTrail.setPlayer(player);
        
        return player;   
    }
}
    

