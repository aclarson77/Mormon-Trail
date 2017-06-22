/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Andrew
 */
public class Scene implements Serializable {
    
    private String scenario;
    private String description;
    private String mapSymbol;
    private ArrayList<Actor> actors;
    private ArrayList<InventoryItem> inventoryItems;

    public Scene() {
    }

    
    public String getScenario() {
        return scenario;
    }

    public String getDescription() {
        return description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMapSymbol(String symbol) {
        this.mapSymbol = symbol;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public ArrayList<InventoryItem> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.scenario);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.mapSymbol);
        return hash;
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
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.scenario, other.scenario)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegularSceneType{" + "scenario=" + scenario + ", description=" + description + ", symbol=" + mapSymbol + '}';
    }
    
    
    
    
    
}
