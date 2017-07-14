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

    //We do NOT need a Q, as Q is already within View Superclass
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
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
        }

    //do text
    private void about() {
        this.console.println("\nAuthors: Joshua Nilsson, A.J. Hess"
                + "\nGame Info: The Mormon Trail game allows the user to experience the hardship"
                + "\nof the Mormon Pioneers and relive the Exodus to the Salt Lake Valley.");
    }

    //do text
    private void goal() {
        this.console.println("\nReach the Salt Lake Valley and you win!"
                + "\nTIP: Make sure to keep track of your Wagon's Weight and Inventory!");
    }
}
