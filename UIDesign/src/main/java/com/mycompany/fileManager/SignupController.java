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
import com.mycompany.fileManager.DatabaseConnection;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.mycompany.fileManager.User;
import java.security.spec.InvalidKeySpecException;

/**
 * FXML Controller class
 *
 * @author ntu-user
 */
public class SignupController  {
@FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private PasswordField retypepasswordField;

    @FXML
  private void loginBtnHandler(ActionEvent event) {
      
            Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("login");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
  }
  
   private void dialogue(String headerMsg, String contentMsg) {
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMsg);
        alert.setContentText(contentMsg);
        Optional<ButtonType> result = alert.showAndWait();
    }
        private void errorDialogue(String headerMsg, String contentMsg) {
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(headerMsg);
        alert.setContentText(contentMsg);
        Optional<ButtonType> result = alert.showAndWait();
    }
  
    @FXML
   private void registerBtnHandler(ActionEvent event) throws InvalidKeySpecException {
        System.out.println("Got Here 117");
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) registerBtn.getScene().getWindow();
        try {
            
       
            FXMLLoader loader = new FXMLLoader();
         
            if (passwordField.getText().equals(retypepasswordField.getText())) {
                DatabaseConnection myObj = new DatabaseConnection();
                User user = new User (usernameField.getText(), passwordField.getText(),firstNameField.getText(),lastNameField.getText(),emailField.getText(),false);
                System.out.println("Got Here");
                myObj.addDataToDB(user);
                dialogue("Adding information to the database", "Successful!");
               
                String[] credentials = {usernameField.getText(), passwordField.getText()};
            loader.setLocation(getClass().getResource("secondary.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
                SecondaryController controller = loader.getController();
                secondaryStage.setTitle("Show users");
                controller.initialise(credentials);
                String msg = "some data sent from Register Controller";
                secondaryStage.setUserData(msg);
            } else {
                loader.setLocation(getClass().getResource("register.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
                secondaryStage.setTitle("Register a new User");
            }
            secondaryStage.show();
            primaryStage.close();
           
       
        }catch(NullPointerException e) {
            
            errorDialogue("Something went wrong!", e.getMessage());
            
        }
            catch (IOException ex) {
            System.out.println(ex);
        

        }}
}


    
