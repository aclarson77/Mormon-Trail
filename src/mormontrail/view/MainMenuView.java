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
public class MainMenuView extends View {
    
    public MainMenuView(){
        super("\n"
                  + "\n--------------------------------------" 
                  + "\n| Main Menu"
                  + "\n--------------------------------------"
                  + "\nN - Start new game"
                  + "\nG - Get and start saved game"
                  + "\nH - Get help on how to play the game"
                  + "\nS - Save game"
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
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        
    }
        return false;
        
    }

    private void startNewGame() {
        //GameIntroView.createNewGame(MormonTrail.getPlayer());
        
        GameIntroView gameMenu = new GameIntroView();
        gameMenu.displayGameIntroView();
    }

    private void startExistingGame() {
        InGameMenu ingameMenu = new InGameMenu();
        ingameMenu.displayInGameMenu();
        
        //System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        
       
        System.out.println("\n What do you need help with?");

        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
        
      // System.out.println("*** displayHelpMenu function called ***");
    }

    private void saveGame() {
        System.out.println("*** startSaveGame function called ***");
    }
    
}

