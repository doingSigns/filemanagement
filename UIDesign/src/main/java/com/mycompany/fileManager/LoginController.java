/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import com.mycompany.fileManager.database.DatabaseSetup;
import com.mycompany.fileManager.security.SecurityContextHolder;
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
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;
    
    @FXML
    private Button admin;

    @FXML
    private Button registerBtn;

    @FXML
    private Button loginBt;

    private void dialogue(String headerMsg, String contentMsg) {
        Stage secondaryStage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.DARKGRAY);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(headerMsg);
        alert.setContentText(contentMsg);
        Optional<ButtonType> result = alert.showAndWait();
    }
public void initialise(String[] credentials) {
        usernameTextField.setText(credentials[0]);

}
    @FXML
    private void loginBtHandler(ActionEvent event) throws IOException {

        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) loginBt.getScene().getWindow();

        try {
            
            String userId = usernameTextField.getText();

            if (DatabaseSetup.usersDatabase.authenticateUser(userId, passwordTextField.getText())) {
                
                SecurityContextHolder.context.setUserId(userId);
                 String[] credentials = {usernameTextField.getText(), passwordTextField.getText()};
                
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("welcome.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root, 640, 480);
                secondaryStage.setScene(scene);
                 WelcomeController controller = loader.getController();
                    secondaryStage.setTitle("Show users");
                    controller.initialise(credentials);
                secondaryStage.setTitle("Login Successful");
                secondaryStage.show();
                primaryStage.close();

            } else {
                dialogue("Incorrect User Name / Password", "Please try again!");
            }

            // Check of the 
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
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
     @FXML
    private void adminBtn(ActionEvent event) throws IOException {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) admin.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Admin Page");
            secondaryStage.show();
            primaryStage.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }
}
}
