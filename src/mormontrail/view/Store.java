/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mormontrail.MormonTrail;
import mormontrail.control.InventoryControl;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;

/**
 *
 * @author Andrew
 */
//Store should be right after RegisterNames
public class Store extends View {

    private ArrayList<InventoryItem> storeInventory;
    private String storeName;

    public Store() {
        super("This store has no inventory! (Press Q to Quit)");
    }

    public void getInventory(boolean toFile) {

        if (storeInventory == null) {
            return;
        }
//        super("\n"
//                  + "\n--------------------------------------" 
//                  + "\n| Welcome to the Nauvoo Store!"
//                  + "\n| Here you will buy everything you need to begin your journy."
//                  + "\n| What would you like to buy?"
//                  + "\n--------------------------------------"

        String sInventory = "";
        int counter = 0;

        StringBuilder line;
        int totalWeight = 0;
//        Game game = MormonTrail.getCurrentGame();
//        ArrayList<InventoryItem> inventory = game.getInventory();
        sInventory += "\r\n| Welcome to the " + storeName + "!";
        sInventory += ("\r\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                     ");
        line.insert(0, "ITEM");
        line.insert(5, "DESCRIPTION");
        line.insert(20, "PRICE PER POUND");
        line.insert(40, "IN STOCK (POUNDS)");

        sInventory += ("\r\n" + line.toString());

        for (InventoryItem item : storeInventory) {
            line = new StringBuilder("                                      ");
            line.insert(0, counter);
            line.insert(5, item.getName());
            line.insert(20, item.getPricePerPound());
            line.insert(40, item.getWeight());
            totalWeight += item.getWeight();
            sInventory += ("\r\n" + line.toString());
            counter++;
        }
        sInventory += ("\r\nThe total weight of the Store's Inventory is " + totalWeight + " lbs.");
        if (!toFile) {
            sInventory += ("\r\nPlease enter the item you wish to purchase (Q to Leave the Store OR S to Save to File): ");
            sInventory += ("\r\nCurrent funds available: " + MormonTrail.getCurrentGame().getPlayer().getCash());
        }
        displayMessage = sInventory;
        return;
    }

    @Override
    public boolean doAction(String value) {

        int selectedItem;
        String filePrompt = "";

        value = value.toUpperCase();
        if ("S".equals(value)) {
            
            getInventory(true);
            
            this.console.println("Please enter a File Name to Save (example.txt): ");
            try {
                filePrompt = keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            
            filePrompt = filePrompt.trim();
            if (filePrompt.length() == 0) {
                this.console.println("You must enter a valid File Name.");
                return false;
            }
            
            try(PrintWriter fileSave = new PrintWriter(filePrompt)) {

                fileSave.print(displayMessage);
                this.console.println("You have successfully saved " + filePrompt);
                getInventory(false);
                return true;
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error reading input.");
            }
        } 
        
        else {

            try {
                selectedItem = Integer.parseInt(value);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), 
                "You must enter a valid number, please try again.");
                return false;
            }
            if (selectedItem >= storeInventory.size()) {
                this.console.println("Item not found");
                return false;
            }

            // add logic: price, weight,
            InventoryItem selectedInventoryItem = storeInventory.get(selectedItem);
            this.console.println("How many pounds would you like to buy?: ");
            int pounds = 0;
            String sPounds = "";
            try {
                sPounds = keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
                ErrorView.display(this.getClass().getName(), "You must enter a valid number, please try again");
                return false;
            }
            try {
                pounds = Integer.parseInt(sPounds);
            }
            catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), 
                "You must enter a valid number, please try again.");
                return false;
            }
            
            if (pounds == 0) {
                ErrorView.display(this.getClass().getName(), 
                "There's nothing to buy here!");
                return false;
            }
            
            double currentCash = MormonTrail.getCurrentGame().getPlayer().getCash();
            
            if (selectedInventoryItem.getPricePerPound() * pounds > currentCash) {
                ErrorView.display(this.getClass().getName(), 
                "You don't have enough money!");
                return false;
            }
            
            InventoryControl.addToWagon(selectedInventoryItem, pounds);
            currentCash -= selectedInventoryItem.getPricePerPound() * pounds;
            MormonTrail.getCurrentGame().getPlayer().setCash(currentCash);
            //
            //numeric exception handling
            //todo: parse value to integer, process integer to purchase food.
//        switch (value) {
//            case "F":
//                this.buyFood();
//                break;
//            case "C":
//                this.buyClothes();
//                break;
//            case "A":
//                this.buyAmmo();
//                break;  
//            case "G":
//                this.displayInGameMenu();
//                break;
//            default:
//                System.out.println("\n*** Invalid selection *** Try again");
//                break;
//        
//    }
            this.console.println("Process of purchase is not available yet");
        }
        getInventory(false);
        return false;
    }

    public ArrayList<InventoryItem> getStoreInventory() {
        return storeInventory;
    }

    public void setStoreInventory(ArrayList<InventoryItem> storeInventory) {
        this.storeInventory = storeInventory;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    private void buyFood() {
        this.console.println("*** buyFood function called ***");
    }

    private void buyClothes() {
        this.console.println("*** buyClothes function called ***");
    }

    private void buyAmmo() {
        this.console.println("*** buyAmmo function called ***");
    }

    private void displayInGameMenu() {

        this.console.println("\n What do you need help with?");

        InGameMenu inGameMenu = new InGameMenu();
        inGameMenu.display();
    }

}
