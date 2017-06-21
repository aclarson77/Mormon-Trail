/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.model;

import java.io.Serializable;

/**
 *
 * @author Joshua
 */
public class Wagon implements Serializable {
    
    private double maxWeight;
    
    public Wagon() {
        
        //what else should we include?
        this.maxWeight = 2525;
    }
    
}
