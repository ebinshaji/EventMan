package com.ebin.eventman;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import java.io.IOException;
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
    private Pane paneaddemployee;

    @FXML
    private Pane panesettings;

    @FXML
    private Label placelabel;

    @FXML
    private Pane placeback;
    @FXML
    private Pane employees;
    @FXML
    private Pane usereditadd;

    @FXML
    private Pane custedit;
    @FXML
    private Pane cuadd;
    @FXML
    private Pane customers;

    @FXML
    private ImageView logobtnimg;

    @FXML
    private Button closebtnimg;

    @FXML
    private BorderPane borderpanemain;

    @FXML
    public Label username;
    @FXML
    public Label wouseridlabel;
    @FXML
    public Label woaddress;
    @FXML
    public Label addresswo;
    @FXML
    public Label woaddindi;

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

    @FXML
    private TextField woaddressedit;

    @FXML
    private TextField woaddressedit1;

    @FXML
    private TextField woageedit;
    @FXML
    private TextField woageedit1;

    @FXML
    private TextField wodepedit;
    @FXML
    private TextField wodepedit1;

    @FXML
    private TextField wonameedit;
    @FXML
    private TextField wonameedit1;

    @FXML
    private TextField wopasswordedit;
    @FXML
    private TextField wopasswordedit1;

    @FXML
    private TextField wophonedit;
    @FXML
    private TextField wophonedit1;

    @FXML
    private TextField wosalaryedit;
    @FXML
    private TextField wosalaryedit1;

    @FXML
    private TextField wousernameedit;
    @FXML
    private TextField wousernameedit1;

    @FXML
    private TextField cunameedit;
    @FXML
    private TextField cuadderessedit;

    @FXML
    private TextField cuactdactedit;
    @FXML
    private TextField cuemailedit;

    @FXML
    private TextField cuphoneedit;
    @FXML
    private TextField cufromedit;


    @FXML
    private TextField cunameadd;
    @FXML
    private TextField cuadderessadd;

    @FXML
    private TextField cuactdactadd;
    @FXML
    private TextField cuemailadd;

    @FXML
    private TextField cuphonadd;
    @FXML
    private TextField cufromadd;


    private double x,y=0;
    public String leftbar1;
    public String leftbar2;
    public String leftbar3;
    public String leftbar4;
    public String leftbar5;
    public String leftbar6;
    public String leftbar7;


/*0803*/



    @FXML
    private Button workersave;
    @FXML
    private Button workeredit;
    @FXML
    private Button workeradd;
    @FXML
    private Button workerdelete;
    @FXML
    private Button cuupdatebtn;
    @FXML
    private Button cucancelbtn;
    @FXML
    private Button cuupdataddbtn;
    @FXML
    private Button cucanceladdbtn;


    @FXML
    private VBox vboworkerlist;
    @FXML
    private VBox wotaskvbox;
    @FXML
    private VBox clientvbox;





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
        workertableview();
        clientlist();
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
    public void useraddeditcancel(){
        usereditadd.toBack();
        employees.toFront();
        placelabel.setText("New Employee");
        vboworkerlist.getChildren().clear();
        workertableview();
    }

    public void addemployee(){
        paneaddemployee.toFront();
        placelabel.setText(DataShare.leftbaritems3);
    }
    public void addempbtn(){


        DatabaseConnection connectiondata = new DatabaseConnection();
        Connection connectdatabase = connectiondata.getConnection();

        String name = wonameedit1.getText();
        String address = woaddressedit1.getText();
        String dep = wodepedit1.getText();
        String pass = wopasswordedit1.getText();
        String username = wousernameedit1.getText();

        Integer ag = Integer.parseInt(woageedit1.getText());
        Integer pho = Integer.parseInt(wophonedit1.getText());
        Integer sal = Integer.parseInt(wosalaryedit1.getText());

        Integer age = ag;
        Integer phone = pho;
        Integer salary = sal;

        String insertfields = "INSERT INTO `ebinshaji`.`workers` (`usernamewo`, `name1`, `age`, `salary` ,`department`, `passwordwo`, `address`, `phone`) VALUES ('";
        String InsertValues = username + "','" + name + "','" + age + "','" + salary + "','"+ dep + "','" + pass + "','" + address + "','" + phone + "')";
        String Inserttoregister = insertfields + InsertValues;
        woaddindi.setText("Employee Added Successfully");
        String createwotasktable = "CREATE TABLE IF NOT EXISTS `ebinshaji`.`"+username+"` (`taskid` INT NOT NULL AUTO_INCREMENT, `taskhead` VARCHAR(450) NOT NULL, `taskdesc` VARCHAR(450) NOT NULL, `startdate` DATE NOT NULL, `enddate` DATE NOT NULL, `progress` INT(3) NOT NULL, PRIMARY KEY (`taskid`, `taskhead`), UNIQUE INDEX `username_UNIQUE` (`taskid` ASC) VISIBLE) ENGINE = InnoDB;";

        try{
            Statement statement = connectdatabase.createStatement();
            statement.executeUpdate(Inserttoregister);
            statement.executeUpdate(createwotasktable);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    public void workerlistupdate(){
        //UPDAATING WORKER ITEM
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "UPDATE ebinshaji.workers SET usernamewo = '"+wousernameedit.getText()+"',name1 = '"+wonameedit.getText()+"',age = '"+Integer.parseInt(woageedit.getText())+"',salary = '"+Integer.parseInt(wosalaryedit.getText())+"', department = '"+wodepedit.getText()+"',passwordwo = '"+wopasswordedit.getText()+"',address = '"+woaddressedit.getText()+"',phone = '"+Integer.parseInt(wophonedit.getText())+"' WHERE usernamewo = '"+DataShare.selectedworker+"';";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        vboworkerlist.getChildren().clear();
        workertableview();
        employees.toFront();
    }
    public void workertableview(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            Statement statement = connectiondb.createStatement();
            ResultSet workerslist = statement.executeQuery("SELECT * FROM workers");

            while (workerslist.next()) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listitems.fxml"));
                Node listItemNode = fxmlLoader.load();

                Label name = (Label) listItemNode.lookup("#workername");
                Label label2 = (Label) listItemNode.lookup("#workerdep");
                Label label3 = (Label) listItemNode.lookup("#workerage");
                Label label4 = (Label) listItemNode.lookup("#workersalary");
                Label label5 = (Label) listItemNode.lookup("#workerid");
                Label pas = (Label) listItemNode.lookup("#wopas");
                Label wophone = (Label) listItemNode.lookup("#wophone");
                Label woid = (Label) listItemNode.lookup("#woid");
                Label woaddress = (Label) listItemNode.lookup("#woaddress");
                HBox listitem = (HBox) listItemNode.lookup("#hbox");
                Button deletebu = (Button) listItemNode.lookup("#btndelete");
                Button btnedit = (Button) listItemNode.lookup("#btnedit");


                name.setText( workerslist.getString("name1"));
                pas.setText( workerslist.getString("passwordwo"));
                label2.setText(workerslist.getString("department"));
                woid.setText(workerslist.getString("usernamewo"));
                woaddress.setText(workerslist.getString("address"));
                label3.setText(String.valueOf(workerslist.getInt("age")));
                label4.setText(String.valueOf(workerslist.getInt("salary")));
                wophone.setText(String.valueOf(workerslist.getInt("phone")));

                DataShare.workercount = DataShare.workercount + 1;
                label5.setText(String.valueOf(DataShare.workercount));

                // Add the listItemNode to the VBox
                vboworkerlist.getChildren().add(listItemNode);

                VBox.setMargin(listItemNode, new Insets(15, 3, 10, 8)); // top, right, bottom, left





                listitem.setOnMouseEntered(event -> {
                    listitem.setStyle("-fx-border-color:  linear-gradient(to right, rgb(200, 60, 255) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(200, 60, 255) 100%);");
                });
                listitem.setOnMouseExited(event -> {
                    listitem.setStyle("-fx-border-color:  linear-gradient(to right, rgba(17, 255, 0, 0.59) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(17, 255, 0, 0.59) 100%);");
                });
                listitem.setOnMouseClicked(event -> {
                    DataShare.selectedworker = woid.getText();
                    wouseridlabel.setText(DataShare.selectedworker);
                    DataShare.wodep = label2.getText();
                    DataShare.woname = name.getText();
                    DataShare.woage = Integer.parseInt(label3.getText());
                    DataShare.wosalary = Integer.parseInt(label4.getText());
                    DataShare.wophone = Integer.parseInt(wophone.getText());
                    DataShare.woaddress1 = woaddress.getText();
                    DataShare.wopas = pas.getText();
                    String formattedAddress = DataShare.woaddress1.replaceAll(",", "\n");
                    addresswo.setText(formattedAddress + "\n" + DataShare.wophone);
                    listitem.setStyle("-fx-border-color:  linear-gradient(to right, rgb(227, 227, 227) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(227, 227, 227) 100%);");
                    wotaskvbox.getChildren().clear();
                    workertaskview();
                });

                btnedit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        wonameedit.setText(DataShare.woname);
                        woaddressedit.setText(DataShare.woaddress1);
                        wodepedit.setText(DataShare.wodep);
                        wopasswordedit.setText(DataShare.wopas);
                        wousernameedit.setText(DataShare.selectedworker);
                        woageedit.setText(String.valueOf(DataShare.woage));
                        wophonedit.setText(String.valueOf(DataShare.wophone));
                        wosalaryedit.setText(String.valueOf(DataShare.wosalary));
                        placelabel.setText("Edit Employee");
                        usereditadd.toFront();
                        DataShare.workercount = 0;
                    }
                });
                deletebu.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        deletewo();
                        DataShare.workercount = 0;
                    }
                });

            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    //worker task  start


    public void workertaskview() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb = connection.getConnection();

        try {
            Statement statement = connectiondb.createStatement();
            ResultSet tasklist = statement.executeQuery("SELECT * FROM " + DataShare.selectedworker + "");

            while (tasklist.next()) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("wotask.fxml"));
                Node listItemNode = fxmlLoader.load();

                Label title = (Label) listItemNode.lookup("#tasktitle");
                Label desc = (Label) listItemNode.lookup("#taskdesc");
                Label startdate = (Label) listItemNode.lookup("#taskstart");
                Label enddate = (Label) listItemNode.lookup("#taskend");
                ProgressBar progress = (ProgressBar) listItemNode.lookup("#taskprogress");

                double value = tasklist.getDouble("progress");
                double progressval = value / 100.0; // Convert the value to progress between 0.0 and 1.0
                progress.setProgress(progressval);

                progress.setStyle("-fx-accent: green;");

                title.setText(tasklist.getString("taskhead"));
                desc.setText(tasklist.getString("taskdesc"));
                startdate.setText(tasklist.getString("startdate"));
                enddate.setText(tasklist.getString("enddate"));

                // Add the listItemNode to the VBox

                wotaskvbox.getChildren().add(listItemNode);
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    //end of wo task


    //custumer edit

    public void clientupdate(){
        //UPDAATING client item
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "UPDATE ebinshaji.client SET clname = '"+cunameedit.getText()+"',clemail = '"+cuemailedit.getText()+"',phone = '"+Integer.parseInt(cuphoneedit.getText())+"',ACTDAC = '"+Integer.parseInt(cuactdactedit.getText())+"',memsince = '"+cufromedit.getText()+"',address = '"+cuadderessedit.getText()+"' WHERE clemail = '"+DataShare.cuemail+"';";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        clientvbox.getChildren().clear();
        clientlist();
        customers.toFront();
    }


    public void cancelbtnclick(){
        clientvbox.getChildren().clear();
        clientlist();
        customers.toFront();
    }
    //end customeredit
    //CLIENT TASK
    public void clientlist() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb = connection.getConnection();

        try {
            Statement statement = connectiondb.createStatement();
            ResultSet tasklist = statement.executeQuery("SELECT * FROM ebinshaji.client");

            while (tasklist.next()) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cllist.fxml"));
                Node listItemNode = fxmlLoader.load();

                Label name = (Label) listItemNode.lookup("#cuname");
                Label email = (Label) listItemNode.lookup("#cuemail");
                Label address = (Label) listItemNode.lookup("#cuaddress");
                Label phone = (Label) listItemNode.lookup("#cuphone");
                Label actdact = (Label) listItemNode.lookup("#cuactdact");
                Label memsince = (Label) listItemNode.lookup("#cumemdate");
                Button cueditbtn = (Button) listItemNode.lookup("#cuedit");
                Button cudel = (Button) listItemNode.lookup("#cudelete");
                Pane cuitem = (Pane) listItemNode.lookup("#cllist");



                name.setText(tasklist.getString("clname"));
                email.setText(tasklist.getString("clemail"));
                address.setText(tasklist.getString("address"));
                memsince.setText(tasklist.getString("memsince"));
                phone.setText(String.valueOf(tasklist.getInt("phone")));
                if(tasklist.getInt("ACTDAC") == 1){
                    actdact.setText("ACTIVE");
                }else{
                    actdact.setText("DEACTIVE");
                }

                // Add the listItemNode to the VBox

                clientvbox.getChildren().add(listItemNode);


                VBox.setMargin(listItemNode, new Insets(15, 3, 10, 8)); // top, right, bottom, left


                cuitem.setOnMouseClicked(event -> {
                    DataShare.cuname = name.getText();
                    DataShare.cuaddress = address.getText();
                    DataShare.cuemail = email.getText();
                    DataShare.cufrmdate = memsince.getText();

                    DataShare.cuphone = Integer.parseInt(phone.getText());
                    if(actdact.getText() == "ACTIVE"){
                        DataShare.cuactdact = 1;
                    }else{
                        DataShare.cuactdact = 2;
                    }


                    cuitem.setStyle("-fx-border-color:  linear-gradient(to right, rgb(227, 227, 227) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(227, 227, 227) 100%);");
                });
                cuitem.setOnMouseEntered(event -> {
                    cuitem.setStyle("-fx-border-color:  linear-gradient(to right, rgb(200, 60, 255) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(200, 60, 255) 100%);");
                });
                cuitem.setOnMouseExited(event -> {
                    cuitem.setStyle("-fx-border-color:  linear-gradient(to right, rgba(17, 255, 0, 0.59) 0%, rgba(42, 70, 73, 0.24) 50%, rgb(17, 255, 0, 0.59) 100%);");
                });

                cueditbtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        cunameedit.setText(DataShare.cuname);
                        cuadderessedit.setText(DataShare.cuaddress);
                        cuemailedit.setText(DataShare.cuemail);
                        cufromedit.setText(DataShare.cufrmdate);
                        cuactdactedit.setText(String.valueOf(DataShare.cuactdact));
                        cuphoneedit.setText(String.valueOf(DataShare.cuphone));
                        custedit.toFront();
                    }
                });
                cudel.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        deleteclient();
                    }
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    //END CLIENT TASK

//start client add

    public void newbtnclick(){
        cuadd.toFront();

    }

    public void clientadd(){
        cuadd.toFront();
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "insert into ebinshaji.client (clname,ACTDAC,address, clemail,memsince,phone)values ('"+cunameadd.getText()+"',"+Integer.parseInt(cuactdactadd.getText())+",'"+cuadderessadd.getText()+"','"+cuemailadd.getText()+"','"+cufromadd.getText()+"',"+Integer.parseInt(cuphonadd.getText())+");";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        vboworkerlist.getChildren().clear();
        workertableview();


    }

    //end client add
    public void deletewo(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "DELETE FROM ebinshaji.workers WHERE usernamewo = '"+DataShare.selectedworker+"';";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        vboworkerlist.getChildren().clear();
        workertableview();
    }

    public void deleteclient(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectiondb  = connection.getConnection();

        try{
            String updateQuery  = "DELETE FROM ebinshaji.client WHERE clemail = '"+DataShare.cuemail+"';";
            Statement statement = connectiondb.createStatement();
            int queryResult = statement.executeUpdate(updateQuery);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        vboworkerlist.getChildren().clear();
        workertableview();
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
            panedashboard.toFront();
            placelabel.setText(DataShare.leftbaritems);
        }else if (event.getSource() == btnevents){
            employees.toFront();
            placelabel.setText(DataShare.leftbaritems1);
        }else if (event.getSource() == btncustomer){
            customers.toFront();
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


