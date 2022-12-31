/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import com.mycompany.fileManager.DatabaseConnection;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author ntu-user
 */
public class LoginController {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerBtn;

    @FXML
    private Button loginBt;

  
   
        private void dialogue(String headerMsg, String contentMsg) {
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMsg);
        alert.setContentText(contentMsg);

        Optional<ButtonType> result = alert.showAndWait();
    }

    @FXML
   private void loginBtHandler(ActionEvent event) throws InvalidKeySpecException {
       
 
      Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) loginBt.getScene().getWindow();
               
                try {
             DatabaseConnection connect = new DatabaseConnection ();
           //  String [] credentials = {userTextField.getText(), passwordTextField.getText()};
            
            if(connect.validateUser(userTextField.getText(), passwordTextField.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("welcome.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Login Successful");
            secondaryStage.show();
            primaryStage.close();
                 
             }else {
                 dialogue("Incorrect User Name / Password", "Please try again!");
             }
            
            // Check of the 
        } catch (IOException e) { {
            
        }
        
       
       /*if(usernameTextField.getText().equals("username") && passwordTextField.getText().equals("password")){
           
           
           
       }*/
       
       
       
       /*
            Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) loginBt.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("welcome.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Login");
            secondaryStage.show();
            primaryStage.close();

        } catch (IOException ex) {
           System.out.println(ex);
        }*/

    }
   }

    @FXML
    private void registerBtnHandler(ActionEvent event) throws IOException {
Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signup.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Register");
            secondaryStage.show();
            primaryStage.close();

        } catch (IOException ex) {
             System.out.println(ex);
        }

    }

}
    

