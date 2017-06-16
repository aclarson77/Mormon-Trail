/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class InGameMenu {
    private String ingamemenu;
    private String promptMessage;
    
    public InGameMenu(){
        this.ingamemenu = "\n"
                  + "\n--------------------------------------" 
                  + "\n| Mormon Oregon Trail"
                  + "\n--------------------------------------"
                  + "\nA - Advance Along Trail"
                  + "\nM - Show Map"
                  + "\nI - Show Inventory"
                  + "\nW - Display Wagon Status"
                  + "\nT - Talk to People"
                  + "\nC - Scavenge for Supplies"
                  + "\nP - Purchase Supplies"
                  + "\nL - Leave Items Behind"
                  + "\nS - Save Game"
                  + "\nB - Back to main menu"
                  + "\n--------------------------------------";
    }
    
    public void displayInGameMenu() {
       boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        } while (!done);
    }
      

    private String getMenuOption() {
    
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.ingamemenu);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;
            
        }
        
        return value;
        
        }

    private boolean doAction(String choice) {
    
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "A":
                this.advanceTrail();
                break;
            case "M":
                this.showMap();
                break;
            case "I":
                this.showInv();
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
            case "L":
                this.leaveItems();
                break;
            case "S":
                this.saveGame();
                break;
            case "B":
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

    private void showMap() {
        System.out.println("*** showMap function called ***");}

    private void showInv() {
        System.out.println("*** showInv function called ***");
    }

    private void wagonStatus() {
        System.out.println("Your wagon is under contruction. It will be ready for travel along the trail once the game is up and running.");
    }

    private void talkToPeople() {
        System.out.println("You meet a sleep deprived programmer. He doesn't say much. You back away slowly to avoid the awkward silence.");
    }

    private void scavengeSupplies() {
        System.out.println("*** scavengeSupplies function called ***");
    }
    
    private void purchaseSupplies() {
        
        System.out.println("\n You enter the store."
                          );

        Store store = new Store();
        store.displayStore();
        
        

     
    }

    private void leaveItems() {

        LeaveItems leaveItems = new LeaveItems();
        leaveItems.displayLeaveItems();
    }
    
    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    private void backToMainMenu() {
        System.out.println("*** backToMainMenu function called ***");
    }

    

    

   
}
