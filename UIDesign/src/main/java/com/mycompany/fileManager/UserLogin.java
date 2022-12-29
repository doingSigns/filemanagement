/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.fileManager.DatabaseConnection;

/**
 *
 * @author ntu-user
 */
public class UserLogin {
    
    
    public static void main (String ... args){
        
          DatabaseConnection connect = new DatabaseConnection ();
    
        
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        
        // Get the username saved in the DB
        
        System.out.println("Enter Password:");
        String password = scanner.nextLine();
        
        try {
            // Get the password saved in the DB
            
             if(connect.validateUser(username, password)  ){
                 System.out.println("Login is successful");
             }else {
                 System.out.println("Incorrect username/password entered");
             }
            
            // Check of the 
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}

    

