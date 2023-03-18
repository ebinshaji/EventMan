package com.ebin.eventman;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HomeController implements Initializable{


    @FXML
    private Button btncustomer;

    @FXML
    private Button btndashboard;

    @FXML
    private Button btnevents;

    @FXML
    private Button btninsights;

    @FXML
    private Button btnsettings;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void leftbtnclicks(ActionEvent event) {
        if (event.getSource() == btndashboard){

        }else if (event.getSource() == btnevents){

        }else if (event.getSource() == btncustomer){

        }else if (event.getSource() == btninsights){

        }else if (event.getSource() == btnsettings){

        }
    }
}
