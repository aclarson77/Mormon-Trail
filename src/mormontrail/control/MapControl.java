/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import java.util.ArrayList;
import mormontrail.model.InventoryItem;
import mormontrail.model.InventoryType;
import mormontrail.model.Location;
import mormontrail.model.Map;
import mormontrail.model.Scene;
import mormontrail.model.SceneType;

/**
 *
 * @author Joshua
 */
public class MapControl {
    
    public static Map createMap() {
        
        Map map = new Map(2, 13);
        
        Scene[] scenes = createScenes();
        
        assignScenesToLocations(map, scenes);
        
        return map;       
    }
    
public static void movePlayerToStartingLocation(Map map) {
   // If starting location is not supposed to be 0,0 then use the correct values here.
   movePlayer(map, 0, 0); // or instead of 0,0 you can select a different starting location
}

public static void movePlayer(Map map, int row, int column) {
   map.setCurrentLocation(map.getLocations()[row][column]);
   map.getCurrentLocation().setVisited(true);
   map.setCurrentRow(row);
   map.setCurrentColumn(column);
   map.setCurrentScene(map.getLocations()[row][column].getScene());
}
//https://en.wikipedia.org/wiki/Mormon_Trail
    private static Scene[] createScenes() {

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription("Nauvoo, Illinois - Welcome to Nauvoo!");
        startingScene.setMapSymbol("ST");
        scenes[SceneType.start.ordinal()] = startingScene;

        //store with inventory list within (pass to view if we need to use as part of view)
        Scene scene2Scene = new Scene();
        scene2Scene.setDescription("Nauvoo City Store - Welcome to the Nauvoo Store!");
        scene2Scene.setMapSymbol("NS");
        ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setQuantity(25);
        item.setName("Chicken");
        inventoryItems.add(item);
        
        //set new properties for inventory item for (food,ammo,and clothes, like weight) - do
        //several times (5-6 items, representing what's going to be in the store)
        //*** maybe we have a title of the resource (Food, Ammo, Clothes) with each subitem underneath, respectively?
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setQuantity(20);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Pig");
        inventoryItems.add(item);
        
        scene2Scene.setInventoryItems(inventoryItems);
        scenes[SceneType.scene2.ordinal()] = scene2Scene;

        Scene scene3Scene = new Scene();
        scene3Scene.setDescription("Sugar Creek Camp, Iowa - [description]");
        scene3Scene.setMapSymbol("SC");
        scenes[SceneType.scene3.ordinal()] = scene3Scene;

        Scene scene4Scene = new Scene();
        scene4Scene.setDescription("Garden Grove, Iowa - [description]");
        scene4Scene.setMapSymbol("GG");
        scenes[SceneType.scene4.ordinal()] = scene4Scene;

        Scene scene5Scene = new Scene();
        scene5Scene.setDescription("Richardson's Point, Iowa - [description]");
        scene5Scene.setMapSymbol("RP");
        scenes[SceneType.scene5.ordinal()] = scene5Scene;

        Scene scene6Scene = new Scene();
        scene6Scene.setDescription("Chariton River Crossing, Iowa - [description]");
        scene6Scene.setMapSymbol("CR");
        scenes[SceneType.scene6.ordinal()] = scene6Scene;

        //duplicate - move others up and include one more Utah location/scene
        Scene scene7Scene = new Scene();
        scene7Scene.setDescription("Garden Grove, Iowa - [description]");
        scene7Scene.setMapSymbol("S7");
        scenes[SceneType.scene7.ordinal()] = scene7Scene;

        Scene scene8Scene = new Scene();
        scene8Scene.setDescription("Mount Pisgah, Iowa - [description]");
        scene8Scene.setMapSymbol("MP");
        scenes[SceneType.scene8.ordinal()] = scene8Scene;

        Scene scene9Scene = new Scene();
        scene9Scene.setDescription("Nishnabotna River Crossing, Iowa - [description]");
        scene9Scene.setMapSymbol("NR");
        scenes[SceneType.scene9.ordinal()] = scene9Scene;

        Scene scene10Scene = new Scene();
        scene10Scene.setDescription("Grand Encampment, Iowa - [description]");
        scene10Scene.setMapSymbol("GE");
        scenes[SceneType.scene10.ordinal()] = scene10Scene;

        Scene scene11Scene = new Scene();
        scene11Scene.setDescription("Kanesville, Iowa - [description]");
        scene11Scene.setMapSymbol("KV");
        scenes[SceneType.scene11.ordinal()] = scene11Scene;

        Scene scene12Scene = new Scene();
        scene12Scene.setDescription("Winter Quarters, Nebraska - [description]");
        scene12Scene.setMapSymbol("WQ");
        scenes[SceneType.scene12.ordinal()] = scene12Scene;

        Scene scene13Scene = new Scene();
        scene13Scene.setDescription("Elkhorn/Platte River, Nebraska - [description]");
        scene13Scene.setMapSymbol("PR");
        scenes[SceneType.scene13.ordinal()] = scene13Scene;

        Scene scene14Scene = new Scene();
        scene14Scene.setDescription("Fort Kearny, Nebraska - [description]");
        scene14Scene.setMapSymbol("FK");
        scenes[SceneType.scene14.ordinal()] = scene14Scene;

        Scene scene15Scene = new Scene();
        scene15Scene.setDescription("Ash Hollow, Nebraska - [description]");
        scene15Scene.setMapSymbol("AH");
        scenes[SceneType.scene15.ordinal()] = scene15Scene;

        Scene scene16Scene = new Scene();
        scene16Scene.setDescription("Chimney Rock, Nebraska - [description]");
        scene16Scene.setMapSymbol("CR");
        scenes[SceneType.scene16.ordinal()] = scene16Scene;

        Scene scene17Scene = new Scene();
        scene17Scene.setDescription("Fort Laramie, Wyoming - [description]");
        scene17Scene.setMapSymbol("FL");
        scenes[SceneType.scene17.ordinal()] = scene17Scene;

        Scene scene18Scene = new Scene();
        scene18Scene.setDescription("Red Butte, Wyoming - [description]");
        scene18Scene.setMapSymbol("RB");
        scenes[SceneType.scene18.ordinal()] = scene18Scene;

        Scene scene19Scene = new Scene();
        scene19Scene.setDescription("Independence Rock, Wyoming - [description]");
        scene19Scene.setMapSymbol("IR");
        scenes[SceneType.scene19.ordinal()] = scene19Scene;

        Scene scene20Scene = new Scene();
        scene20Scene.setDescription("Devil's Gate, Wyoming - [description]");
        scene20Scene.setMapSymbol("DG");
        scenes[SceneType.scene20.ordinal()] = scene20Scene;

        Scene scene21Scene = new Scene();
        scene21Scene.setDescription("Martin's Cove, Wyoming - [description]");
        scene21Scene.setMapSymbol("MC");
        scenes[SceneType.scene21.ordinal()] = scene21Scene;

        Scene scene22Scene = new Scene();
        scene22Scene.setDescription("Rock Creek/South Pass, Wyoming - [description]");
        scene22Scene.setMapSymbol("SP");
        scenes[SceneType.scene22.ordinal()] = scene22Scene;

        Scene scene23Scene = new Scene();
        scene23Scene.setDescription("Ft. Bridger, Wyoming - [description]");
        scene23Scene.setMapSymbol("FB");
        scenes[SceneType.scene23.ordinal()] = scene23Scene;

        Scene scene24Scene = new Scene();
        scene24Scene.setDescription("Bear River, Wyoming - [description]");
        scene24Scene.setMapSymbol("BR");
        scenes[SceneType.scene24.ordinal()] = scene24Scene;

        Scene scene25Scene = new Scene();
        scene25Scene.setDescription("Emigration Canyon, Utah - [description]");
        scene25Scene.setMapSymbol("EC");
        scenes[SceneType.scene25.ordinal()] = scene25Scene;

        Scene finishScene = new Scene();
        finishScene.setDescription("Salt Lake Valley, Utah - [description]");
        finishScene.setMapSymbol("SV");
        scenes[SceneType.finish.ordinal()] = finishScene;

        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.scene2.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.scene3.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.scene4.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.scene5.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.scene6.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.scene7.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.scene8.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.scene9.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.scene10.ordinal()]);
        locations[0][10].setScene(scenes[SceneType.scene11.ordinal()]);
        locations[0][11].setScene(scenes[SceneType.scene12.ordinal()]);
        locations[0][12].setScene(scenes[SceneType.scene13.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.scene14.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.scene15.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.scene16.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.scene17.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.scene18.ordinal()]);
        locations[1][5].setScene(scenes[SceneType.scene19.ordinal()]);
        locations[1][6].setScene(scenes[SceneType.scene20.ordinal()]);
        locations[1][7].setScene(scenes[SceneType.scene21.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.scene22.ordinal()]);
        locations[1][9].setScene(scenes[SceneType.scene23.ordinal()]);
        locations[1][10].setScene(scenes[SceneType.scene24.ordinal()]);
        locations[1][11].setScene(scenes[SceneType.scene25.ordinal()]);
        locations[1][12].setScene(scenes[SceneType.finish.ordinal()]);
    }

}
