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

    @FXML
    private TextField leftbaredit1;

    @FXML
    private TextField leftbaredit2;

    @FXML
    private TextField leftbaredit3;

    @FXML
    private TextField leftbaredit4;

    @FXML
    private TextField leftbaredit5;

    @FXML
    private TextField leftbaredit6;

    @FXML
    private TextField leftbaredit7;

    @FXML
    private Button leftbaredit;
    @FXML
    private Button leftbarsave;


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
        leftbaredit1.setText(DataShare.leftbaritems);
        btnevents.setText(DataShare.leftbaritems1);
        leftbaredit2.setText(DataShare.leftbaritems1);
        btncustomer.setText(DataShare.leftbaritems2);
        leftbaredit3.setText(DataShare.leftbaritems2);
        btninsights.setText(DataShare.leftbaritems3);
        leftbaredit4.setText(DataShare.leftbaritems3);
        btnsettings.setText(DataShare.leftbaritems4);
        leftbaredit5.setText(DataShare.leftbaritems4);
        btninsights1.setText(DataShare.leftbaritems5);
        leftbaredit6.setText(DataShare.leftbaritems5);
        btnsettings1.setText(DataShare.leftbaritems6);
        leftbaredit7.setText(DataShare.leftbaritems6);
    }

    public void btncancelonclick(ActionEvent event) {
        Stage stage = (Stage) closebtnimg.getScene().getWindow();
        stage.close();
    }

    public void leftbaredit(ActionEvent event) {
        leftbarsave.toFront();
        leftbaredit1.toFront();
        leftbaredit2.toFront();
        leftbaredit3.toFront();
        leftbaredit4.toFront();
        leftbaredit5.toFront();
        leftbaredit6.toFront();
        leftbaredit7.toFront();
        btndashboard.setVisible(false);
        btnevents.setVisible(false);
        btncustomer.setVisible(false);
        btninsights.setVisible(false);
        btnsettings.setVisible(false);
        btninsights1.setVisible(false);
        btnsettings1.setVisible(false);

    }
    public void leftbarsave(ActionEvent event) {
        btndashboard.setVisible(true);
        btnevents.setVisible(true);
        btncustomer.setVisible(true);
        btninsights.setVisible(true);
        btnsettings.setVisible(true);
        btninsights1.setVisible(true);
        btnsettings1.setVisible(true);
        leftbaredit.toFront();
        leftbaredit1.toBack();
        leftbaredit2.toBack();
        leftbaredit3.toBack();
        leftbaredit4.toBack();
        leftbaredit5.toBack();
        leftbaredit6.toBack();
        leftbaredit7.toBack();
        leftbar1 = leftbaredit1.getText();
        leftbar2 = leftbaredit2.getText();
        leftbar3 = leftbaredit3.getText();
        leftbar4 = leftbaredit4.getText();
        leftbar5 = leftbaredit5.getText();
        leftbar6 = leftbaredit6.getText();
        leftbar7 = leftbaredit7.getText();
        leftbardbupdate();
        getitemsfromdb();
        btndashboard.setText(DataShare.leftbaritems);
        leftbaredit1.setText(DataShare.leftbaritems);
        btnevents.setText(DataShare.leftbaritems1);
        leftbaredit2.setText(DataShare.leftbaritems1);
        btncustomer.setText(DataShare.leftbaritems2);
        leftbaredit3.setText(DataShare.leftbaritems2);
        btninsights.setText(DataShare.leftbaritems3);
        leftbaredit4.setText(DataShare.leftbaritems3);
        btnsettings.setText(DataShare.leftbaritems4);
        leftbaredit5.setText(DataShare.leftbaritems4);
        btninsights1.setText(DataShare.leftbaritems5);
        leftbaredit6.setText(DataShare.leftbaritems5);
        btnsettings1.setText(DataShare.leftbaritems6);
        leftbaredit7.setText(DataShare.leftbaritems6);
    }

    public void leftbardbupdate(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "UPDATE `accounts` SET `leftbaritems` ='"+leftbar1+"', `leftbaritems1` = '"+leftbar2+"', `leftbaritems2` = '"+leftbar3+"', `leftbaritems3` = '"+leftbar4+"', `leftbaritems4` = '"+leftbar5+"', `leftbaritems5` = '"+leftbar6+"', `leftbaritems6` = '"+leftbar7+"' WHERE username ='"+DataShare.currentloguser+"'  ";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void getitemsfromdb(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            Statement statement = connectiondb.createStatement();
            ResultSet leftitemSet = statement.executeQuery("SELECT leftbaritems, leftbaritems1, leftbaritems2, leftbaritems3, leftbaritems4, leftbaritems5, leftbaritems6 FROM accounts");

            while (leftitemSet.next()) {
                String col1 = leftitemSet.getString("leftbaritems");
                DataShare.leftbaritems = col1;
                String col2 = leftitemSet.getString("leftbaritems1");
                DataShare.leftbaritems1 = col2;
                String col3 = leftitemSet.getString("leftbaritems2");
                DataShare.leftbaritems2 = col3;
                String col4 = leftitemSet.getString("leftbaritems3");
                DataShare.leftbaritems3 = col4;
                String col5 = leftitemSet.getString("leftbaritems4");
                DataShare.leftbaritems4 = col5;
                String col6 = leftitemSet.getString("leftbaritems5");
                DataShare.leftbaritems5 = col6;
                String col7 = leftitemSet.getString("leftbaritems6");
                DataShare.leftbaritems6 = col7;


            }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
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


