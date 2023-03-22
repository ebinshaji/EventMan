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

    private double x,y=0;

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
    public void start(Stage primaryStage) throws Exception {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File headerimg3 = new File("images/icons8-timeline-96.png");
        Image topimg3 = new Image(headerimg3.toURI().toString());
        logobtnimg.setImage(topimg3);
    }

    public void btncancelonclick(ActionEvent event) {
        Stage stage = (Stage) closebtnimg.getScene().getWindow();
        stage.close();
    }

    public void leftbtnclicks(ActionEvent event) {
        if (event.getSource() == btndashboard){
            placelabel.setText("☴ Dashboard");
        }else if (event.getSource() == btnevents){
            placelabel.setText("♔ Events");
        }else if (event.getSource() == btncustomer){
            placelabel.setText("♥ Customer");
        }else if (event.getSource() == btninsights){
            placelabel.setText("ↂ Insights");
        }else if (event.getSource() == btnsettings){
            placelabel.setText("⚒ Settings");
        }
    }
}
