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
    private final String description;
    private int health;

    Actor(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Actor{" + "description=" + description + ", health=" + health + '}';
    }  
}