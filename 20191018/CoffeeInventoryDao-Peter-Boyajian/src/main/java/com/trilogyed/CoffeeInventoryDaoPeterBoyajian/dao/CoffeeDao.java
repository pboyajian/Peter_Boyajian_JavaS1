package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Coffee;

import java.util.List;

public interface CoffeeDao {
    Coffee getCoffee(int id );
    List<Coffee> getAllCoffees();
    void deleteCoffee(int id);
    void updateCoffee(Coffee coffee);
    Coffee addCoffee(Coffee coffee);
    List<Coffee> getCoffeesByRoaster_id(int roaster_id);
    List<Coffee> getCoffeesByType(String type);
}
