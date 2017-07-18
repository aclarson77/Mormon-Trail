/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import mormontrail.control.GameControl;
import java.util.Scanner;
import mormontrail.model.Player;

/**
 *
 * @author Andrew
 */
public class StartProgramView extends View {

    
    
    public void displayStartProgramView() {
        
        boolean done = false;
        
        do {
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(playersName);
        } while (!done);
        
        /*
        do
             Prompt for and get the input value
             if (value == “Q”) then
                return

             do requested action and display the next view
             
        while the view is not done
                     
        */
        
        
    }
    
    //private String promptMessage;
    
    public StartProgramView() {
        super("Please enter your name: ");
        //this.promptMessage = "\nPlease enter your name: ";
        //display the banner when view is created
        this.displayBanner();
        
    }

    private void displayBanner() {
        this.console.println(
        "\n**************************************************************"
        +"\n*                                                           *"       
        +"\n* This is the game of the Mormon Oregon Trial.              *"
        +"\n* In this game you will help Mormon Pioneers travel to the  *"
        +"\n* great Salt Lake Valley.                                   *"
        +"\n*                                                           *"
        +"\n* You and your party will begin by gathering the necessary  *"
        +"\n* supplies to make your trek. You must prepare well so you  *"
        +"\n* and you party will safely arrive in the Salt Lake Valley  *"
        +"\n* before winter arrives.                                    *"
        +"\n*                                                           *"        
        +"\n* Good luck and have fun on your journey.                   *"
        +"\n*                                                           *"        
        +"\n*************************************************************"
        );
    }

    private String getPlayersName() {
        
        String value = "";
        boolean valid = false;
        
        try {
        while (!valid) {
            this.console.println("\n" + displayMessage);
            
            value = this.keyboard.readLine();
            value = value.trim();
            
            if (value.length() < 1) {
                ErrorView.display(this.getClass().getName(), "\nInvalid value: value cannot be blank");
                continue;
            }
            
            break;
        }
        
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }
        
        return value;
        
        /*
            WHILE valid value has not be entered
                DISPLAY promptMessage
                GET the value entered from the keyboard
                Trim front and trailing blanks off of the name
        
            IF the length of the alue is blank THEN
                DISPLAY "Invalid value: The value can not be blank"
                CONTINUE
            ENDIF
        
            BREAK
        
        ENDWHILE
        RETURN name
        
        */
    }

    @Override
    public boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            this.console.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) {
            this.console.println("\nError creating the player.");
            return false;
        }
    
        this.displayNextView(player); 
        
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\n================================="
                          + "\n Welcome to the Trail, " + player.getName() + "."
                          + "\n We hope you have a LOT of fun!"
                          + "\n================================="
                          );
        MainMenuView mainMenuView = new MainMenuView();
                
        mainMenuView.display();        
    }
}

