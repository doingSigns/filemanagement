module com.mycompany.fileManager
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.sql; // added

    opens com.mycompany.fileManager to javafx.fxml;
    exports com.mycompany.fileManager;
}
