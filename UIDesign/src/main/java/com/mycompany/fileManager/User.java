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
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.email = new SimpleStringProperty(email);
        this.isAdmin = isAdmin;
    }

    User(String string, String string0, String string1, String string2, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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