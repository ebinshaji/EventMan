module com.ebin.eventman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;


    opens com.ebin.eventman to javafx.fxml;
    exports com.ebin.eventman;
}