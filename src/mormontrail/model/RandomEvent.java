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
 * @author Andrew
 */
public class RandomEvent implements Serializable {
    
    private String description;
    private double foodWeightChange;
    private double ammoAmountChange;
    private double clothesAmountChange;
    private boolean defensable;

    public RandomEvent() {
        foodWeightChange = 0;
        ammoAmountChange = 0;
        clothesAmountChange = 0;
        defensable = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFoodWeightChange() {
        return foodWeightChange;
    }

    public void setFoodWeightChange(double foodWeightChange) {
        this.foodWeightChange = foodWeightChange;
    }

    public double getAmmoAmountChange() {
        return ammoAmountChange;
    }

    public void setAmmoAmountChange(double ammoAmountChange) {
        this.ammoAmountChange = ammoAmountChange;
    }

    public double getClothesAmountChange() {
        return clothesAmountChange;
    }

    public void setClothesAmountChange(double clothesAmountChange) {
        this.clothesAmountChange = clothesAmountChange;
    }

    public boolean isDefensable() {
        return defensable;
    }

    public void setDefensable(boolean defensable) {
        this.defensable = defensable;
    }

}