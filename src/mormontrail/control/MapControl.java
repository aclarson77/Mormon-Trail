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

    private static Scene[] createScenes() {

        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription("starting scene description");
        startingScene.setMapSymbol("ST");
        scenes[SceneType.start.ordinal()] = startingScene;

        //store with inventory list within (pass to view if we need to use as part of view)
        Scene scene2Scene = new Scene();
        scene2Scene.setDescription("store description");
        scene2Scene.setMapSymbol("S2");
        ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setQuantity(25);
        item.setName("Chicken");
        inventoryItems.add(item);
        
//        set new properties for inventory item for (food,ammo,and clothes, like weight) - do
//        several times (5-6 items, representing what's going to be in the store)
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setQuantity(20);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Pig");
        inventoryItems.add(item);
        
        scene2Scene.setInventoryItems(inventoryItems);
        scenes[SceneType.scene2.ordinal()] = scene2Scene;

        Scene scene3Scene = new Scene();
        scene3Scene.setDescription("scene3 description");
        scene3Scene.setMapSymbol("S3");
        scenes[SceneType.scene3.ordinal()] = scene3Scene;

        Scene scene4Scene = new Scene();
        scene4Scene.setDescription("scene4 description");
        scene4Scene.setMapSymbol("S4");
        scenes[SceneType.scene4.ordinal()] = scene4Scene;

        Scene scene5Scene = new Scene();
        scene5Scene.setDescription("scene5 description");
        scene5Scene.setMapSymbol("S5");
        scenes[SceneType.scene5.ordinal()] = scene5Scene;

        Scene scene6Scene = new Scene();
        scene6Scene.setDescription("scene6 description");
        scene6Scene.setMapSymbol("S6");
        scenes[SceneType.scene6.ordinal()] = scene6Scene;

        Scene scene7Scene = new Scene();
        scene7Scene.setDescription("scene7 description");
        scene7Scene.setMapSymbol("S7");
        scenes[SceneType.scene7.ordinal()] = scene7Scene;

        Scene scene8Scene = new Scene();
        scene8Scene.setDescription("scene8 description");
        scene8Scene.setMapSymbol("S8");
        scenes[SceneType.scene8.ordinal()] = scene8Scene;

        Scene scene9Scene = new Scene();
        scene9Scene.setDescription("scene9 description");
        scene9Scene.setMapSymbol("S9");
        scenes[SceneType.scene9.ordinal()] = scene9Scene;

        Scene scene10Scene = new Scene();
        scene10Scene.setDescription("scene10 description");
        scene10Scene.setMapSymbol("10");
        scenes[SceneType.scene10.ordinal()] = scene10Scene;

        Scene scene11Scene = new Scene();
        scene11Scene.setDescription("scene11 description");
        scene11Scene.setMapSymbol("11");
        scenes[SceneType.scene11.ordinal()] = scene11Scene;

        Scene scene12Scene = new Scene();
        scene12Scene.setDescription("scene12 description");
        scene12Scene.setMapSymbol("12");
        scenes[SceneType.scene12.ordinal()] = scene12Scene;

        Scene scene13Scene = new Scene();
        scene13Scene.setDescription("scene13 description");
        scene13Scene.setMapSymbol("13");
        scenes[SceneType.scene13.ordinal()] = scene13Scene;

        Scene scene14Scene = new Scene();
        scene14Scene.setDescription("scene14 description");
        scene14Scene.setMapSymbol("14");
        scenes[SceneType.scene14.ordinal()] = scene14Scene;

        Scene scene15Scene = new Scene();
        scene15Scene.setDescription("scene15 description");
        scene15Scene.setMapSymbol("15");
        scenes[SceneType.scene15.ordinal()] = scene15Scene;

        Scene scene16Scene = new Scene();
        scene16Scene.setDescription("scene16 description");
        scene16Scene.setMapSymbol("16");
        scenes[SceneType.scene16.ordinal()] = scene16Scene;

        Scene scene17Scene = new Scene();
        scene17Scene.setDescription("scene17 description");
        scene17Scene.setMapSymbol("17");
        scenes[SceneType.scene17.ordinal()] = scene17Scene;

        Scene scene18Scene = new Scene();
        scene18Scene.setDescription("scene18 description");
        scene18Scene.setMapSymbol("18");
        scenes[SceneType.scene18.ordinal()] = scene18Scene;

        Scene scene19Scene = new Scene();
        scene19Scene.setDescription("scene19 description");
        scene19Scene.setMapSymbol("19");
        scenes[SceneType.scene19.ordinal()] = scene19Scene;

        Scene scene20Scene = new Scene();
        scene20Scene.setDescription("scene20 description");
        scene20Scene.setMapSymbol("20");
        scenes[SceneType.scene20.ordinal()] = scene20Scene;

        Scene scene21Scene = new Scene();
        scene21Scene.setDescription("scene21 description");
        scene21Scene.setMapSymbol("21");
        scenes[SceneType.scene21.ordinal()] = scene21Scene;

        Scene scene22Scene = new Scene();
        scene22Scene.setDescription("scene22 description");
        scene22Scene.setMapSymbol("22");
        scenes[SceneType.scene22.ordinal()] = scene22Scene;

        Scene scene23Scene = new Scene();
        scene23Scene.setDescription("scene23 description");
        scene23Scene.setMapSymbol("23");
        scenes[SceneType.scene23.ordinal()] = scene23Scene;

        Scene scene24Scene = new Scene();
        scene24Scene.setDescription("scene24 description");
        scene24Scene.setMapSymbol("24");
        scenes[SceneType.scene24.ordinal()] = scene24Scene;

        Scene scene25Scene = new Scene();
        scene25Scene.setDescription("scene25 description");
        scene25Scene.setMapSymbol("25");
        scenes[SceneType.scene25.ordinal()] = scene25Scene;

        Scene finishScene = new Scene();
        finishScene.setDescription("final scene description");
        finishScene.setMapSymbol("FN");
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
