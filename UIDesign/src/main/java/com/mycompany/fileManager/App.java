package com.mycompany.fileManager;

import com.mycompany.fileManager.database.DatabaseSetup;
import com.mycompany.fileManager.server.SFTPDelegate;
import com.mycompany.fileManager.database.FilesDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        try {
            DatabaseSetup db = new DatabaseSetup("details.db");
            db.init();
            
           

            Stage secondaryStage = new Stage();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            secondaryStage.setTitle("Login Details");
            secondaryStage.show();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
