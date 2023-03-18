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

public class LoginController implements Initializable {
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
                   createhomewindow();
               }else {
                   logstatus.setText("invalid login");
               }
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