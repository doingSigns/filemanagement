/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ntu-user
 */
public class WelcomeController  {

     @FXML
    private Button upload;
   
      @FXML 
      private Button createFile;
      
      @FXML
      private TextArea fileContent;
      
      @FXML
    private TableView dataTableView;
   
        @FXML
    private TextField usernameTextField;
        
      @FXML
      private Button saveBtn;
      
       @FXML
    private Button back;
@FXML
private MenuItem login;
      
      
      
   
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
     private void logout(ActionEvent event){/* throws IOException {
        Stage secondaryStage = new Stage();
        Stage primaryStage= (Stage) login.getScene().getWindow();
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

    */
    
    }

   
       
        
      
   
    @FXML
   private void backBtn(ActionEvent event) throws IOException {
        Stage secondaryStage = new Stage();
        Stage primaryStage= (Stage) back.getScene().getWindow();
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
       
    }
    @FXML 
     private void createFileHandler (ActionEvent event){
         
        
         
         System.out.println("Got here create file 117");
         
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) createFile.getScene().getWindow();
         
          try{
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("textEditor.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("text editor");
            secondaryStage.show();
            primaryStage.close();
           
           
            
        }catch (IOException e){
            System.out.println("An error occured.");
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

            SFTPDelegate.copyFile("ade", file, FileServer.CONTAINER_ONE);

            System.out.println("Succesful File Upload");
        } catch (SftpException | JSchException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   public void initialise(String[] credentials) {
     usernameTextField.setText(credentials[0]);
        DatabaseConnection myObj = new DatabaseConnection();
        ObservableList<String> data = myObj.getDataFromTable();
        TableColumn user = new TableColumn("User");
        user.setCellValueFactory(
        new PropertyValueFactory<>("username"));

        TableColumn pass = new TableColumn("Pass");
        pass.setCellValueFactory(
            new PropertyValueFactory<>("password"));
        
        TableColumn email = new TableColumn("Email");
        email.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        dataTableView.setItems(data);
        dataTableView.getColumns().addAll(user, pass,email); 
        
    }


    
    @FXML 
     private void saveBtnHandler (ActionEvent event){
         
         
          try{
            
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(fileContent.getScene().getWindow());
            if(file ==null){
                return;
            }
            
            String content = fileContent.getText();
            Files.write(file.toPath(), content.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            dialogue("File Saved Successfully","File Created Successfully");
        }catch (IOException e){
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


