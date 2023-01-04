/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

import com.mycompany.fileManager.database.DatabaseConnection;
import com.mycompany.fileManager.model.User;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntu-user
 */
public class UserSignup {

    public static void main(String... args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        DatabaseConnection conn = new DatabaseConnection();

        /*String Uname = "";
    String password = "";
    String firstName = "";
    String lastName = "";
    Boolean isAdmin = false ;
    String email = "";
         */
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        System.out.println("Enter FirstName:");
        String firstName = scanner.nextLine();

        System.out.println("Enter LastName:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Email Address:");
        String email = scanner.nextLine();

        System.out.println("Enter Password");
        String password = scanner.nextLine();

        User myUser = new User(username, password, firstName, lastName, email, false);

        try {
            conn.addDataToDB(myUser);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserSignup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
