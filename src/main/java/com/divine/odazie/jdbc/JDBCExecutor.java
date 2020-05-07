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
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(1000);
            System.out.println("First Name: " + customer.getFirstName() +
                    " \nLast name: " + customer.getLastName());

/*
         ADDS A NEW CUSTOMER TO THE DATABASE
            customer.setFirstName("aja");
            customer.setLastName("John");
            customer.setEmail("Kiki.odazie17232@yahoo.com");
            customer.setPhone("0399203920");
            customer.setAddress("1234 Main Road");
            customer.setCity("Port-Harcourt");
            customer.setState("Rivers State");
            customer.setZipCode("500172");
            customerDAO.create(customer);
*/


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
