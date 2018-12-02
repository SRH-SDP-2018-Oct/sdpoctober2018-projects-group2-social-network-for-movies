package com.SNM.app.insertdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDetails
{
    public Connection connection;
    public Statement statement;
    public ResultSet resultset;
    InsertDetails()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/socialnetworkformovies", "binitan", "themother");
            statement = connection.createStatement();
        } catch (Exception db_ex) {
            System.out.println("Connection Failed :" + db_ex);
        }
    }
}
