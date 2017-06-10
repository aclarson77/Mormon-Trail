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
public class LeaveItems {
    private String leaveitems;
    private String promptMessage;
    
    public LeaveItems(){
        this.leaveitems = "\n"
                  + "\n--------------------------------------" 
                  + "\n| What would you like to abandon?"
                  + "\n--------------------------------------"
                  + "\nF - Food"
                  + "\nC - Clothes"
                  + "\nA - Ammo"
                  + "\nQ - Quit/Exit Store"
                  + "\n--------------------------------------";
    }
    
    public void displayLeaveItems() {
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
            System.out.println("\n" + this.leaveitems);
            
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
                this.leaveFood();
                break;
            case "C":
                this.leaveClothes();
                break;
            case "A":
                this.leaveAmmo();
                break;
            
                
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    private void leaveFood() {
        
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;

        double currentFood;
        double newTotal = 0;
        double removeFood;

        while (!valid) {
           
            currentFood = 333 - newTotal;
                    
            System.out.print("\nYou currently have " + currentFood + " pounds of food." 
                                + "\nHow much would you like to remove?" 
                            + "\n");
            
            removeFood=keyboard.nextInt();            

            if (removeFood < 1) {
                System.out.println("\nInvalid value: cannot be less than 1");
                continue;
            }
            if (removeFood > currentFood) {
                System.out.println("\nInvalid value: cannot remove more food than in inventory");
                continue;
            }
            
            
            newTotal = (currentFood-removeFood);

            
            
            System.out.println("\nYou now have " + newTotal + " pounds of food"
            );
            

            
            break;
            
            
        }
    
    }

    private void leaveClothes() {
        System.out.println("*** leaveClothes function called ***");
    }

    private void leaveAmmo() {
        System.out.println("*** leaveAmmo function called ***");
    }

   
}
