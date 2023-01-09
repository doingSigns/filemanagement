/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package com.mycompany.fileManager;

import javafx.stage.Stage;
import junit.framework.TestCase;

/**
 *
 * @author ntu-user
 */
public class AppTest extends TestCase {
    
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * Test of start method, of class App.
     */
    public void testStart() {
        System.out.println("start");
        Stage stage = null;
        App instance = new App();
        instance.start(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class App.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        App.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
