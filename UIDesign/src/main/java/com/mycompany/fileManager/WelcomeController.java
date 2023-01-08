/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fileManager;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.mycompany.fileManager.database.DatabaseConnection;
import com.mycompany.fileManager.database.DatabaseSetup;
import com.mycompany.fileManager.model.User;
import com.mycompany.fileManager.security.SecurityContextHolder;
import com.mycompany.fileManager.services.FileService;
import com.mycompany.fileManager.storage.FileChunk;
import com.mycompany.fileManager.storage.FileDescription;
import com.mycompany.fileManager.storage.StoredFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import com.mycompany.fileManager.utils.FileUtils;
import java.nio.file.StandardOpenOption;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private TextField usernameField;


    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private MenuButton Upload;

    @FXML
    private Button upload;

    @FXML
    private Button viewfiles;
    @FXML
    private Button back;
    @FXML
    private Button delete;

    @FXML
    private Button welcome;

    @FXML
    private Button logout;
    @FXML
    private Button createFile;
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextArea fileContent;
     @FXML
    private Button updateuser;
    @FXML
    private Button saveBtn;

    @FXML
    private TableView dataTableView;

    @FXML
    private Text fileText;

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void rename(ActionEvent event) {

    }

    @FXML
    void move(ActionEvent event) {

    }

    @FXML
    void copy(ActionEvent event) {

    }
    @FXML
    void updateuserBtn (ActionEvent event) throws InvalidKeySpecException {
        System.out.println("Got Here 117");
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) updateuser.getScene().getWindow();
       try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("updateuser.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Kindly Update Your Deatails ");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
                }
    }

    @FXML
    void welcomeBtn(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) welcome.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("welcome.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Welcome ");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logoutBtn(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) logout.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Kindly login");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewfilesBtn(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) viewfiles.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fileList.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Your files");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deleteuserBtn(ActionEvent event) throws InvalidKeySpecException, SQLException, IOException   {
         Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) delete.getScene().getWindow();
        System.out.println("got it");
        
       FXMLLoader loader = new FXMLLoader();
             if (!DatabaseSetup.usersDatabase.userExists(usernameTextField.getText().trim())) {
                
               

                    User user = new User(usernameTextField.getText().trim(), passwordField.getText().trim(), firstNameField.getText(), lastNameField.getText(), emailField.getText(), false);

                    DatabaseSetup.usersDatabase.delUser(user);
           
           dialogue("This User has been deleted", "");
           loader.setLocation(getClass().getResource("signup.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root, 640, 480);
                    secondaryStage.setScene(scene);
                    SignupController controller = loader.getController();
                 secondaryStage.setTitle("Show users");
              //     controller.initialise(credentials);
                    String msg = "some data sent from Register Controller";
                    secondaryStage.setUserData(msg);
  
        }
    }

    

    @FXML
    void backBtn(ActionEvent event) {
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) back.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Kindly login");
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

        try {
            //   FileEncryption.encrypt(file.getName(),"Adeshile");
            fs.uploadFile(file);

            System.out.println("Succesful File Upload");
             dialogue("File Uploaded Successfully", "Your file has been Uploaded");
        } catch (SftpException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSchException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void createFileHandler(ActionEvent event) {

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

    public void initialise(String[] credentials) {
        usernameTextField.setText(credentials[0]);
        ObservableList<StoredFile> data = DatabaseSetup.filesDatabase.getUserFiles(credentials[0]);

        TableColumn<StoredFile, String> fileN = new TableColumn("FileName");
        fileN.setCellValueFactory(sf -> new SimpleStringProperty(sf.getValue().getFileName()));

        TableColumn<StoredFile, String> timeCreated = new TableColumn<>("Time Created");
        timeCreated.setCellValueFactory(i -> new SimpleStringProperty(i.getValue().getFileDescription().getCreated()));

        TableColumn<StoredFile, String> fileSize = new TableColumn<>("File Size");
        fileSize.setCellValueFactory(sf -> new SimpleStringProperty(String.valueOf(sf.getValue().getFileDescription().getFileSizeInKb())));
        
        TableColumn<StoredFile, String> sharefile = new TableColumn<>("Share File");
        sharefile.setCellValueFactory(sf -> new SimpleStringProperty(String.valueOf(sf.getValue().getFileDescription().getFileSizeInKb())));

        dataTableView.setItems(data);
        dataTableView.getColumns().addAll(fileN, timeCreated, fileSize, sharefile);
    }

    @FXML
    private void saveBtnHandler(ActionEvent event) throws SQLException, JSchException, SftpException {

        try {

            FileChooser fileChooser = new FileChooser();
            FileService fileService = new FileService ();
            
            File file = fileChooser.showSaveDialog(fileContent.getScene().getWindow());
            if (file == null) {
                return;
            }

            String content = fileContent.getText();
            Files.write(file.toPath(), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
           fileService.saveFile(file);
            dialogue("File Saved Successfully", "File Created Successfully");
            
        } catch (IOException e) {
            System.out.println("An error occured.");
            {

            }

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
}
