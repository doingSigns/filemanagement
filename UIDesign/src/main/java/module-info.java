  module com.mycompany.fileManager
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.sql; // added
    requires jsch;
    requires com.google.gson;
   

    opens com.mycompany.fileManager to javafx.fxml;
    exports com.mycompany.fileManager;
}
