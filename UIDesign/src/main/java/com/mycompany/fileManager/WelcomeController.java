/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import com.mycompany.fileManager.server.SFTPDelegate;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.mycompany.fileManager.server.FileServer;
import com.mycompany.fileManager.services.FileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ntu-user
 */
public class WelcomeController {

    private FileService fs = new FileService();

    @FXML
    private Button upload;
    @FXML
    private Button view;

    @FXML
    private Button createFile;

    @FXML
    private TextArea fileContent;

    @FXML
    private Button saveBtn;

    //   @FXML
    // private MenuItem loginBtn;
    @FXML
    private Text fileText;

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void deleteprofile(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        /* Stage secondaryStage = new Stage();
        Stage primaryStage= (Stage) loginBtn.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Login");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
    }

    @FXML
    void viewBtn(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) view.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("files.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Your Files");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void uploadHandler(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) upload.getScene().getWindow();
        primaryStage.setTitle("Select a File");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(primaryStage);

        if (file == null) {
            return;
        }

        try {

            fs.uploadFile(file);

            System.out.println("Successful File Upload");
        } catch (SftpException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSchException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void createFileHandler(ActionEvent event) {

        System.out.println("Got here create file 117");

        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) createFile.getScene().getWindow();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("textEditor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("text editor");
            secondaryStage.show();
            primaryStage.close();

        } catch (IOException e) {
            System.out.println("An error occured.");
        }

    }

    @FXML
    private void saveBtnHandler(ActionEvent event) {

        try {

            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(fileContent.getScene().getWindow());
            if (file == null) {
                return;
            }

            String content = fileContent.getText();
            Files.write(file.toPath(), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            dialogue("File Saved Successfully", "File Created Successfully");
        } catch (IOException e) {
            System.out.println("An error occured.");
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

}
