/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormontrail.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre
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
        System.out.println("addToInventory Test Case #1");
        double currentFood = 400.0;
        double newFood = 75.0;
        double currentAmmo = 50.0;
        double newAmmo = 25.0;
        double currentClothes = 60.0;
        double newClothes = 20.0;
        InventoryControl instanceOne = new InventoryControl();
        double expResult = 766.25;
        double result = instanceOne.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #2");
        currentFood = -1.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance2 = new InventoryControl();
        expResult = -1;
        result = instance2.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #3");
        currentFood = 0.0;
        newFood = -1.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance3 = new InventoryControl();
        expResult = -1;
        result = instance3.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #4");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = -1.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance4 = new InventoryControl();
        expResult = -1;
        result = instance4.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #5");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = -1.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance5 = new InventoryControl();
        expResult = -1.0;
        result = instance5.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #6");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = -1.0;
        newClothes = 0.0;
        InventoryControl instance6 = new InventoryControl();
        expResult = -1;
        result = instance6.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #7");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = -1.0;
        InventoryControl instance7 = new InventoryControl();
        expResult = -1;
        result = instance7.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("addToInventory Test Case #8");
        currentFood = 1000.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance8 = new InventoryControl();
        expResult = 1000;
        result = instance8.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #9");
        currentFood = 0.0;
        newFood = 1000.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance9 = new InventoryControl();
        expResult = 2000.0;
        result = instance9.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #10");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 100.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance10 = new InventoryControl();
        expResult = 100.0;
        result = instance10.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #11");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 100.0;
        currentClothes = 0.0;
        newClothes = 0.0;
        InventoryControl instance11 = new InventoryControl();
        expResult = 25.0;
        result = instance11.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #12");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 100.0;
        newClothes = 0.0;
        InventoryControl instance12 = new InventoryControl();
        expResult = 100.0;
        result = instance12.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #13");
        currentFood = 0.0;
        newFood = 0.0;
        currentAmmo = 0.0;
        newAmmo = 0.0;
        currentClothes = 0.0;
        newClothes = 100.0;
        InventoryControl instance13 = new InventoryControl();
        expResult = 500.0;
        result = instance13.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3725.0);
        
        System.out.println("addToInventory Test Case #14");
        currentFood = 1000.0;
        newFood = 1000.0;
        currentAmmo = 100.0;
        newAmmo = 100.0;
        currentClothes = 100.0;
        newClothes = 100.0;
        InventoryControl instance14 = new InventoryControl();
        expResult = 3725.0;
        result = instance14.addToInventory(currentFood, newFood, currentAmmo, newAmmo, currentClothes, newClothes);
        assertEquals(expResult, result, 3726.0);
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
