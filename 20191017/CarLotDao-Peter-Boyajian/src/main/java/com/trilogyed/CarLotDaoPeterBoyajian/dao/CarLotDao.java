package com.trilogyed.CarLotDaoPeterBoyajian.dao;

import com.trilogyed.CarLotDaoPeterBoyajian.model.Car;

import java.util.List;

public interface CarLotDao {
    Car getCar(int id );
    List<Car> getAllCars();
    void deleteCar(int id);
    void updateCar(Car Car);
    Car addCar(Car Car);
    List<Car> getCarsByMake(String make);
    List<Car> getCarsByColor(String color);
}
