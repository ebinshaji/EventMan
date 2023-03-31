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
        username.setText(DataShare.currentloguser);
    }

    public void btncancelonclick(ActionEvent event) {
        Stage stage = (Stage) closebtnimg.getScene().getWindow();
        stage.close();
    }

    public void leftbtnclicks(ActionEvent event) {
        if (event.getSource() == btndashboard){
            placelabel.setText("☴ Dashboard");
        }else if (event.getSource() == btnevents){
            placelabel.setText("♘ Events");
        }else if (event.getSource() == btncustomer){
            placelabel.setText("☎ Customer");
        }else if (event.getSource() == btninsights){
            placelabel.setText("⛳ Insights");
        }else if (event.getSource() == btnsettings){
            placelabel.setText("⚒ Settings");
        }else if (event.getSource() == btninsights1){
            placelabel.setText("⛳ Insights");
        }else if (event.getSource() == btnsettings1){
            placelabel.setText("⚒ Settings");
        }
    }



    public void getleftbaritems(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try {

        }catch(Exception e){
        e.printStackTrace();
        e.getCause();
        }
    }
}

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckNull {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDatabase", "username", "password");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from table_name");
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    str1 = rs.getString(1);
                }
                if (rs.getString(2) != null) {
                    str2 = rs.getString(2);
                }
                if (rs.getString(3) != null) {
                    str3 = rs.getString(3);
                }
                if (rs.getString(4) != null) {
                    str4 = rs.getString(4);
                }
                if (rs.getString(5) != null) {
                    str5 = rs.getString(5);
                }
                if (rs.getString(6) != null) {
                    str6 = rs.getString(6);
                }
                if (rs.getString(7) != null) {
                    str7 = rs.getString(7);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
