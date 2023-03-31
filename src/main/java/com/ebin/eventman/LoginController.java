package com.ebin.eventman;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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

public class LoginController extends Application implements Initializable {
    @FXML
    private Button btncancel;


    @FXML
    private Button btnlogin;

    @FXML
    private Label logstatus;

    @FXML
    private ImageView headerimgban;
    @FXML
    private TextField txtusername;
    @FXML
    private PasswordField txtpassword;

    @FXML
    Hyperlink btnsignup;

    @FXML
    private BorderPane borderpaineid;


    private double x,y=0;


    @FXML
    private void borderpand_dragged(MouseEvent event){
        Stage stage =(Stage) borderpaineid.getScene().getWindow();
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
    public void initialize(URL url, ResourceBundle resourceBundle){
        File headerimg = new File("images/topimage.png");
        Image topimg = new Image(headerimg.toURI().toString());
        headerimgban.setImage(topimg);
    }

    public void loginbuttononclick(ActionEvent event) {
        logstatus.setText("  ");
        if (txtusername.getText().isBlank() == false && txtpassword.getText().isBlank() == false) {
            validatelogin();
        } else {
            logstatus.setText("Enter your User Id and Password");
        }
    }
    public void signuphyperlink(ActionEvent event){
        Stage stage = (Stage) btnsignup.getScene().getWindow();
        stage.close();
        createaccountwindow();
    }


   public void btncancelonclick(ActionEvent event) {
       Stage stage = (Stage) btncancel.getScene().getWindow();
       stage.close();
   }


   public void validatelogin(){
        DatabaseConnection connection = new DatabaseConnection();
       Connection connectiondb  = connection.getConnection();

       String verifylogin = "SELECT count(1) FROM accounts WHERE username = '" + txtusername.getText() + "'AND password ='" + txtpassword.getText() +"'";
       try{
           Statement statement = connectiondb.createStatement();
           ResultSet queryResult = statement.executeQuery(verifylogin);

           while(queryResult.next()){
               if (queryResult.getInt(1) == 1){
                   logstatus.setText("success");
                   String currentusertext = txtusername.getText();
                   DataShare.currentloguser = currentusertext;
                   getitemsfromdb();
                   createhomewindow();
                   Stage stage = (Stage) btnlogin.getScene().getWindow();
                   stage.close();
               }else {
                   logstatus.setText("invalid login");
               }
           }
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
            ResultSet leftitemSet = statement.executeQuery("SELECT firstname, lastname, leftbaritems, leftbaritems1, leftbaritems2, leftbaritems3, leftbaritems4, leftbaritems5, leftbaritems6 FROM accounts");

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

                String col8 = leftitemSet.getString("firstname");
                DataShare.usefirstname = col8;
                String col9 = leftitemSet.getString("lastname");
                DataShare.userlastname = col9;


            }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



    public void createaccountwindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 477, 596);
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            stage1.setScene(scene);
            stage1.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createhomewindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("homewindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1271, 668);
            Stage stage3 = new Stage();
            stage3.initStyle(StageStyle.UNDECORATED);
            stage3.setScene(scene);
            stage3.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}