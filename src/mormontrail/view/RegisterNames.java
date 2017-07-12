/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.view;

import java.util.ArrayList;
import java.util.Scanner;
import mormontrail.model.Actor;

/**
 *
 * @author Joshua
 */
public class RegisterNames extends View {
    
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
        
        super("\n1) Please enter Wagon Leader's name (Q to Quit): ");
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
        this.console.println(this.banner);
    }
    
    boolean getRegisterNames() {

        //name1 = getName(this.namePrompt1);
        
//        if (name1.toUpperCase().equals("Q"))
//            return;
        
        name2 = getName(this.namePrompt2);
        if (name2.toUpperCase().equals("Q"))
            return true;
        
        name3 = getName(this.namePrompt3);
        if (name3.toUpperCase().equals("Q"))
            return true;
        
        name4 = getName(this.namePrompt4);
        if (name4.toUpperCase().equals("Q"))
            return true;
        
        name5 = getName(this.namePrompt5);
        if (name5.toUpperCase().equals("Q"))
            return true;

        return false;
//        done = doAction();
    }
    
    private String getName(String prompt) {
        
        String value = "";
        boolean valid = false;
        
        try {
        while (!valid) {
            this.console.println("\n" + prompt);
            
            value = keyboard.readLine();
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
    }
    
    @Override
    public boolean doAction(String value) {
        
        name1 = value;
        if (getRegisterNames())
            return true;
        this.console.println("Wagon Leader: " + name1);
        this.console.println("Wagon Member #2: " + name2);
        this.console.println("Wagon Member #3: " + name3);
        this.console.println("Wagon Member #4: " + name4);
        this.console.println("Wagon Member #5: " + name5);
        
       
        String validation = getName("Are these names correct? (Y/N)");
        //If 'Yes', transition to Store view.
        //We need to store the names in the Actors.
        if (validation.toUpperCase().equals("Y")) {
            ArrayList<Actor> actors = mormontrail.MormonTrail.getCurrentGame().getActors();
            Actor actor = new Actor();
            actor.setName(name1);
            actor.setDescription("wagon leader");
            actor.setHealth(100);
            actor.setWeight(230);
            actors.add(actor);
            
            actor = new Actor();
            actor.setName(name2);
            actor.setDescription("wagon party 1");
            actor.setHealth(100);
            actor.setWeight(200);
            actors.add(actor);
            
            actor = new Actor();
            actor.setName(name3);
            actor.setDescription("wagon party 2");
            actor.setHealth(100);
            actor.setWeight(180);
            actors.add(actor);
            
            actor = new Actor();
            actor.setName(name4);
            actor.setDescription("wagon party 3");
            actor.setHealth(100);
            actor.setWeight(190);
            actors.add(actor);
            
            actor = new Actor();
            actor.setName(name5);
            actor.setDescription("wagon party 4");
            actor.setHealth(100);
            actor.setWeight(205);
            actors.add(actor);
//            Store store = new Store();
//            store.setStoreName("General Store"); //hard-coded for now.
//            store.getInventory();
//            store.display();
            InGameMenu inGameMenu = new InGameMenu();
            inGameMenu.display();
            return true;
        }
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
