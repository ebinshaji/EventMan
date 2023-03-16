package com.ebin.eventman;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaselink;

    public Connection getConnection(){
        String dbname = "ebinshaji";
        String dbuser = "root";
        String dbpassword = "Nimisha8@";
        String url = "jdbc:mysql://localhost/" + dbname;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, dbuser, dbpassword);
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaselink;
    }

}
