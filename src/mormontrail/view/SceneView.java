/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.ArrayList;
import mormontrail.model.InventoryItem;
import mormontrail.model.InventoryType;
import mormontrail.model.Scene;

/**
 *
 * @author Andrew
 */
public class SceneView extends View {

    Scene currentScene;
    boolean defendSelf = false;
    boolean lossOfInventory = false;

    public SceneView() {
        super("There is no event at this scene (Press Q to return to the In-Game Menu).");

        currentScene = mormontrail.MormonTrail.getCurrentGame().getMap().getCurrentScene();
        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.
                getCurrentGame().getWagon().getInventoryItems();
        
        if (currentScene.getEvent() == null) {
            return;
        }

        displayMessage = currentScene.getDescription();
        displayMessage += "\n" + currentScene.getEvent().getDescription();
        if (currentScene.getEvent().getAmmoAmountChange() < 0
                || currentScene.getEvent().getClothesAmountChange() < 0
                || currentScene.getEvent().getFoodWeightChange() < 0) {
            lossOfInventory = true;

            if (currentScene.getEvent().isDefensable()) {
                if (hasBullets()) {
                    defendSelf = true;
                    displayMessage += "\nDo you want to defend yourself? (Y/N)"
                            + " - If 'Y', you must have Ammo within your Inventory";
                }
            }
        }
        if (!defendSelf) {
            displayMessage += "\nPress Q to Continue";
            return;
        }
    }

    private boolean hasBullets() {

        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.
                getCurrentGame().getWagon().getInventoryItems();
        for (InventoryItem item : inventoryItems) {
            if ((item.getInventoryType() == InventoryType.ammo)
                    && item.getWeight() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        switch (value) {
            case "C":
                if (!lossOfInventory) {
                    return true;
                } else {
                    this.console.println("Invalid selection, please try again.");
                }
                break;
            case "Y":
                if (defendSelf) {
                    //Remove x amount of ammo from wagon.  
                    removeBulletFromWagon();
                    this.console.println("\n*** You have one less bullet, but you "
                            + "saved your possesions ***"
                            + "\n");
                    return true;
                }

            case "N":
                this.console.println("");
                //Remove loss of inventory from wagon. Use for-each loop
                removeFromWagon();
                this.console.println("*** You've lost resources! Check your Wagon's "
                        + "Inventory to see what's been removed. ***"
                        + "\n");
                return true;
            default:
                this.console.println("Invalid selection, please try again.");
                break;
        }

        return false;

    }

    String removeFromWagon() {
        //Find this item type in the wagon and remove amount from it.
        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.
                getCurrentGame().getWagon().getInventoryItems();
        String msg = "";

        for (InventoryItem item : inventoryItems) {
            if ((item.getInventoryType() == InventoryType.food)
                    && (item.getWeight() > 0 && item.getWeight() > 5)) {
                item.setWeight(item.getWeight() - 5);
            } else if ((item.getInventoryType() == InventoryType.ammo)
                    && (item.getWeight() > 0 && item.getWeight() > 3)) {
                item.setWeight(item.getWeight() - 3);
            } else if ((item.getInventoryType() == InventoryType.clothes)
                    && (item.getWeight() > 0 && item.getWeight() > 1)) {
                item.setWeight(item.getWeight() - 1);
            }
        }
        //Set msg to indicate what happened.
        return msg += "You've lost resources! " + "These items have been removed from the Wagon.";
    }

    void removeBulletFromWagon() {
        //Find inventory item on the wagon that is type "ammo" and remove 1 lb/unit
        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.getCurrentGame().getWagon().getInventoryItems();
        for (InventoryItem item : inventoryItems) {
            if ((item.getInventoryType() == InventoryType.ammo)
                    && item.getWeight() > 0) {
                item.setWeight(item.getWeight() - 1);
                return;
            }
        }
        return;
    }
}
