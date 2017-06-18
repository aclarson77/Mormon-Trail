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
public class GameIntroView extends View {
    
    public GameIntroView(){
        super("\n"
                  + "\n--------------------------------------" 
                  + "\n| Introduction Menu"
                  + "\n--------------------------------------"
                  + "\nH - Get Help on How to Play the Game"
                  + "\nC - Continue to Actor Menu/Register with a Company"
                  + "\nB - Back to Previous Menu"
                  + "\nQ - Quit to Main Menu"
                  + "\n--------------------------------------");
    
        System.out.println(
        "\n*************************************************************"
        +"\n*                                                           *"       
        +"\n* Introduce the end user to the Pioneer Trek and the        *"
        +"\n* situation leading up the exodus, as well as the option to *"
        +"\n* Register - naming your actor - to join a Company.         *"
        +"\n*                                                           *"
        +"\n*************************************************************"
        );
    }

    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
        
        switch (value) {
            case "H":
                this.displayHelpMenu();
                break;
            case "C":
                this.registerNames();
                break;
            case "B":
                this.previous();
            case "Q":
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
        helpMenuView.display();
    }

    private void registerNames() {
        
        System.out.println("\n What do you need help with?");

        RegisterNames registerName = new RegisterNames();
        registerName.display();
    }

    private void previous() {
        System.out.println("*** previous function called ***");
    }
}
