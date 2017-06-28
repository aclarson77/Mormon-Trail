/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import mormontrail.model.InventoryItem;

/**
 *
 * @author andre
 */

//todo
public class InventoryControl {
    
    static public double addToInventory(InventoryItem currentItem,
        InventoryItem newItem){
                        
        if (newItem.getInventoryType() != currentItem.getInventoryType())
        {
           return -1;
        }

        if (currentItem.getWeight() < currentItem.getMinWeight() || 
            currentItem.getWeight() > currentItem.getMaxWeight())
        {
           return -2;
        }
        
        if (newItem.getWeight() < newItem.getMinWeight() || 
            newItem.getWeight() > newItem.getMaxWeight())
        {
           return -3;
        }
        
        if (currentItem.getWeight() + 
            newItem.getWeight() > currentItem.getMaxWeight())
        {
            return -4;
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
    static public double removeFromInventory(InventoryItem currentItem, InventoryItem removeItem){
    
        if (removeItem.getInventoryType() != currentItem.getInventoryType())
        {
           return -1;
        }

        if (currentItem.getWeight() < currentItem.getMinWeight() || 
            currentItem.getWeight() > currentItem.getMaxWeight())
        {
           return -2;
        }
        
        if (removeItem.getWeight() < removeItem.getMinWeight() || 
            removeItem.getWeight() > removeItem.getMaxWeight())
        {
           return -3;
        }
        
        if (currentItem.getWeight() + 
            removeItem.getWeight() < currentItem.getMinWeight())
        {
            return -4;
        }
        
        double removeItemsFromInv = currentItem.getWeight() - removeItem.getWeight();
        
        return removeItemsFromInv;
    }
}