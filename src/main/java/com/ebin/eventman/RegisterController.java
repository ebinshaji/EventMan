package com.ebin.eventman;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

public class RegisterController extends Application implements Initializable {


    @FXML
    private Button regclose;
    @FXML
    private Button btnregister;

    @FXML
    private Label regststus;

    @FXML
    private ImageView regimgview;
    @FXML
    private TextField regfirstname;
    @FXML
    private TextField reglastname;
    @FXML
    private TextField regusername;

    @FXML
    private PasswordField regpassword;
    @FXML
    private PasswordField conformpassword;
    @FXML
    Hyperlink btnsigninwindow;

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



    public void initialize(URL url, ResourceBundle resourceBundle){
        File headerimg1 = new File("images/pho.jpeg");
        Image topimg1 = new Image(headerimg1.toURI().toString());
        regimgview.setImage(topimg1);
    }

    public void regclosebtnclick(ActionEvent event) {
        Stage stage = (Stage) regclose.getScene().getWindow();
        stage.close();
        createaccountwindow1();
    }

    public void signinhyperlink(ActionEvent event){
        Stage stage = (Stage) btnsigninwindow.getScene().getWindow();
        stage.close();
        createaccountwindow1();
    }
    public void createaccountwindow1(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 370, 490);
            Stage stage2 = new Stage();
            stage2.initStyle(StageStyle.UNDECORATED);
            stage2.setScene(scene);
            stage2.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void registerbuttononclick(ActionEvent e){

        if(regpassword.getText().equals(conformpassword.getText())){
            registeruser();
        }else{
            regststus.setText("Password not matching!");
        }


    }
    public void registeruser(){
        DatabaseConnection connectiondata = new DatabaseConnection();
        Connection connectdatabase = connectiondata.getConnection();

        String regfirstnamed = regfirstname.getText();
        String reglastnamed = reglastname.getText();
        String regusernamed = regusername.getText();
        String regpasswordd = regpassword.getText();

        String insertfields = "INSERT INTO `ebinshaji`.`accounts` (`firstname`, `lastname`, `username`, `password`) VALUES ('";
        String InsertValues =regfirstnamed + "','" + reglastnamed + "','" + regusernamed + "','" + regpasswordd + "')";
        String Inserttoregister = insertfields + InsertValues;

        try{
            Statement statement = connectdatabase.createStatement();
            statement.executeUpdate(Inserttoregister);
            regststus.setText("Registration Done!");
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
