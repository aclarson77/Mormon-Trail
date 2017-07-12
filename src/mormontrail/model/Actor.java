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
public class Actor implements Serializable {

//    WagonLeader("He is the prophet and leader of the family"),
//    MemberTwo("Member2"),
//    MemberThree("Member2"),
//    MemberFour("Member2"),
//    MemberFive("Member2");
    

// class instance variables
    private String description;
    private String name;
    private int health;
    private int weight;

    
    public Actor(String description) {
        this.description = description;
    }
    public Actor() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public String toString() {
        return "Actor{" + "description=" + description + ", health=" + health + '}';
    }  
}