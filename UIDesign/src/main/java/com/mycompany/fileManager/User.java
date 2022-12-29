/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ntu-user
 */

public class User {
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty email;
    private boolean isAdmin ;

    User(String username, String password, String firstname, String lastname,String email, boolean isAdmin) {
        if(username == null || username.isEmpty()){
            throw new NullPointerException("Username must not be null or empty");
        }
        if(password == null || password.isEmpty()){
            throw new NullPointerException("Password must not be null or empty");
        }
         
        if(firstname == null || firstname.isEmpty()){
            throw new NullPointerException("FirstName must not be null or empty");
        }
        if(lastname == null || lastname.isEmpty()){
            throw new NullPointerException("Last Name must not be null or empty");
        }
        if(email == null || email.isEmpty()){
            throw new NullPointerException("Email must not be null or empty");
        }
        
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.isAdmin = isAdmin;
    }

  
    
    
public void setUsername(String username) {
        this.username.set(username);
    }
    public String getUsername() {
        return username.get();
    }

      public void setPassword(String password) {
        this.password.set(password);
    }
    public String getPassword() {
        return password.get();
    }
    
    public void setFirstName(String firstname){
        this.firstname.set(firstname);
    }
    public String getFirstName(){
        return firstname.get();
    }
    
    public void setLastName(String lastname){
        this.lastname.set(lastname);
    }
    public String getLastName(){
        return lastname.get();
    }
    public void setEmail(String email){
        this.email.set(email);
    }
    public String getEmail(){
        return email.get();
    }
    public void setAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    public boolean getAdmin (){
        return isAdmin;
    }
}