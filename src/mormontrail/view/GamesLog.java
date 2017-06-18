/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

/**
 *
 * @author Joshua
 */

/* GamesLog will be part of the MainMenuView. We need to hook our individual assignments up.
* (See RegisterNames if 'Y', Store, and InGameMenu comments)
*/
public class GamesLog extends View {
    
    public GamesLog(){
        super("\n"
                + "\n--------------------------------------" 
                + "\n| Recent Games Log Menu"
                + "\n--------------------------------------"
                + "\nT - Top Score/Time to Beat" //Subject to change.
                + "\nR - Recent Games"
                + "\nB - Back to Previous Menu"
                + "\nQ - Quit to Main Menu"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String value) {
    
        value = value.toUpperCase();
        
        switch (value) {
            case "T":
                this.topScore();
                break;
            case "R":
                this.recentGame();
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

    private void topScore() {
        System.out.println("*** topScore function called ***");
    }
    
    private void recentGame() {
        System.out.println("*** recentGame function called ***");
    }

    private void previous() {
        System.out.println("*** previous function called ***");
    }
}
