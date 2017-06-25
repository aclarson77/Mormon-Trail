/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import mormontrail.MormonTrail;
import mormontrail.control.MapControl;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.Location;
import mormontrail.model.Map;

/**
 *
 * @author Andrew
 */

//InGameMenu should display after Store, as the Trek begins once supplies have been purchased.
public class InGameMenu extends View {
    
    public InGameMenu (){
         super("\n"
                  + "\n--------------------------------------" 
                  + "\n| Mormon Oregon Trail"
                  + "\n--------------------------------------"
                  + "\nA - Advance Along Trail"
                  + "\nM - Show Map"
                  + "\nI - Show Inventory"
                  + "\nW - Display Wagon Status"
                  + "\nT - Talk to People"
                  + "\nC - Scavenge for Supplies"
                  + "\nP - Purchase Supplies (at store, if at beginning of trail)" //
                  + "\nB - Buy Supplies (at fort, if along the trail)"
                  + "\nL - Leave Items Behind"
                  + "\nS - Save Game"
                  + "\nQ - Back to main menu"
                  + "\n--------------------------------------");
    }
    
   
    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
        
        switch (value) {
            case "A":
                return this.advanceTrail();
            case "M":
                this.displayMap();
                break;
            case "I":
                this.viewInventory();
                break;
            case "W":
                this.wagonStatus();
                break;
            case "T":
                this.talkToPeople();
                break;
            case "C":
                this.scavengeSupplies();
                break;
            case "P":
                this.purchaseSupplies();
                break;
            case "B":
                this.buySupplies();
                break;
            case "L":
                this.leaveItems();
                break;
            case "S":
                this.saveGame(); // Currently GamesLog. GamesLog will be in MainMenuView once we hook our individual assignments.
                break;
            case "Q":
                this.backToMainMenu();
                break;   
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    private boolean advanceTrail() {
        
        Map map = MormonTrail.getCurrentGame().getMap();
        if(map.getCurrentColumn() < 12) {
            MapControl.movePlayer(map, map.getCurrentRow(), map.getCurrentColumn() + 1);
            if(map.getCurrentRow() == 1 && map.getCurrentColumn() == 12) {
                System.out.println("This is the place! You are at the end of the game.");
                // This is the place!
                return true;
            }
        } else{
            if(map.getCurrentRow() == 1) {
                //You're at the end of the game!
                System.out.println("You're at the end of the game!");
                return true;
            }
            else
               MapControl.movePlayer(map, 1, 0);
        }
        switch (map.getCurrentScene().getMapSymbol()){
            //cases for other stores
            case "NS":
                Store store = new Store();
                store.setStoreName(map.getCurrentScene().getDescription());
                store.setStoreInventory(map.getCurrentScene().getInventoryItems());
                store.getInventory();
                store.display();
                break;  
        }
        displayMap();
        return false;
    }

    private void viewInventory() {
        StringBuilder line;
        
        Game game = MormonTrail.getCurrentGame();
        ArrayList<InventoryItem> inventory = game.getInventory();
        
        System.out.println("\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                     ");
        line.insert(5, "DESCRIPTION");
        line.insert(20, "WEIGHT");
        System.out.println(line.toString());
        
        int totalWeight = 0;
        
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                      ");
            line.insert(5, item.getInventoryType().getDescription());
            line.insert(20, item.getWeight());
            totalWeight += item.getWeight();
            
            System.out.println(line.toString());
        }
        System.out.println("Your total inventory weight: " + totalWeight);
        // and total weight on the wagon is:
    }

    public void displayMap() {
        String leftIndicator;
        String rightIndicator;

        Game game = MormonTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        System.out.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            if(column < 10){
                System.out.print("  " + column + " |");
            }
            else
                System.out.print(" " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        System.out.println();
        for (int row = 0; row < locations.length; row++) {
            System.out.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                System.out.print("|"); // start map with a |
                if (locations[row][column].getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    System.out.print(leftIndicator + "??" + rightIndicator);
                } else {
                    System.out.print(leftIndicator
                            + locations[row][column].getScene().getMapSymbol()
                            + rightIndicator);
                }
            }
            System.out.println("|");
        }
        System.out.println("\nYou are currently at " + map.getCurrentScene().getDescription());
    }
    
    private void wagonStatus() {
        System.out.println("Your wagon is under contruction. It will be ready for"
                + " travel along the trail once the game is up and running.");
    }

    private void talkToPeople() {
        System.out.println("You meet a sleep deprived programmer. He doesn't say"
                + " much. You back away slowly to avoid the awkward silence.");
    }

    private void scavengeSupplies() {
        System.out.println("*** scavengeSupplies function called ***");
    }
    
    private void purchaseSupplies() {
        
        System.out.println("\n You enter the store.");

        Store store = new Store();

        store.display();

    }
    
    private void buySupplies() {
        System.out.println("\n You enter the fort."
                          );

        Fort fort = new Fort();
        fort.display();}

    private void leaveItems() {
        
        LeaveItems leaveItems = new LeaveItems();
        leaveItems.display();
    }
    
    //saveGame should be out of the game - in MainMenuView
    private void saveGame() {
        //should be in MainMenuView for Recent Games
        GamesLog gamesLog = new GamesLog();
        gamesLog.display();
    }

    private void backToMainMenu() {
        System.out.println("*** backToMainMenu function called ***");
    }   
}