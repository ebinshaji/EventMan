module com.ebin.eventman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ebin.eventman to javafx.fxml;
    exports com.ebin.eventman;
}