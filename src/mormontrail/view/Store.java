/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import mormontrail.MormonTrail;
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
    
    public Store(){
        super("This store has no inventory! (Press Q to Quit)");
    }
    public void getInventory() {
        
        if(storeInventory == null) {
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
        sInventory += "\n| Welcome to the " + storeName + "!";
        sInventory += ("\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                     ");
        line.insert(0, "ITEM");
        line.insert(5, "DESCRIPTION");
        line.insert(20, "PRICE PER POUND");
        line.insert(40, "IN STOCK (POUNDS)");

        sInventory += ("\n" + line.toString());
        
        for (InventoryItem item : storeInventory) {
            line = new StringBuilder("                                      ");
            line.insert(0, counter);
            line.insert(5, item.getName());
            line.insert(20, item.getPricePerPound());
            line.insert(40, item.getWeight());
            totalWeight += item.getWeight();
            sInventory += ("\n" + line.toString());
            counter++;
        }
        sInventory += ("\nThe total weight of your inventory is " + totalWeight + " lbs.");
        sInventory += ("\nPlease enter the item you wish to purchase (Q to Leave the Store): ");
        displayMessage = sInventory;
        return;
    }
    
    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
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
        System.out.println("Process of purchase is not available yet");
        getInventory();
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
        System.out.println("*** buyFood function called ***");
    }

    private void buyClothes() {
        System.out.println("*** buyClothes function called ***");
    }

    private void buyAmmo() {
        System.out.println("*** buyAmmo function called ***");
    }
    
    private void displayInGameMenu() {
        
        System.out.println("\n What do you need help with?");

        InGameMenu inGameMenu = new InGameMenu();
        inGameMenu.display();
    }
    
}
