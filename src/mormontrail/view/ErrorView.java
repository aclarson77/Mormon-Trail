/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.io.PrintWriter;
import mormontrail.MormonTrail;

/**
 *
 * @author Joshua
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = MormonTrail.getOutFile();
    private static final PrintWriter logFile = MormonTrail.getLogFile();
    
    //page 7 team assignment week 12 - change className to the respective class name of the error
    public static void display(String className, String errorMessage) {
        errorFile.println(
                "-----------------------------------------------------------"
              + "\n- ERROR - " + errorMessage
              + "\n-----------------------------------------------------------");
        
        //log error - replace className with our class name ... what about errorMessage? What's our errorMessage?
        logFile.println(className + " - " + errorMessage);
    }
}
