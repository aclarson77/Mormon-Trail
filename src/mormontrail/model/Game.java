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
 * @author andrew l.
 */
public class Game implements Serializable {
    
    // class instance variables
    private int bestScore;
    private String namePlayer;
    private String saveLog;
    private Player player;
    private Wagon wagon;
    //do we need this?
    private Actor actor;
    private Map map;
    
    private ArrayList<InventoryItem> inventory;

    public Game() {
    }
    
    
    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getSaveLog() {
        return saveLog;
    }

    public void setSaveLog(String saveLog) {
        this.saveLog = saveLog;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Wagon getWagon() {
        return wagon;
    }

    public void setWagon(Wagon wagon) {
        this.wagon = wagon;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public ArrayList<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.bestScore;
        hash = 37 * hash + Objects.hashCode(this.namePlayer);
        hash = 37 * hash + Objects.hashCode(this.saveLog);
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "bestScore=" + bestScore + ", namePlayer=" + namePlayer + ", saveLog=" + saveLog + '}';
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
        final Game other = (Game) obj;
        if (this.bestScore != other.bestScore) {
            return false;
        }
        if (!Objects.equals(this.namePlayer, other.namePlayer)) {
            return false;
        }
        if (!Objects.equals(this.saveLog, other.saveLog)) {
            return false;
        }
        return true;
    }
    
    
   
}
