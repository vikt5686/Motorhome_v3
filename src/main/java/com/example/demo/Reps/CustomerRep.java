package com.example.demo.Reps;

import com.example.demo.Model.CustomerModel;
import com.example.demo.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRep implements CustomerInterfaceRep {

    private Connection conn;

    public CustomerRep(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public boolean create(CustomerModel customerModel) {

        try {
            PreparedStatement createStatement = conn.prepareStatement("INSERT INTO customers (id, firstName, lastName, cprNr, address, phoneNumber, email) VALUES (?, ?, ?, ?, ?, ?, ?)");

            createStatement.setInt(1, customerModel.getId());
            createStatement.setString(2, customerModel.getFirstName());
            createStatement.setString(3, customerModel.getLastName());
            createStatement.setLong(4, customerModel.getCpr());
            createStatement.setString(5, customerModel.getAddress());
            createStatement.setLong(6, customerModel.getPhoneNumber());
            createStatement.setString(7, customerModel.getEmail());
            createStatement.executeUpdate();

        }catch (SQLException e) {
            System.out.println(e);
        } return true;
    }

    @Override
    public CustomerModel read(int id) {
        CustomerModel customerToReturn = new CustomerModel();

        try{
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM customers WHERE id="+id);

            ResultSet rs = getSingleCustomer.executeQuery();

            while(rs.next()){
                customerToReturn = new CustomerModel();
                customerToReturn.setId(rs.getInt(1));
                customerToReturn.setFirstName(rs.getString(2));
                customerToReturn.setLastName(rs.getString(3));
                customerToReturn.setCpr(rs.getLong(4));
                customerToReturn.setAddress(rs.getString(5));
                customerToReturn.setPhoneNumber(rs.getLong(6));
                customerToReturn.setEmail(rs.getString(7));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }return customerToReturn;
    }



    @Override
    public List<CustomerModel> readAll() {
        List<CustomerModel> allCustomers = new ArrayList<>();

        try {

            PreparedStatement readAllStatement = conn.prepareStatement("SELECT * FROM customers");
            ResultSet rs = readAllStatement.executeQuery();
            while (rs.next()) {
                CustomerModel tempCustomer = new CustomerModel();
                tempCustomer.setId(rs.getInt(1));
                tempCustomer.setFirstName(rs.getString(2));
                tempCustomer.setLastName(rs.getString(3));
                tempCustomer.setCpr(rs.getLong(4));
                tempCustomer.setAddress(rs.getString(5));
                tempCustomer.setPhoneNumber(rs.getLong(6));
                tempCustomer.setEmail(rs.getString(7));
                allCustomers.add(tempCustomer);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return allCustomers;

    }



    @Override
    public boolean update (CustomerModel customerModel) {

        try{

            PreparedStatement updateStatement = conn.prepareStatement("UPDATE customers SET id = ?, firstName = ?, lastName = ?, cprNr = ?, address = ?, phoneNuber = ?, email = ?");

            updateStatement.setInt(1, customerModel.getId());
            updateStatement.setString(2, customerModel.getFirstName());
            updateStatement.setString(3,customerModel.getLastName());
            updateStatement.setLong(4, customerModel.getCpr());
            updateStatement.setString(5, customerModel.getAddress());
            updateStatement.setLong(6, customerModel.getPhoneNumber());
            updateStatement.setString(7,customerModel.getEmail());
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete (int id) {

        try{
            PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM customers WHERE id = ?");

            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
