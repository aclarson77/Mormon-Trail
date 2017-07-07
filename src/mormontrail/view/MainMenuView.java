/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import mormontrail.control.GameControl;
import java.util.Scanner;
import mormontrail.MormonTrail;

/**
 *
 * @author Andrew
 */
public class MainMenuView extends View {
    
    public MainMenuView(){
        super("\n"
                  + "\n--------------------------------------" 
                  + "\n| Main Menu"
                  + "\n--------------------------------------"
                  + "\nN - Start New Game"
                  + "\nG - Get and Start Saved Game"
                  + "\nH - Get Help on How to Play the Game"
                  + "\nS - Save Game"
                  + "\nQ - Quit"
                  + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "N":
                this.startNewGame();
                break;
            case "G":
                this.startExistingGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            case "S":
                this.saveGame();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
    }

    private void startNewGame() {
        
        GameControl.createNewGame(MormonTrail.getPlayer());
        
        GameIntroView gameMenu = new GameIntroView();
        gameMenu.display();
    }

    private void startExistingGame() {
        
        InGameMenu ingameMenu = new InGameMenu();
        ingameMenu.display();
    }

    private void displayHelpMenu() {
        
        this.console.println("\n What do you need help with?");

        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void saveGame() {
        
        this.console.println("\n\nEnter the file path for file where the game"
                + "is to be saved");
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(MormonTrail.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }

        InGameMenu gameMenu = new InGameMenu();
        gameMenu.display();
        //System.out.println("*** startSaveGame function called ***");
    }
    
}

