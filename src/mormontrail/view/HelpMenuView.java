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
public class HelpMenuView {
    
    private String helpmenu;
    private String promptMessage;
    
    public HelpMenuView(){
        this.helpmenu = "\n"
                  + "\n--------------------------------------" 
                  + "\n| Help Menu"
                  + "\n--------------------------------------"
                  + "\nA - About MormonTrail"
                  + "\nG - Goal of the game"
                  + "\nB - Back to main menu"
                  + "\n--------------------------------------";
    }
    
    public void displayHelpMenuView() {
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
            System.out.println("\n" + this.helpmenu);
            
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
            case "A":
                this.about();
                break;
            case "G":
                this.goal();
                break;
            case "B":
                return true;

            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    private void about() {
        System.out.println("*** about function called ***");
    }

    private void goal() {
        System.out.println("*** goal function called ***");
    }
}
