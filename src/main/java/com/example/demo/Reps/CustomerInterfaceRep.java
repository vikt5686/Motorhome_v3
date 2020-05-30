package com.example.demo.Reps;

import com.example.demo.Model.CustomerModel;

import java.util.List;

public interface CustomerInterfaceRep {

    public boolean create(CustomerModel customerModel);

    public CustomerModel read(int id);

    public List<CustomerModel> readAll();

    public boolean update(CustomerModel customerModel);

    public boolean delete(int id);
}
