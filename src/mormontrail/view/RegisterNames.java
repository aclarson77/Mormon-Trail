/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.Scanner;
import mormontrail.model.Actor;

/**
 *
 * @author Joshua
 */
public class RegisterNames {
    
    private String namePrompt1;
    private String namePrompt2;
    private String namePrompt3;
    private String namePrompt4;
    private String namePrompt5;
    public String validationPrompt;
    private String banner;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    
    public RegisterNames() {
        
        this.namePrompt1 = "\n1) Please enter Wagon Leader's name (Q to Quit): ";
        this.namePrompt2 = "\n2) Please enter another name (Q to Quit): ";
        this.namePrompt3 = "\n3) Please enter another name (Q to Quit): ";
        this.namePrompt4 = "\n4) Please enter another name (Q to Quit): ";
        this.namePrompt5 = "\n5) Please enter another name (Q to Quit): ";
        this.validationPrompt = "\n(Y/N) Are these names correct? ";
        this.banner = "\n**************************************************************"
        +"\n*                                                           *"       
        +"\n* Welcome to the Company! Please register your name as the  *"
        +"\n* Wagon Leader, along with any others within your group.    *"
        +"\n*                                                           *"
        +"\n* Once you've registered your party, you will want to head  *"
        +"\n* on over to the Store in order to purchase supplies for the*"
        +"\n* long journey ahead of us! Make sure you gather what you   *"
        +"\n* need for yourself and those you're looking after.         *"
        +"\n*                                                           *"
        +"\n*************************************************************";
    }
    
    

    void displayRegisterNames() {
        
        boolean done = false;
        
        do {
      
        System.out.println(this.banner);
        name1 = getName(this.namePrompt1);
        
        if (name1.toUpperCase().equals("Q"))
            return;
        
        name2 = getName(this.namePrompt2);
        if (name2.toUpperCase().equals("Q"))
            return;
        
        name3 = getName(this.namePrompt3);
        if (name3.toUpperCase().equals("Q"))
            return;
        
        name4 = getName(this.namePrompt4);
        if (name4.toUpperCase().equals("Q"))
            return;
        
        name5 = getName(this.namePrompt5);
        if (name5.toUpperCase().equals("Q"))
            return;

        done = doAction();
        } while(!done);
    }
    
    private String getName(String prompt) {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + prompt);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break; 
        }
        return value;
    }
    
    private boolean doAction() {
        
        System.out.println("Wagon Leader: " + name1);
        System.out.println("Wagon Member #2: " + name2);
        System.out.println("Wagon Member #3: " + name3);
        System.out.println("Wagon Member #4: " + name4);
        System.out.println("Wagon Member #5: " + name5);
        
       
        String validation = getName("Are these names correct? (Y/N)");
        
        if (validation.toUpperCase().equals("Y"))
            return true;
        else
            return false;
        
        
        
//        if (name1.length() < 3 ) {
//            System.out.println("\nInvalid players name: "
//                    + "The name must be greater than one character in length");
//            return false;
//        }
//        
//        Actor actor = GameControl.createActor(actorName);
//        
//        if (actor == null) {
//            System.out.println("\nError creating the player.");
//            return false;
//        }
//    
//        this.displayNextView(actor); 
//        
//        return true;
    }    
}
