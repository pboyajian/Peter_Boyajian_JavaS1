package com.trilogyed.motoinventoryjdbctemplate.dao;

import com.trilogyed.motoinventoryjdbctemplate.model.Motorcycle;

import java.util.List;

public interface MotoInventoryDao {
    Motorcycle getMotorcycle(int id );
    List<Motorcycle> getAllMotorcycles();
    void deleteMotorcycle(int id);
    void updateMotorcycle(Motorcycle motorcycle);
    Motorcycle addMotorcycle(Motorcycle motorcycle);
    List<Motorcycle> getMotorcyclesByMake(String make);

}
