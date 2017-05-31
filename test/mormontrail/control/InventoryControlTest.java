/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import mormontrail.model.InventoryItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joshua
 */
public class InventoryControlTest {
    
    public InventoryControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addToInventory method, of class InventoryControl.
     */
    @Test
    public void testAddToInventory() {
        System.out.println("addToInventory 1");
        InventoryItem currentItem;
        InventoryItem newItem = null;
        currentItem = new InventoryItem("food", 200, 2);
        newItem = new InventoryItem("food", 100, 2);
        double expResult = 600.0;    
        double result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 2");
        currentItem = new InventoryItem("food", 100, 2);
        newItem = new InventoryItem("ammo", 50, 0.25);
        expResult = -1;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 3");
        currentItem = new InventoryItem("clothes", 120, 5);
        newItem = new InventoryItem("clothes", 0, 5);
        expResult = -2;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 4");
        currentItem = new InventoryItem("clothes", 0, 5);
        newItem = new InventoryItem("clothes", 110, 5);
        expResult = -3;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 5");
        currentItem = new InventoryItem("clothes", 70, 5);
        newItem = new InventoryItem("clothes", 60, 5);
        expResult = -4;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 6");
        currentItem = new InventoryItem("food", 1000, 2);
        newItem = new InventoryItem("food", 0, 2);
        expResult = 2000;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 7");
        currentItem = new InventoryItem("ammo", 100, 0.25);
        newItem = new InventoryItem("ammo", 0, 0.25);
        expResult = 25;  
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("addToInventory 8");
        currentItem = new InventoryItem("clothes", 100, 5);
        newItem = new InventoryItem("clothes", 0, 5);
        expResult = 500;
        result = InventoryControl.addToInventory(currentItem, newItem);
        assertEquals(expResult, result, 0.01);
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromInventory method, of class InventoryControl.
     * @author A.J. Hess
     */
    @Test
    public void testRemoveFromInventory() {
        System.out.println("removeFromInventory 1");
        InventoryItem currentItem;
        InventoryItem removeItem = null;
        currentItem = new InventoryItem("food", 200, 2);
        removeItem = new InventoryItem("food", 100, 2);
        double expResult = 200.0;
        double result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 2");
        currentItem = new InventoryItem("food", 100, 2);
        removeItem = new InventoryItem("ammo", 50, 0.25);
        expResult = -1;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 3");
        currentItem = new InventoryItem("clothes", 110, 5);
        removeItem = new InventoryItem("clothes", 0, 5);
        expResult = -2;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 4");
        currentItem = new InventoryItem("clothes", 0, 5);
        removeItem = new InventoryItem("clothes", 110, 5);
        expResult = -3;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 5");
        currentItem = new InventoryItem("clothes", 60, 5);
        removeItem = new InventoryItem("clothes", 70, 5);
        expResult = -4;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 6");
        currentItem = new InventoryItem("food", 1000, 2);
        removeItem = new InventoryItem("food", 0, 2);
        expResult = 2000;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 7");
        currentItem = new InventoryItem("ammo", 100, 0.25);
        removeItem = new InventoryItem("ammo", 0, 0.25);
        expResult = 25;  
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("removeFromInventory 8");
        currentItem = new InventoryItem("clothes", 100, 5);
        removeItem = new InventoryItem("clothes", 0, 5);
        expResult = 500;
        result = InventoryControl.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.01);
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    /**
     * Test of removeFromInventory method, of class InventoryControl.
     */
    /*@Test
    public void testRemoveFromInventory() {
        System.out.println("removeFromInventory");
        InventoryItem currentItem = null;
        InventoryItem removeItem = null;
        InventoryControl instance = new InventoryControl();
        double expResult = 0.0;
        double result = instance.removeFromInventory(currentItem, removeItem);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
