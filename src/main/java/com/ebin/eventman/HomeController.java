package com.ebin.eventman;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;

public class HomeController extends Application implements Initializable{

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

    @FXML
    private Button btninsights1;

    @FXML
    private Button btnsettings1;

    @FXML
    private Pane panecustomer;

    @FXML
    private Pane panedashboard;

    @FXML
    private Pane paneevents;

    @FXML
    private Pane paneinsights;

    @FXML
    private Pane panesettings;

    @FXML
    private Label placelabel;

    @FXML
    private Pane placeback;

    @FXML
    private ImageView logobtnimg;

    @FXML
    private Button closebtnimg;

    @FXML
    private BorderPane borderpanemain;

    @FXML
    public Label username;



    private double x,y=0;
    public String leftbar1;
    public String leftbar2;
    public String leftbar3;
    public String leftbar4;
    public String leftbar5;
    public String leftbar6;
    public String leftbar7;





    @FXML
    private void borderpand_dragged(MouseEvent event){
        Stage stage =(Stage) borderpanemain.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }
    @FXML
    private void borderpand_pressed(MouseEvent event){
        y = event.getSceneY();
        x = event.getScreenX();
    }

    @Override
    public void start(Stage primaryStage)  {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File headerimg3 = new File("images/icons8-timeline-96.png");
        Image topimg3 = new Image(headerimg3.toURI().toString());
        logobtnimg.setImage(topimg3);
        username.setText(DataShare.usefirstname +" "+ DataShare.userlastname);
        btndashboard.setText(DataShare.leftbaritems);
        btnevents.setText(DataShare.leftbaritems1);
        btncustomer.setText(DataShare.leftbaritems2);
        btninsights.setText(DataShare.leftbaritems3);
        btnsettings.setText(DataShare.leftbaritems4);
        btninsights1.setText(DataShare.leftbaritems5);
        btnsettings1.setText(DataShare.leftbaritems6);
    }

    public void btncancelonclick(ActionEvent event) {
        Stage stage = (Stage) closebtnimg.getScene().getWindow();
        stage.close();
    }

    public void leftbtnclicks(ActionEvent event) {
        if (event.getSource() == btndashboard){
            placelabel.setText(DataShare.leftbaritems);
        }else if (event.getSource() == btnevents){
            placelabel.setText(DataShare.leftbaritems1);
        }else if (event.getSource() == btncustomer){
            placelabel.setText(DataShare.leftbaritems2);
        }else if (event.getSource() == btninsights){
            placelabel.setText(DataShare.leftbaritems3);
        }else if (event.getSource() == btnsettings){
            placelabel.setText(DataShare.leftbaritems4);
        }else if (event.getSource() == btninsights1){
            placelabel.setText(DataShare.leftbaritems5);
        }else if (event.getSource() == btnsettings1){
            placelabel.setText(DataShare.leftbaritems6);
        }
    }

}


