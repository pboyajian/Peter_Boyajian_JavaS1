package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Coffee;
import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Roaster;

import java.util.List;

public interface RoasterDao {
    Roaster getRoaster(int id );
    List<Roaster> getAllRoasters();
    void deleteRoaster(int id);
    void updateRoaster(Roaster roaster);
    Roaster addRoaster(Roaster roaster);
}
