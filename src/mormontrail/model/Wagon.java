/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Joshua
 */
public class Wagon implements Serializable {
    
    private double minWeight;
    private double maxWeight;
    ArrayList<InventoryItem> inventoryItems;
    private double wagonWeight;
    
    public Wagon() {
        
        //what else should we include?
        this.minWeight = 0;
        this.maxWeight = 2525;
        this.wagonWeight = 1000;
        //properties to take from store to wagon - ArrayList<InventoryItem>
        inventoryItems = new ArrayList<InventoryItem>();
        //player health value with 100%
        //calculate current weight of wagon - walk through inventory items with wagon weight to get total
        
        //getWagonWeight after RandomEvent - if too big or too little, you lose the game
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public ArrayList<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    public double getCurrentWeight() {
        //fixed wagon weight
        double currentWeight = this.wagonWeight;
        for (InventoryItem item : inventoryItems) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }

    public double getWagonWeight() {
        return wagonWeight;
    }  
}
