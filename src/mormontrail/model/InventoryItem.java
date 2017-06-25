/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author andrew l.
 */
public class InventoryItem implements Serializable {
    
    // class instance variables
    private InventoryType inventoryType; // but what kind of food?
    private String name;
    private double pricePerPound;
    private int maxWeight;
    private int minWeight;
    private double weight;
    private Game game;

    public InventoryItem() {
        
    }
    
     public InventoryItem(InventoryType inventoryType, int quantity, double weightPerUnit) {
        
        this.minWeight = 0;
        this.inventoryType = inventoryType;
        this.weight = quantity * weightPerUnit;
        
        if (inventoryType == InventoryType.food)
        {
            this.maxWeight = 1000;
        }
        else if (inventoryType == InventoryType.clothes)
        {
            this.maxWeight = 100;
        }
        else if (inventoryType == InventoryType.ammo)
        {
            this.maxWeight = 100;
        }
        else {
            this.maxWeight = 10;
        }
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }
    
    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.inventoryType);
        hash = 97 * hash + this.maxWeight;
        hash = 97 * hash + this.minWeight;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", maxQuantity=" + maxWeight + ", minQuantity=" + minWeight + ", weight=" + weight + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (this.minWeight != other.minWeight) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        return true;
    }              
}
