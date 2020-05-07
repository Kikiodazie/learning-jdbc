package com.divine.odazie.jdbc;

import com.divine.odazie.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO extends DataAccessObject<Customer> {
    private static final String INSERT = "INSERT INTO customer (first_name, last_name, " +
            "email, phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Because of JDBC we have 8 question marks representing each value of the customer

    private static final String GET_ONE = "SELECT customer_id, first_name, last_name," +
            "email, phone, address, city, state, zipcode FROM customer WHERE customer_id=?";

    public CustomerDAO(Connection connection){
        super(connection);
    }

    private static final String UPDATE = "UPDATE customer SET first_name= ?, last_name= ?, " +
            "email= ?, phone= ?, address= ?, city= ?, state= ?, zipcode= ? WHERE customer_id = ?";

    /*
    Find a customer by Id value
     */
    @Override
    public Customer findById(long id) {
        Customer customer = new Customer();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE)){
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                customer.setId(resultSet.getLong("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setZipCode(resultSet.getString("zipcode"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer dto) {
        Customer customer = null;

        try (PreparedStatement statement = this.connection.prepareStatement((UPDATE)) ){
            createUpdateStatementBoilerplate(dto, statement);
            statement.setLong(9, dto.getId());
            statement.execute();
            customer = this.findById(dto.getId());


        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return customer;
    }

    private void createUpdateStatementBoilerplate(Customer dto, PreparedStatement statement) throws SQLException {
        statement.setString(1, dto.getFirstName());
        statement.setString(2, dto.getLastName());
        statement.setString(3, dto.getEmail());
        statement.setString(4, dto.getPhone());
        statement.setString(5, dto.getAddress());
        statement.setString(6, dto.getCity());
        statement.setString(7, dto.getState());
        statement.setString(8, dto.getZipCode());
    }
    /*
    Creates a new customer and adds to the database;
     */

    @Override
    public Customer create(Customer dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT)){
            createUpdateStatementBoilerplate(dto, statement);
            statement.execute();
            int id = this.getLastVal(CUSTOMER_SEQUENCE);
            return this.findById(id);

        }catch (SQLException e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    @Override
    public void delete(long id) {

    }
}
