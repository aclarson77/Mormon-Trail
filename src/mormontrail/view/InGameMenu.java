/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.Scanner;
import mormontrail.MormonTrail;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;

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
                this.advanceTrail();
                break;
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

    private void advanceTrail() {
        System.out.println("*** advanceTrail function called ***");
    }

    //Page 35 in Week10 Team Assignment
    private void displayMap() {
        System.out.println("*** showMap function called ***");
    }

    private void viewInventory() {
        StringBuilder line;
        
        Game game = MormonTrail.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        System.out.println("\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                     ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        System.out.println(line.toString());
        
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                                      ");
            line.insert(0, item.getDescription());
            line.insert(23, item.getRequiredQuantity()); // just getQuantity? I cannot remember. (InventoryItem)?
            line.insert(33, item.getQuantity());
            
            System.out.println(line.toString());
        }
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
