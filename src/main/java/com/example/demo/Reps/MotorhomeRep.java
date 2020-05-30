package com.example.demo.Reps;


import com.example.demo.Model.CustomerModel;
import com.example.demo.Model.MotorhomeModel;
import com.example.demo.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRep implements MotorhomeInterfaceRep {

    private Connection conn;
    public MotorhomeRep(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }



    @Override
    public List<MotorhomeModel> readAll() {
        List<MotorhomeModel> allCustomers = new ArrayList<>();

        try {

            PreparedStatement readAllStatement = conn.prepareStatement("SELECT * FROM motorhomes");
            ResultSet rs = readAllStatement.executeQuery();
            while (rs.next()) {
                MotorhomeModel tempMotorhome = new MotorhomeModel();
                tempMotorhome.setId(rs.getInt(1));
                tempMotorhome.setManufacturer(rs.getString(2));
                tempMotorhome.setModel(rs.getString(3));
                tempMotorhome.setYear(rs.getInt(4));
                tempMotorhome.setSeating(rs.getInt(5));
                tempMotorhome.setBeds(rs.getInt(6));

                allCustomers.add(tempMotorhome);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return allCustomers;

    }



    @Override
    public MotorhomeModel read(int id) {
        MotorhomeModel motorhomeToReturn = new MotorhomeModel();

        try{
            PreparedStatement getSingleMotorhome = conn.prepareStatement("SELECT * FROM motorhomes WHERE id="+id);

            ResultSet rs = getSingleMotorhome.executeQuery();

            while(rs.next()){
                motorhomeToReturn = new MotorhomeModel();
                motorhomeToReturn.setId(rs.getInt(1));
                motorhomeToReturn.setManufacturer(rs.getString(2));
                motorhomeToReturn.setModel(rs.getString(3));
                motorhomeToReturn.setYear(rs.getInt(4));
                motorhomeToReturn.setSeating(rs.getInt(5));
                motorhomeToReturn.setBeds(rs.getInt(6));

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }return motorhomeToReturn;
    }


    @Override
    public boolean create(MotorhomeModel motorhomeModel) {

        try {
            PreparedStatement createStatement = conn.prepareStatement("INSERT INTO motorhomes (id, manufacturer, model, year, seating, beds, mileage) VALUES (?, ?, ?, ?, ?, ?, ?)");

            createStatement.setInt(1, motorhomeModel.getId());
            createStatement.setString(2, motorhomeModel.getManufacturer());
            createStatement.setString(3, motorhomeModel.getModel());
            createStatement.setInt(4, motorhomeModel.getYear());
            createStatement.setInt(5, motorhomeModel.getSeating());
            createStatement.setInt(6, motorhomeModel.getBeds());
            createStatement.setDouble(7, motorhomeModel.getMileage());

            createStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }


        @Override
        public boolean updateMotorhome(MotorhomeModel motorhomeModel) {

            try{

                PreparedStatement updateStatement = conn.prepareStatement("UPDATE motorhomes SET id = ?, manufacturer = ?, model = ?, year = ?, seating = ?, beds = ?, mileage = ?");

                updateStatement.setInt(1, motorhomeModel.getId());
                updateStatement.setString(2, motorhomeModel.getManufacturer());
                updateStatement.setString(3,motorhomeModel.getModel());
                updateStatement.setInt(4, motorhomeModel.getYear());
                updateStatement.setInt(5, motorhomeModel.getSeating());
                updateStatement.setInt(6, motorhomeModel.getBeds());
                updateStatement.setDouble(7, motorhomeModel.getMileage());

                updateStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }



    @Override
    public boolean deleteMotorhome (int id) {

        try{
            PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM motorhomes WHERE id = ?");

            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    }



