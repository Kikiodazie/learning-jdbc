package com.divine.odazie.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
@author: Divine Odazie
@Class Description: This class executes SQL statements using JDBC.

 */
public class JDBCExecutor {
    public static void main(String[] args) {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "akachukwu123");

        try{
            Connection connection = databaseConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}