/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import mormontrail.model.Actor;
import mormontrail.model.Game;
import mormontrail.model.InventoryItem;
import mormontrail.model.Location;
import mormontrail.model.Map;
import mormontrail.model.Player;
import mormontrail.model.Question;
import mormontrail.model.RandomEvent;
import mormontrail.model.Scene;
import mormontrail.view.StartProgramView;

/**
 *
 * @author andrew
 */
public class MormonTrail {

    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null; 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
            
            MormonTrail.inFile = new BufferedReader(new InputStreamReader(System.in));
            
            
            MormonTrail.outFile = new PrintWriter(System.out, true);
            
            String filePath = "log.txt";
            MormonTrail.logFile = new PrintWriter(filePath);
            
            // create StartProgramViewOrig and display the start program view
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.displayStartProgramView();
        }
        
        catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }
        
        finally {
            try {
                if (MormonTrail.inFile != null)
                    MormonTrail.inFile.close();
                
                if (MormonTrail.outFile != null)
                    MormonTrail.outFile.close();
                
                if (MormonTrail.logFile != null)
                    MormonTrail.logFile.close();
            } catch (IOException ex) {
                // Brother Jones said to keep this how it is ... no need to switch to ErrorView.display(this.getClass().getName(), "" );
                System.out.println("Error closing files");
                return;
            }
        }
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

     public static void setCurrentGame(Game currentGame) {
        MormonTrail.currentGame = currentGame;
    }
    
    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        MormonTrail.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        MormonTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        MormonTrail.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        MormonTrail.logFile = logFile;
    }
}
