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
public class HelpMenuView extends View {
    
    //add how to move stub, 
    public HelpMenuView(){
        super("\n"
                + "\n--------------------------------------" 
                + "\n| Help Menu"
                + "\n--------------------------------------"
                + "\nA - About the Mormon Trail"
                + "\nG - Goal of the Game"
                + "\nQ - Quit to Previous Menu"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
        
        switch (value) {
            case "A":
                this.about();
                break;
            case "G":
                this.goal();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    //do text
    private void about() {
        System.out.println("Name of Game, Authors, History of Pioneer Trek");
    }

    //do text
    private void goal() {
        System.out.println("*** goal function called ***");
    }

    private void previous() {
        System.out.println("*** previous function called ***");
    }
}
