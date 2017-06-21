/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import mormontrail.MormonTrail;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.Map;
import mormontrail.model.Player;
import mormontrail.model.Wagon;

/**
 *
 * @author Andrew
 */
class GameControl {

    public static void createNewGame(Player player) {
    Game game = new Game();
    MormonTrail.setCurrentGame(game);
    
    game.setPlayer(player);
    
    InventoryItem[] inventoryList = GameControl.createInventoryList();
    game.setInventory(inventoryList);
    
    Wagon wagon = new Wagon();
    game.setWagon(wagon);
    
    Map map = MapControl.createMap();
    game.setMap(map);
    
    MapControl.moveActorsToStartingLocation(map);
    }
    
    public static InventoryItem[] createInventoryList() {
        
        InventoryItem[] inventory = new InventoryItem[3];
        
        InventoryItem food = new InventoryItem();
        food.setDescription("Food");
        food.setQuantity(1000);
        // what to assign for required amount?
        food.setRequiredQuantity(0);
        inventory[Item.food.ordinal()] = food;
        
        InventoryItem ammo = new InventoryItem();
        ammo.setDescription("Ammo");
        ammo.setQuantity(100);
        // what to assign for required amount?
        ammo.setRequiredQuantity(0);
        inventory[Item.ammo.ordinal()] = ammo;
        
        InventoryItem clothes = new InventoryItem();
        clothes.setDescription("Clothes");
        clothes.setQuantity(100);
        // what to assign for required amount?
        clothes.setRequiredQuantity(0);
        inventory[Item.clothes.ordinal()] = clothes;
        
        return inventory;
        
        //doesn't specify where we need to put this.
//        public enum Item {
//            food,
//            ammo,
//            clothes;
//        }
    }
    
    public class MapControl {
        public Map createMap() {
            
            Map map = null;
            
            System.out.println("\n*** createMap() called ***");
            
            return map;
        }
        // ???? do we need this?
//        public static Map moveActorsToStartingLocation() {
//            
//        }
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
    

