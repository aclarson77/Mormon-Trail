/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

/**
 *
 * @author andre
 */
public class InventoryControl {
    
    public double addToInventory(double currentFood, double newFood, 
            double currentAmmo, double newAmmo, double currentClothes, 
            double newClothes){
        
        if (currentFood < 0 || currentFood > 1000){
            return -1;
        }
        
        if (newFood < 1 || newFood > 1000){
            return -1;
        }
        
        if (currentAmmo < 0 || currentAmmo > 100){
            return -1;
        }
        
        if (newAmmo < 1 || newAmmo > 100){
            return -1;
        }
            
        if (currentClothes < 0 || currentClothes > 100){
            return -1;
        }
        
        if (newClothes < 1 || newClothes > 100){
            return -1;
        }
        
        double addFoodToInv = currentFood + (newFood * 2); // 2 lbs
        double addAmmoToInv = currentAmmo + (newAmmo * 0.25); // 0.25 lbs
        double addClothesToInv = currentClothes + (newClothes * 5); // 5 lbs
        double addItemsToInv = addFoodToInv + addAmmoToInv + addClothesToInv;
        
        return addItemsToInv;
    }
}