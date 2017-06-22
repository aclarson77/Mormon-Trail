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
    private int quantity; // # of units
    private int requiredQuantity; // remove required quantity?
    private int maxQuantity;
    private int minQuantity;
    private double weight;
    private double weightPerUnit;
    
    private Game game;

    public InventoryItem() {
        
    }
    
     public InventoryItem(InventoryType inventoryType, int quantity, double weightPerUnit) {
        
        this.minQuantity = 0;
        this.inventoryType = inventoryType;
        this.quantity = quantity;
        this.weight = quantity * weightPerUnit;
        this.weightPerUnit = weightPerUnit;
        
        if (inventoryType == InventoryType.food)
        {
            this.maxQuantity = 1000;
        }
        else if (inventoryType == InventoryType.clothes)
        {
            this.maxQuantity = 100;
        }
        else if (inventoryType == InventoryType.ammo)
        {
            this.maxQuantity = 100;
        }
        else {
            this.maxQuantity = 10;
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

    public int getQuantity() {        
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public int getMaxQuantity() {
        return this.maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public int getMinQuantity() {        
        return this.minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }
    
    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeightPerUnit() {
        return this.weightPerUnit;
    }

    public void setWeightPerUnit(double weightPerUnit) {
        this.weightPerUnit = weightPerUnit;
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
        hash = 97 * hash + this.quantity;
        hash = 97 * hash + this.requiredQuantity;
        hash = 97 * hash + this.maxQuantity;
        hash = 97 * hash + this.minQuantity;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.weightPerUnit) ^ (Double.doubleToLongBits(this.weightPerUnit) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", quantity=" + quantity + ", requiredQuantity=" + requiredQuantity + ", maxQuantity=" + maxQuantity + ", minQuantity=" + minQuantity + ", weight=" + weight + ", weightPerUnit=" + weightPerUnit + '}';
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
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.requiredQuantity != other.requiredQuantity) {
            return false;
        }
        if (this.maxQuantity != other.maxQuantity) {
            return false;
        }
        if (this.minQuantity != other.minQuantity) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weightPerUnit) != Double.doubleToLongBits(other.weightPerUnit)) {
            return false;
        }
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        return true;
    }              
}
