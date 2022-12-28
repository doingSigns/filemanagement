package com.mycompany.fileManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Stage secondaryStage = new Stage();
        DatabaseConnection myObj = new DatabaseConnection();
        myObj.log("-------- File Manager Course Work ------------");
        myObj.log("\n---------- Drop table ----------");
        myObj.delTable(myObj.getTableName());
        myObj.log("\n---------- Create table ----------");
        myObj.createTable(myObj.getTableName());
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Login Details");
            secondaryStage.show();

        } catch (IOException e) {
          System.out.println(e); 
        }
    }

    public static void main(String[] args) {
        launch();
    }

}