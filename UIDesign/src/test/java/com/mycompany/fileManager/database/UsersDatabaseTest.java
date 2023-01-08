/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fileManager.database;

import com.mycompany.fileManager.model.User;
import java.sql.Connection;
import com.mycompany.fileManager.database.DatabaseSetup;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ntu-user
 */
public class UsersDatabaseTest {
   
    
    public UsersDatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws SQLException {
        DatabaseSetup db = new DatabaseSetup("details.db");
        db.init();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createTable method, of class UsersDatabase.
     */
    @Test
    public void testCreateTable() throws SQLException {
        System.out.println("createTable");
        DatabaseSetup db = new DatabaseSetup("details.db");
        db.init();
        UsersDatabase instance = new UsersDatabase();
        instance.createTable(DatabaseSetup.getConnection());
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of authenticateUser method, of class UsersDatabase.
     */
    @Test
    public void testAuthenticateUser() throws Exception {
        System.out.println("authenticateUser");
        String username = "Ade";
        String passwordHash = "Adeshile";
        UsersDatabase instance = new UsersDatabase();
        boolean expResult = true;
        boolean result = instance.authenticateUser(username, passwordHash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.     
    }
    
    @Test
    public void testInvalidAuthenticateUser() throws Exception {
        System.out.println("Invalid user Authentication");
        String username = "Ade";
        String passwordHash = "Ade";
        UsersDatabase instance = new UsersDatabase();
        boolean expResult = false;
        boolean result = instance.authenticateUser(username, passwordHash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.     
    }
    

    /**
     * Test of addUser method, of class UsersDatabase.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        User user = new User( "Ola", "Ade", "Adeshile", "Osunkoya", "shileosun@gmail.com", false);
        
        UsersDatabase instance = new UsersDatabase();
        instance.addUser(user);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of userExists method, of class UsersDatabase.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        String username = "Ade";
        UsersDatabase instance = new UsersDatabase();
        boolean expResult = true;
        boolean result = instance.userExists(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    @Test
    public void testUserDoesNotExists() {
        System.out.println("User Does Not Exit");
        String username = "Family";
        UsersDatabase instance = new UsersDatabase();
        boolean expResult = false;
        boolean result = instance.userExists(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
