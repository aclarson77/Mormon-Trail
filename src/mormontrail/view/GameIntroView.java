/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.Scanner;

/**
 * @author Joshua
 */
public class GameIntroView {
    
    private String gameMenu;
    
    public GameIntroView(){
        
        System.out.println(
        "\n**************************************************************"
        +"\n*                                                           *"       
        +"\n* Introduce the end user to the Pioneer Trek and the        *"
        +"\n* situation leading up the exodus, as well as the option to *"
        +"\n* Register - naming your actor - to join a Company.         *"
        +"\n*                                                           *"
        +"\n*************************************************************"
        );
        
        this.gameMenu = "\n"
                  + "\n--------------------------------------" 
                  + "\n| Introduction Menu"
                  + "\n--------------------------------------"
                  + "\nH - Get help on how to play the game"
                  + "\nC - Continue to Actor Menu/Register with a Company"
                  + "\nB - Back to main menu"
                  + "\n--------------------------------------";
    }
    
    public void displayGameIntroView() {
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
            System.out.println("\n" + this.gameMenu);
            
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
            case "H":
                this.displayHelpMenu();
                break;
            case "C":
                this.registerNames();
                break;
            case "B":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
    }
        return false;
    }
    
    private void displayHelpMenu() {
        
        System.out.println("\n What do you need help with?");

        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }

    private void registerNames() {
        
        System.out.println("\n What do you need help with?");

        RegisterNames registerName = new RegisterNames();
        registerName.displayRegisterNames();
    }
}
