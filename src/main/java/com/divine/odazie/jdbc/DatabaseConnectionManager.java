package com.divine.odazie.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
@author: Divine Odazie
@Class Description: This class handles the database connection to my postgres DATABASE.

 */

public class DatabaseConnectionManager {
    private final String url;
    private final Properties properties;

    public DatabaseConnectionManager(String host, String databaseName,
                                     String username, String password){
        this.url = "jdbc:postgresql://" + host + "/" + databaseName; // This is not the best form when dealing with production system
        this.properties = new Properties();
        this.properties.setProperty("user", username);
        this.properties.setProperty("password", password);

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url,this.properties);
    }

}
