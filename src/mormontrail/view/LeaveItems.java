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
public class LeaveItems extends View {

    
    public LeaveItems(){
        super("\n"
                  + "\n--------------------------------------" 
                  + "\n| What would you like to abandon?"
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
                this.leaveFood();
                break;
            case "C":
                this.leaveClothes();
                break;
            case "A":
                this.leaveAmmo();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break; 
    }
        return false;
        }

    private void leaveFood() {
        //remove System.in statement? (What about keyboard.nextInt(); ???
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;

        double currentFood;
        double newTotal = 0;
        double removeFood;

        while (!valid) {
           
            currentFood = 333 - newTotal;
                    
            this.console.print("\nYou currently have " + currentFood + " pounds of food." 
                                + "\nHow much would you like to remove?" 
                            + "\n");
            
            //this.keyboard.readLine??? implement try-catch once clarified? (also see note on Line 53)
            removeFood = keyboard.nextInt();            

            if (removeFood < 1) {
                this.console.println("\nInvalid value: cannot be less than 1");
                continue;
            }
            if (removeFood > currentFood) {
                this.console.println("\nInvalid value: cannot remove more food than in inventory");
                continue;
            }

            newTotal = (currentFood-removeFood);

            this.console.println("\nYou now have " + newTotal + " pounds of food"
            );
            break;   
        }
    }

    private void leaveClothes() {
        this.console.println("*** leaveClothes function called ***");
    }

    private void leaveAmmo() {
        this.console.println("*** leaveAmmo function called ***");
    }

   
}
