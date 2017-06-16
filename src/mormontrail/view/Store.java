/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class Store extends View {
    
    public Store(){
        super("\n"
                  + "\n--------------------------------------" 
                  + "\n| Welcome to the Nauvoo Store!"
                  + "\n| Here you will buy everything you need to begin your journy."
                  + "\n| What would you like to buy?"
                  + "\n--------------------------------------"
                  + "\nF - Food"
                  + "\nC - Clothes"
                  + "\nA - Ammo"
                  + "\nQ - Quit/Exit Store"
                  + "\n--------------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
        
        switch (value) {
            case "F":
                this.buyFood();
                break;
            case "C":
                this.buyClothes();
                break;
            case "A":
                this.buyAmmo();
                break;  
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    private void buyFood() {
        System.out.println("*** buyFood function called ***");
    }

    private void buyClothes() {
        System.out.println("*** buyClothes function called ***");
    }

    private void buyAmmo() {
        System.out.println("*** buyAmmo function called ***");
    }

}
