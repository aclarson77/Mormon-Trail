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
public class Store {
    private String store;
    
    public Store(){
        this.store = "\n"
                  + "\n--------------------------------------" 
                  + "\n| Welcome to the Mormon Store!"
                  + "\n| What would you like to buy?"
                  + "\n--------------------------------------"
                  + "\nF - Food"
                  + "\nC - Clothes"
                  + "\nA - Ammo"
                  + "\nQ - Quit/Exit Store"
                  + "\n--------------------------------------";
    }
    
    public void displayStore() {
       boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(menuOption);
        } while (!done);
        

       

    }
      

    private String getMenuOption() {
    
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.store);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;
            
        }
        
        return value;
        
        }

    private boolean doAction(String choice) {
    
        choice = choice.toUpperCase();
        
        switch (choice) {
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
