/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import java.util.ArrayList;
import mormontrail.MormonTrail;
import mormontrail.exceptions.InventoryControlException;
import mormontrail.model.InventoryItem;

/**
 *
 * @author andre
 */
//todo
public class InventoryControl {

    static public double addToInventory(InventoryItem currentItem,
            InventoryItem newItem) throws InventoryControlException {

        if (newItem.getInventoryType() != currentItem.getInventoryType()) {
            throw new InventoryControlException("Cannot add different items together.");

            //return -1;
        }

        if (currentItem.getWeight() < currentItem.getMinWeight()
                || currentItem.getWeight() > currentItem.getMaxWeight()) {
            throw new InventoryControlException("Current weight cannot be below 0 or above the max weight.");

            //return -2;
        }

        if (newItem.getWeight() < newItem.getMinWeight()
                || newItem.getWeight() > newItem.getMaxWeight()) {
            throw new InventoryControlException("New weight cannot be below 0 or above the max weight.");

            //return -3;
        }

        if (currentItem.getWeight()
                + newItem.getWeight() > currentItem.getMaxWeight()) {
            throw new InventoryControlException("Current weight plus new weight cannot exceed max weight.");

            //return -4;
        }

        double addItemsToInv = currentItem.getWeight() + newItem.getWeight();

        return addItemsToInv;
    }

    /*
        double addFoodToInv = currentFood + (newFood * 2); // 2 lbs
        double addAmmoToInv = currentAmmo + (newAmmo * 0.25); // 0.25 lbs
        double addClothesToInv = currentClothes + (newClothes * 5); // 5 lbs
        double addItemsToInv = addFoodToInv + addAmmoToInv + addClothesToInv;
     */
    //todo
    static public double removeFromInventory(InventoryItem currentItem, InventoryItem removeItem) throws InventoryControlException {

        if (removeItem.getInventoryType() != currentItem.getInventoryType()) {
            throw new InventoryControlException("Cannot remove different items from each other.");

            //return -1;
        }

        if (currentItem.getWeight() < currentItem.getMinWeight()
                || currentItem.getWeight() > currentItem.getMaxWeight()) {
            throw new InventoryControlException("Current weight cannot be below 0 or above the max weight.");

            //return -2;
        }

        if (removeItem.getWeight() < removeItem.getMinWeight()
                || removeItem.getWeight() > removeItem.getMaxWeight()) {
            throw new InventoryControlException("New weight cannot be below 0 or above the max weight.");

            //return -3;
        }

        if (currentItem.getWeight()
                + removeItem.getWeight() < currentItem.getMinWeight()) {
            throw new InventoryControlException("Current weight minus new weight cannot be below the min weight.");

            //return -4;
        }

        double removeItemsFromInv = currentItem.getWeight() - removeItem.getWeight();

        return removeItemsFromInv;
    }

    public static void addToWagon(InventoryItem item, int quantity) {
        ArrayList<InventoryItem> wagonItemList = MormonTrail.getCurrentGame().getWagon().getInventoryItems();
        // Check to see if the item is already in the backpack
        InventoryItem wagonItem = null;
        for (InventoryItem currentItem : wagonItemList) {
            if (currentItem.getName() == item.getName()) {
                wagonItem = currentItem;
                break;
            }
        }
        if (wagonItem == null) {
            wagonItem = new InventoryItem();
            wagonItem.setName(item.getName());
            wagonItem.setInventoryType(item.getInventoryType());
            wagonItem.setWeight(quantity);
            wagonItemList.add(wagonItem);
            item.setWeight(item.getWeight() - quantity);
        } else {
            wagonItem.setWeight(wagonItem.getWeight() + quantity);
            item.setWeight(item.getWeight() - quantity);
        }
    }
}
