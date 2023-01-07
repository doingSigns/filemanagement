/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import com.mycompany.fileManager.database.DatabaseSetup;
import com.mycompany.fileManager.model.User;
import java.io.IOException;
import java.net.URL;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ntu-user
 */
public class UpdateuserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private TextField usernameField;

    @FXML
    private Button updateBtn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;
    
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
    
    @FXML
    void updateBtnHandler(ActionEvent event) throws InvalidKeySpecException, SQLException, IOException {
        System.out.println("Got Here 117");
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) updateBtn.getScene().getWindow();
        

            FXMLLoader loader = new FXMLLoader();
             if (!DatabaseSetup.usersDatabase.userExists(usernameField.getText().trim())) {

                   User user = new User(usernameField.getText().trim(), passwordField.getText().trim(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), false);

                    DatabaseSetup.usersDatabase.addUser(user);

                    dialogue("Information Updated", "Successful!");

                    String[] credentials = {usernameField.getText(), passwordField.getText(),firstNameField.getText(), lastNameField.getText(), emailField.getText()};
                    loader.setLocation(getClass().getResource("welcome.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root, 640, 480);
                    secondaryStage.setScene(scene);
                    WelcomeController controller = loader.getController();
                 secondaryStage.setTitle("Show users");
                    controller.initialise(credentials);
                    String msg = "some data sent from Register Controller";
                    secondaryStage.setUserData(msg);

    }
}  
}
