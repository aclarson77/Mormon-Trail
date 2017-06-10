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
public class InventoryControl {
    
    static public double addToInventory(InventoryItem currentItem,
        InventoryItem newItem){
                        
        if (newItem.getInventoryType() != currentItem.getInventoryType())
        {
           return -1;
        }

        if (currentItem.getQuantity() < currentItem.getMinQuantity()
            || currentItem.getQuantity() > currentItem.getMaxQuantity())
        {
           return -2;
        }
        
        if (newItem.getQuantity() < newItem.getMinQuantity() 
            || newItem.getQuantity() > newItem.getMaxQuantity())
        {
           return -3;
        }
        
        if (newItem.getQuantity() + currentItem.getQuantity() 
            > currentItem.getMaxQuantity())
        {
            return -4;
        }
        
        double addItemsToInv = currentItem.getWeight() + newItem.getQuantity()
            * newItem.getWeightPerUnit();
        
        return addItemsToInv;
    }
    
            /*
        double addFoodToInv = currentFood + (newFood * 2); // 2 lbs
        double addAmmoToInv = currentAmmo + (newAmmo * 0.25); // 0.25 lbs
        double addClothesToInv = currentClothes + (newClothes * 5); // 5 lbs
        double addItemsToInv = addFoodToInv + addAmmoToInv + addClothesToInv;
        */
    
    static public double removeFromInventory(InventoryItem currentItem, InventoryItem removeItem){
    
        if (removeItem.getInventoryType() != currentItem.getInventoryType())
        {
           return -1;
        }

        if (currentItem.getQuantity() < currentItem.getMinQuantity() 
            || currentItem.getQuantity() > currentItem.getMaxQuantity())
        {
           return -2;
        }
        
        if (removeItem.getQuantity() < removeItem.getMinQuantity() || removeItem.getQuantity() > removeItem.getMaxQuantity())
        {
           return -3;
        }
        
        if (currentItem.getQuantity() - removeItem.getQuantity() < currentItem.getMinQuantity())
        {
            return -4;
        }
        
        double removeItemsFromInv = currentItem.getWeight() - removeItem.getQuantity() * removeItem.getWeightPerUnit();
        
        return removeItemsFromInv;
}
}