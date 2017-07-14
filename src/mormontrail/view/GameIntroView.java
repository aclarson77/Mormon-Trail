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
                  + "\nC - Continue to Register with a Company"
                  + "\nQ - Quit to Previous Menu"
                  + "\n--------------------------------------");
    
        this.console.println(
        "\n**************************************************************"    
        +"\n* Welcome to the Pioneer Trek!                               *"
        +"\n*                                                            *"
        +"\n* Our travels will be a test of faith to all those willing   *"
        +"\n* to endure the hardship. We know that your situation has    *" 
        +"\n* been rough getting to this point, so we will allocate      *"
        +"\n* [25 Dollars] for you and your party to purchase items      *"
        +"\n* from the Nauvoo Store.                                     *"
        +"\n*                                                            *"
        +"\n* But first, please Register yourself as the Wagon Leader,   *"
        +"\n* along with any other members of your Company. Safe travels!*"
        +"\n**************************************************************");
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
                return true;
            case "Q":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
    }
        return false;
    }
    
    private void displayHelpMenu() {
        
        this.console.println("\n What do you need help with?");

        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void registerNames() {
        
        this.console.println("\n What do you need help with?");

        RegisterNames registerName = new RegisterNames();
        registerName.display();
    }
}
