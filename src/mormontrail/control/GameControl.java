/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mormontrail.MormonTrail;
import mormontrail.exceptions.GameControlException;
import mormontrail.model.Actor;
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
    
    
        InventoryItem item = new InventoryItem();
        item.setInventoryType(InventoryType.cornmeal);
        item.setWeight(30);
        inventoryList.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.bacon);
        item.setWeight(5);
        inventoryList.add(item); 
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.clothes);
        item.setWeight(10);
        inventoryList.add(item);  
    
    ArrayList<Actor> actors = new ArrayList<Actor>();
    game.setActors(actors);
        
    Wagon wagon = new Wagon();
    game.setWagon(wagon);
    
    Map map = MapControl.createMap();
    game.setMap(map);
    
        try {
        MapControl.movePlayerToStartingLocation(map);
        }

        catch (mormontrail.exceptions.MapControlException me){
            //keep the same as suggested by Brother Jones on MormonTrail.java?
            System.out.println(me.getMessage());
            //return false;
        }
    
    }
    
    public static ArrayList<InventoryItem> createInventoryList() {
        
        //ArrayList<InventoryItem> inventoryList = GameControl.createInventoryList();
 //   game.setInventory(inventoryList);
    
    
//        InventoryItem item = new InventoryItem();
//        item.setInventoryType(InventoryType.cornmeal);
//        item.setWeight(30);
//        inventoryList.add(item);
//        
//        item = new InventoryItem();
//        item.setInventoryType(InventoryType.bacon);
//        item.setWeight(5);
//        inventoryList.add(item); 
//        
//        item = new InventoryItem();
//        item.setInventoryType(InventoryType.clothes);
//        item.setWeight(10);
//        inventoryList.add(item);
        
        
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
    
    public static void saveGame(Game game, String filepath)
            throws mormontrail.exceptions.GameControlException {
        try(FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        } catch(Exception e) {
            throw new mormontrail.exceptions.GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filepath)
                throws GameControlException {
            Game game = null;
            
            try(FileInputStream fips = new FileInputStream(filepath)) {
                ObjectInputStream input = new ObjectInputStream(fips);
            } catch (Exception e) {
                throw new GameControlException(e.getMessage());
            }
            
            mormontrail.MormonTrail.setCurrentGame(game);  
        }
}
    

