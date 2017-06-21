/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author andrew l.
 */
public enum Actor implements Serializable {

    WagonLeader("He is the prophet and leader of the family"),
    MemberTwo("Member2"),
    MemberThree("Member2"),
    MemberFour("Member2"),
    MemberFive("Member2");
    

// class instance variables
    private final String description;
    private final Point coordinates;
    private int health;
    
    private Game game;

    Actor(String description) {
        this.description = description;
        coordinates = new Point(1,1);
    }
    
    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + ", coordinates=" + coordinates + ", health=" + health + '}';
    }       
}