package com.example.demo.Reps;





import com.example.demo.Model.MotorhomeModel;

import java.util.List;

import java.util.List;

public interface MotorhomeInterfaceRep {


    List<MotorhomeModel> readAll();

    MotorhomeModel read(int id);

    boolean create(MotorhomeModel motorhomeModel);

    boolean updateMotorhome(MotorhomeModel motorhomeModel);



    boolean deleteMotorhome(int id);




}
