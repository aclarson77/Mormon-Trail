/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import mormontrail.MormonTrail;

/**
 *
 * @author Joshua
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    protected BufferedReader keyboard = MormonTrail.getInFile();
    protected PrintWriter console = MormonTrail.getOutFile();;
    
    public View() {
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
    boolean done = false;
    do {
        String value = this.getInput();
        if (value.toUpperCase().equals("Q"))
            return;

        done = this.doAction(value);
    } while (!done);
}

    @Override
    public String getInput() {
        
        boolean valid = false;
        String value = null;
        
        try {
            // while a valid name has not been retrieved
            while (!valid) {
                this.console.println("\n" + this.displayMessage);

                // get the value entered from the keyboard
                value = this.keyboard.readLine();
                value = value.trim();

                if (value.length() < 1) {
                    ErrorView.display(this.getClass().getName(),
                            "\nInvalid value: value can not be blank");
                    continue;
                }
                break;
            }
      
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(),
                    "Reading input: " + e.getMessage());
        }
        
        return value;
    }
}
