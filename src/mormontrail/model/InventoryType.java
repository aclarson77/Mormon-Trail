/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

/**
 *
 * @author Joshua
 */
public enum InventoryType {
    
    cornmeal("Cornmeal"),
    bacon("Bacon"),
    food("Food"),
    ammo("Ammo"),
    clothes("Set of Clothes");
    
    private String description;
    
    private InventoryType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
