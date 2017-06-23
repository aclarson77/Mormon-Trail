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
//Store should be right after RegisterNames
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
                  + "\nG - Enter Game"
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
            case "G":
                this.displayInGameMenu();
                break;
            case "Q":
                return true;
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
    
    private void displayInGameMenu() {
        
        System.out.println("\n What do you need help with?");

        InGameMenu inGameMenu = new InGameMenu();
        inGameMenu.display();
    }
    
}
