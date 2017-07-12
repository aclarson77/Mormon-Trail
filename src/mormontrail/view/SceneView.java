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
        super("There is no event at this scene. Press Q to quit.");
        
        currentScene = mormontrail.MormonTrail.getCurrentGame().getMap().getCurrentScene();
        if(currentScene.getEvent() == null)
            return;
        
        displayMessage = currentScene.getDescription();
        displayMessage += "\n" + currentScene.getEvent().getDescription();
        if (currentScene.getEvent().getAmmoAmountChange() < 0
                || currentScene.getEvent().getClothesAmountChange() < 0
                || currentScene.getEvent().getFoodWeightChange() < 0) {
            lossOfInventory = true;

            if (currentScene.getEvent().isDefensable()) {
                if (hasBullets()) {
                    defendSelf = true;
                    displayMessage += "\nDo you want to defend yourself? (Y/N)";
                }
            }
        }
        if (!defendSelf) {
            displayMessage += "\nEnter C to continue";
        }
    }

    private boolean hasBullets() {

        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.getCurrentGame().getWagon().getInventoryItems();
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
                if(!lossOfInventory)
                    return true;
                else
                    this.console.println("Invalid selection, please try again.");
                break;
            case "Y":
                if(defendSelf){
                //Remove x amount of ammo from wagon.  
                removeBulletFromWagon();
                this.console.println("You have one less bullet, but you saved your possesions");
                    return true;
                }
                    
            case "N":
                this.console.println("");
                //Remove loss of inventory from wagon.
                removeFromWagon();
                return true;
            default:
                this.console.println("Invalid selection, please try again.");
                break;
        }

        return false;

    }
    String removeFromWagon(){
        String msg = "";
        //Find this item type in the wagon and remove amount from it.
        //Set msg to indicate what happened.
        return msg;
    }
    
    void removeBulletFromWagon(){
        //Find inventory item on the wagon that is type "ammo" and remove 1 lb/unit
        ArrayList<InventoryItem> inventoryItems = mormontrail.MormonTrail.getCurrentGame().getWagon().getInventoryItems();
        for (InventoryItem item : inventoryItems) {
            if ((item.getInventoryType() == InventoryType.ammo)
                    && item.getWeight() > 0) {
                item.setWeight(item.getWeight()-1);
                return;
            }
        }
        return;
    }
}
