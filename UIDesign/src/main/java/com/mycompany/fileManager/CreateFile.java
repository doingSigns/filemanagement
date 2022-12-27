/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fileManager;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author ntu-user
 */
public class CreateFile {
    public static void main (String[]args) throws IOException{
        try{
            File myFile = new File ("User.txt");
            if(myFile.createNewFile()){
                System.out.println("File created:" + myFile.getName());
            }else{
                System.out.println("File already exists");
            }
        }catch (IOException e){
            System.out.println("An error occured.");
        }
    }
    
}
