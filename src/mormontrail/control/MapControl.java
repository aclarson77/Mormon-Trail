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

        Scene nauvooScene = new Scene();
        nauvooScene.setDescription("Nauvoo, Illinois - Welcome to Nauvoo!");
        nauvooScene.setMapSymbol("ST");
        scenes[SceneType.nauvoo.ordinal()] = nauvooScene;

        //store with inventory list within (pass to view if we need to use as part of view)
        Scene nauvooStoreScene = new Scene();
        nauvooStoreScene.setDescription("Nauvoo City Store");
        nauvooStoreScene.setMapSymbol("NS");
        ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>();
        InventoryItem item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setWeight(10);
        item.setPricePerPound(.20);
        item.setName("Beans");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setWeight(15);
        item.setPricePerPound(.25);
        item.setName("Cornmeal");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setWeight(20);
        item.setPricePerPound(.30);
        item.setName("Potatoes");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setWeight(25);
        item.setPricePerPound(.35);
        item.setName("Chicken");
        inventoryItems.add(item);
        
        
        //set new properties for inventory item for (food,ammo,and clothes, like weight) - do
        //several times (5-6 items, representing what's going to be in the store)
        //*** maybe we have a title of the resource (Food, Ammo, Clothes) with each subitem underneath, respectively?
        item = new InventoryItem();
        item.setInventoryType(InventoryType.food);
        item.setWeight(30);
        item.setPricePerPound(.45);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Pig");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.ammo);
        item.setWeight(35);
        item.setPricePerPound(.25);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Pistol Rounds");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.ammo);
        item.setWeight(45);
        item.setPricePerPound(.35);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Rifle Rounds");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.clothes);
        item.setWeight(25);
        item.setPricePerPound(.75);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Shirts");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.clothes);
        item.setWeight(30);
        item.setPricePerPound(.85);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Pants");
        inventoryItems.add(item);
        
        item = new InventoryItem();
        item.setInventoryType(InventoryType.clothes);
        item.setWeight(15);
        item.setPricePerPound(1.15);
        //set currentQuantity - 2, for example, and have less items and added to inventory.
        item.setName("Coats");
        inventoryItems.add(item);
        
        nauvooStoreScene.setInventoryItems(inventoryItems);
        scenes[SceneType.nauvooStore.ordinal()] = nauvooStoreScene;

        Scene sugarCreekScene = new Scene();
        sugarCreekScene.setDescription("Sugar Creek Camp, Iowa - "
                + "Just on the other side of the Mississippi River from Nauvoo, "
                + "Sugar Creek is the staging area for the great trek westward. "
                    );
        sugarCreekScene.setMapSymbol("SC");
        scenes[SceneType.sugarCreek.ordinal()] = sugarCreekScene;

        Scene gardenGroveScene = new Scene();
        gardenGroveScene.setDescription("Garden Grove, Iowa - "
                + "The first semi-permanent settlement, with 715 acres of food planted"
                + "for passing pioneers.");
        gardenGroveScene.setMapSymbol("GG");
        scenes[SceneType.gardenGrove.ordinal()] = gardenGroveScene;

        Scene richardsonPointScene = new Scene();
        richardsonPointScene.setDescription("Richardson's Point, Iowa - "
                + "After fording the Des Moines River, you arrive in the wooded area"
                + "known as Richardson's point.");
        richardsonPointScene.setMapSymbol("RP");
        scenes[SceneType.richardsonPoint.ordinal()] = richardsonPointScene;

        Scene charitonRiverScene = new Scene();
        charitonRiverScene.setDescription("Chariton River Crossing, Iowa - "
                + "Brigham Young organized the lead group of the original migration"
                + "here at the Chariton River Crossing.");
        charitonRiverScene.setMapSymbol("CR");
        scenes[SceneType.charitonRiver.ordinal()] = charitonRiverScene;

        Scene mountPisgahScene = new Scene();
        mountPisgahScene.setDescription("Mount Pisgah, Iowa - "
                + "You have entered the territory of the Potawatomi Indians. "
                + "Another semi-permanent stettlement was established here to "
                + "benefit future pioneers. ");
        mountPisgahScene.setMapSymbol("MP");
        scenes[SceneType.mountPisgah.ordinal()] = mountPisgahScene;

        Scene nishnabotnaRiverScene = new Scene();
        nishnabotnaRiverScene.setDescription("Nishnabotna River Crossing, Iowa - "
                + "The Potawatomi Indians were also refugees, Nishnabotna River crossing"
                + "has a Potawatomi encampment along the river.");
        nishnabotnaRiverScene.setMapSymbol("NR");
        scenes[SceneType.nishnabotnaRiver.ordinal()] = nishnabotnaRiverScene;

        Scene grandEncampmentScene = new Scene();
        grandEncampmentScene.setDescription("Grand Encampment, Iowa - "
                + "Here is where the Grand Encampment was organized. From this site,"
                + "the Mormoon Battalion departed for the Mexican-American War.");
        grandEncampmentScene.setMapSymbol("GE");
        scenes[SceneType.grandEncampment.ordinal()] = grandEncampmentScene;

        Scene kanesvilleScene = new Scene();
        kanesvilleScene.setDescription("Kanesville, Iowa - "
                + "The important settlement and outfitting point along the Missouri River."
        );
        kanesvilleScene.setMapSymbol("KV");
        scenes[SceneType.kanesville.ordinal()] = kanesvilleScene;

        Scene winterQuartersScene = new Scene();
        winterQuartersScene.setDescription("Winter Quarters, Nebraska - "
                + "Brigham Young settled here for the winter of 1846-47 before finishing the "
                + "trek to Utah. Winter Quarters is an important place to trade for equipment "
                + "and supplies. ");
        winterQuartersScene.setMapSymbol("WQ");
        scenes[SceneType.winterQuarters.ordinal()] = winterQuartersScene;

        Scene platteRiverScene = new Scene();
        platteRiverScene.setDescription("Platte River, Nebraska - "
                + "Following the Platte River is a dangerous gamble, the "
                + "amount of traffic on both sides of the river makes the "
                + "area void of feed for the oxen.");
        platteRiverScene.setMapSymbol("PR");
        scenes[SceneType.platteRiver.ordinal()] = platteRiverScene;

        Scene fortKearnyScene = new Scene();
        fortKearnyScene.setDescription("Fort Kearny, Nebraska - "
                + "Fort Kearny, purchased for $2,000 in goods from the"
                + "Pawnee Indians, was named after Stephen Watts Kearny. ");
        fortKearnyScene.setMapSymbol("FK");
        scenes[SceneType.fortKearny.ordinal()] = fortKearnyScene;

        Scene ashHollowScene = new Scene();
        ashHollowScene.setDescription("Ash Hollow, Nebraska - "
                + "Once a beautiful place, the many passing emigrants "
                + "left a mark in this area. The Sioux indians are not"
                + "far away from here.");
        ashHollowScene.setMapSymbol("AH");
        scenes[SceneType.ashHollow.ordinal()] = ashHollowScene;

        Scene chimneyRockScene = new Scene();
        chimneyRockScene.setDescription("Chimney Rock, Nebraska - "
                + "The most significant landmark on the trail. Many names"
                + "are found carved on Chimney Rock.");
        chimneyRockScene.setMapSymbol("CR");
        scenes[SceneType.chimneyRock.ordinal()] = chimneyRockScene;

        Scene fortLaramieScene = new Scene();
        fortLaramieScene.setDescription("Fort Laramie, Wyoming - "
                + "An old trading and military post, here is a great place to "
                + "rest and restock provisions.");
        fortLaramieScene.setMapSymbol("FL");
        scenes[SceneType.fortLaramie.ordinal()] = fortLaramieScene;

        Scene redButteScene = new Scene();
        redButteScene.setDescription("Red Butte, Wyoming - "
                + "A tragic site for the Martin Willie Handcart Company. "
                + "Many emigrants died from harsh winter conditions here.");
        redButteScene.setMapSymbol("RB");
        scenes[SceneType.redButte.ordinal()] = redButteScene;

        Scene independenceRockScene = new Scene();
        independenceRockScene.setDescription("Independence Rock, Wyoming - "
                + "One of the most anticipated landmarks on the trail.");
        independenceRockScene.setMapSymbol("IR");
        scenes[SceneType.independenceRock.ordinal()] = independenceRockScene;

        Scene devilsGateScene = new Scene();
        devilsGateScene.setDescription("Devil's Gate, Wyoming - "
                + "A narrow gorge cut through the rocks by the Sweetwater River.");
        devilsGateScene.setMapSymbol("DG");
        scenes[SceneType.devilsGate.ordinal()] = devilsGateScene;

        Scene martinsCoveScene = new Scene();
        martinsCoveScene.setDescription("Martin's Cove, Wyoming - "
                + "A camp of the Martin Handcart Company during a blizzard.");
        martinsCoveScene.setMapSymbol("MC");
        scenes[SceneType.martinsCove.ordinal()] = martinsCoveScene;

        Scene southPassScene = new Scene();
        southPassScene.setDescription("South Pass, Wyoming - "
                + "At nearly 7,550 feet in elevation, South Pass is an important landmark.");
        southPassScene.setMapSymbol("SP");
        scenes[SceneType.southPass.ordinal()] = southPassScene;

        Scene fortBridgerScene = new Scene();
        fortBridgerScene.setDescription("Ft. Bridger, Wyoming - "
                + "Established by famous mountain man Jim Bridger. Here, the Mormon,"
                + "Oregon, and California trail separates.");
        fortBridgerScene.setMapSymbol("FB");
        scenes[SceneType.fortBridger.ordinal()] = fortBridgerScene;

        Scene bearRiverScene = new Scene();
        bearRiverScene.setDescription("Bear River, Wyoming - "
                + "One of the final river crossings on the trail.");
        bearRiverScene.setMapSymbol("BR");
        scenes[SceneType.bearRiver.ordinal()] = bearRiverScene;

        Scene echoCanyonScene = new Scene();
        echoCanyonScene.setDescription("Echo Canyon, Utah - "
                + "One of the final canyon descents along the trail. It often echoes.");
        echoCanyonScene.setMapSymbol("EC");
        scenes[SceneType.echoCanyon.ordinal()] = echoCanyonScene;

        Scene emigrationCanyonScene = new Scene();
        emigrationCanyonScene.setDescription("Emigration Canyon, Utah - "
                + "A geographical obstacle between Big Mountain and the Salt Lake Valley.");
        emigrationCanyonScene.setMapSymbol("EM");
        scenes[SceneType.emigrationCanyon.ordinal()] = emigrationCanyonScene;

        Scene saltLakeValleyScene = new Scene();
        saltLakeValleyScene.setDescription("Salt Lake Valley, Utah - "
                + "You made it to the end of the trail!"
                + "Hooray!"
                + "....Well, sorta. Brigham Young might send you as far as Canada or Mexico now. "
                + "Are you up for another trek?");
        saltLakeValleyScene.setMapSymbol("SV");
        scenes[SceneType.saltLakeValley.ordinal()] = saltLakeValleyScene;

        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations[0][0].setScene(scenes[SceneType.nauvoo.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.nauvooStore.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.sugarCreek.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.gardenGrove.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.richardsonPoint.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.charitonRiver.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.mountPisgah.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.nishnabotnaRiver.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.grandEncampment.ordinal()]);
        locations[0][9].setScene(scenes[SceneType.kanesville.ordinal()]);
        locations[0][10].setScene(scenes[SceneType.winterQuarters.ordinal()]);
        locations[0][11].setScene(scenes[SceneType.platteRiver.ordinal()]);
        locations[0][12].setScene(scenes[SceneType.fortKearny.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.ashHollow.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.chimneyRock.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.fortLaramie.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.redButte.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.independenceRock.ordinal()]);
        locations[1][5].setScene(scenes[SceneType.devilsGate.ordinal()]);
        locations[1][6].setScene(scenes[SceneType.martinsCove.ordinal()]);
        locations[1][7].setScene(scenes[SceneType.southPass.ordinal()]);
        locations[1][8].setScene(scenes[SceneType.fortBridger.ordinal()]);
        locations[1][9].setScene(scenes[SceneType.bearRiver.ordinal()]);
        locations[1][10].setScene(scenes[SceneType.echoCanyon.ordinal()]);
        locations[1][11].setScene(scenes[SceneType.emigrationCanyon.ordinal()]);
        locations[1][12].setScene(scenes[SceneType.saltLakeValley.ordinal()]);
    }
}
