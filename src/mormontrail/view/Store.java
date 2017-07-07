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
        if (!toFile)
            sInventory += ("\nPlease enter the item you wish to purchase (Q to Leave the Store OR S to Save to File): ");
        displayMessage = sInventory;
        return;
    }

    @Override
    public boolean doAction(String value) {

        int selectedItem;

        value = value.toUpperCase();
        if (value == "S") {
           getInventory(true);
           //printing on line 83 - prompt for file name (example.txt), if prompt length > 0 , save displayMessage to a file -- no for-each needed (taken care of) AS WELL AS "S".
           
           getInventory(false);
        } else {

            try {
                selectedItem = Integer.parseInt(value);
            } catch (NumberFormatException nf) { //lookup
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
            //true or false??? Error - requires boolean value
            getInventory(true);
            return false;
        }
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
