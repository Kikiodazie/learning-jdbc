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
            OrderDAO orderDAO = new OrderDAO(connection);

            //Finding Order by ID

            Order order = orderDAO.findById(1000);
            System.out.println(order);




/*
  IMPLEMENTING the entire CRUD operations
            Customer customer = new Customer();
            customer.setFirstName("BEKU");
            customer.setLastName("Ezege");
            customer.setEmail("bekuExeger@gmail.com");
            customer.setPhone("090239281931");
            customer.setAddress("1234 RING Road");
            customer.setCity("Port-Harcourt");
            customer.setState("Rivers State");
            customer.setZipCode("500172");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("beku@gmail.com");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());


*/




/*
         DELETE CUSTOMER BY ID
            Customer customer = customerDAO.findById(10001);
            System.out.println("First Name: " + customer.getFirstName() +
                    " \nLast name: " + customer.getLastName() + " \nemail: " + customer.getEmail());
            customer.setEmail("kOdazie2342@gmail.com");


            customer = customerDAO.update(customer);
            System.out.println("First Name: " + customer.getFirstName() +
                    " \nLast name: " + customer.getLastName() + " email: " + customer.getEmail());
*/

/*
          FINDS CUSTOMER WITH CUSTOMER ID
            Customer customer = customerDAO.findById(1000);
            System.out.println("First Name: " + customer.getFirstName() +
                    " \nLast name: " + customer.getLastName());
*/

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
