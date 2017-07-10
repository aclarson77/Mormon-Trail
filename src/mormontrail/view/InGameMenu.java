/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mormontrail.MormonTrail;
import mormontrail.control.MapControl;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.InventoryType;
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
                  + "\nE - Print Inventory Item List"
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
            case "E":
                this.printInventory();
                break;
            case "S":
                this.saveGame(); // Currently GamesLog. GamesLog will be in MainMenuView once we hook our individual assignments.
                break;
            case "Q":
                this.backToMainMenu();
                break;   
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    private boolean advanceTrail() {
        
        StringBuilder line;
        
        Game game = MormonTrail.getCurrentGame();
        ArrayList<InventoryItem> inventory = game.getInventory();
        
        this.console.println("\n  "
                    + "\n------------------------------------------------------------------" 
                    + "\n Church leaders have given you some basic supplies to help you "
                    + "\n get started along your journey. However, they will not be enough" 
                    + "\n for you to complete your entire trek. The following have been "
                    + "\n provided to you. "
                    + "\n------------------------------------------------------------------");

        this.console.println("\n  LIST OF CURRENT INVENTORY ITEMS");
        this.console.println("");
        
        line = new StringBuilder("                                     ");
        line.insert(5, "DESCRIPTION");
        line.insert(20, "WEIGHT");
        this.console.println(line.toString());
        
        int totalWeight = 0;
        int wagonWeight = 100;
        
        for (InventoryItem item1 : inventory) {
            line = new StringBuilder("                                      ");
            line.insert(5, item1.getInventoryType().getDescription());
            line.insert(20, item1.getWeight());
            totalWeight += item1.getWeight();
            
            this.console.println(line.toString());
        }
        this.console.println("");     
        this.console.println("Your total inventory weight is " + totalWeight + " pounds."
                            + "\n ");
                            
        
        totalWeight = totalWeight + wagonWeight;
        
        this.console.println("Your combined wagon and invetory weight is " + totalWeight + " pounds."
                            + "\n You will now purchase your remaining supplies at the Nauvoo Store.  "
                            + "\n------------------------------------------------------------------");
        
        
        Map map = MormonTrail.getCurrentGame().getMap();
        if(map.getCurrentColumn() < 12) {
            try {
            MapControl.movePlayer(map, map.getCurrentRow(), map.getCurrentColumn() + 1);
            }
            
            catch (mormontrail.exceptions.MapControlException me) {
                System.out.println(me.getMessage());
                return false;
                }
            
            if(map.getCurrentRow() == 1 && map.getCurrentColumn() == 12) {
                this.console.println("This is the place! You are at the end of the game.");
                // This is the place!
                return true;
            }
        } 
        else {
            if(map.getCurrentRow() == 1) {
                //You're at the end of the game!
                this.console.println("You're at the end of the game!");
                return true;
            }
            
        else
                //*****add try catch around all movePlayer
            try {
                MapControl.movePlayer(map, 1, 0); 
            }
            
            catch (mormontrail.exceptions.MapControlException me) {
                System.out.println(me.getMessage());
                return false;
            }
            
        }
        switch (map.getCurrentScene().getMapSymbol()){
            //cases for other stores
            case "NS":
                Store store = new Store();
                store.setStoreName(map.getCurrentScene().getDescription());
                store.setStoreInventory(map.getCurrentScene().getInventoryItems());
                store.getInventory(false);
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
        
        this.console.println("\n******LIST OF INVENTORY ITEMS******");
        line = new StringBuilder("                                     ");
        line.insert(5, "DESCRIPTION");
        line.insert(20, "WEIGHT");
        this.console.println(line.toString());
        
        int totalWeight = 0;
        
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                      ");
            line.insert(5, item.getInventoryType().getDescription());
            line.insert(20, item.getWeight());
            totalWeight += item.getWeight();
            
            this.console.println(line.toString());
        }
        this.console.println("Your total inventory weight: " + totalWeight);
        // and total weight on the wagon is:
    }
    
    public void displayMap() {
        String leftIndicator;
        String rightIndicator;

        Game game = MormonTrail.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        this.console.print("  |");
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            if(column < 10){
                this.console.print("  " + column + " |");
            }
            else
                this.console.print(" " + column + " |");
        }
        // Now build the map.  For each row, show the column information
        this.console.println();
        for (int row = 0; row < locations.length; row++) {
            this.console.print(row + " "); // print row numbers to side of map
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
                this.console.print("|"); // start map with a |
                if (locations[row][column].getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    this.console.print(leftIndicator + "??" + rightIndicator);
                } else {
                    this.console.print(leftIndicator
                            + locations[row][column].getScene().getMapSymbol()
                            + rightIndicator);
                }
            }
            this.console.println("|");
        }
        this.console.println("\nYou are currently at " + map.getCurrentScene().getDescription());
    }
    
    private void wagonStatus() {
        this.console.println("Your wagon is under contruction. It will be ready for"
                + " travel along the trail once the game is up and running.");
    }

    private void talkToPeople() {
        this.console.println("You meet a sleep deprived programmer. He doesn't say"
                + " much. You back away slowly to avoid the awkward silence.");
    }

    private void scavengeSupplies() {
        this.console.println("*** scavengeSupplies function called ***");
    }
    
    private void purchaseSupplies() {
        
        this.console.println("\n You enter the store.");

        Store store = new Store();

        store.display();

    }
    
    private void buySupplies() {
        this.console.println("\n You enter the fort."
                          );

        Fort fort = new Fort();
        fort.display();}

    private void leaveItems() {
        
        LeaveItems leaveItems = new LeaveItems();
        leaveItems.display();
    }
    
    private void printInventory() {

//        this.console.println("\n\nEnter the file path for the file to be saved: ");
//        String filePath = this.getInput();

        Scanner sc = new Scanner(System.in);
        System.out.print("Input file path: ");
        String fileName = sc.next();
        File inputFile = new File(fileName);
        
        Game game = MormonTrail.getCurrentGame();
        ArrayList<InventoryItem> inventory = game.getInventory();
        //FileWriter outFile = null;
        String fileLocation = "InventoryReport.txt";
        

        try (PrintWriter out = new PrintWriter(fileLocation)){
            
            out.println("\n\n      Inventory Item Report        ");
            out.printf("%n%-20s%10s", "Description", "Weight");
            out.printf("%n%-20s%10s", "-----------", "------");
        
        for (InventoryItem item : inventory) {
            out.printf("%n%-20s%7s", item.getInventoryType().getDescription()
                                         , item.getWeight());
            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        } 
    }
    
    //saveGame should be out of the game - in MainMenuView
    private void saveGame() {
        //should be in MainMenuView for Recent Games
        GamesLog gamesLog = new GamesLog();
        gamesLog.display();
    }

    private void backToMainMenu() {
        this.console.println("*** backToMainMenu function called ***");
    }   
}
