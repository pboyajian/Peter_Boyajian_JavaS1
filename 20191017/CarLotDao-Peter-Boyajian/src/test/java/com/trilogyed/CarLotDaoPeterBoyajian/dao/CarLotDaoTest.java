package com.trilogyed.CarLotDaoPeterBoyajian.dao;

import com.trilogyed.CarLotDaoPeterBoyajian.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarLotDaoTest {
    @Autowired
    private CarLotDao dao;

    @Before
    public void setUp() throws Exception {
        List<Car> cars=dao.getAllCars();
        cars.forEach(a->dao.deleteCar(a.getId()));
    }
    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        //add
        Car carToAdd =new Car("Honda","Fancy","2019","Matte black");
        //act
        Car carAfterAdding=dao.addCar(carToAdd);
        carToAdd.setId(carAfterAdding.getId());
        //assert
        assertEquals(carAfterAdding,carToAdd);
    }
    @Test
    public void shouldGetCarById(){
        //add
        Car carToAdd =new Car("Honda","Fancy","2019","Matte black");
        //act
        Car carAfterAdding=dao.addCar(carToAdd);
        carToAdd.setId(carAfterAdding.getId());
        int expectedId=carToAdd.getId();
        //assert
        assertEquals(dao.getCar(expectedId),carToAdd);
    }

    @Test
    public void shouldGetAllCar(){
        //add
        Car car1= dao.addCar(new Car("Honda","Fancy","2019","Matte black"));
        Car car2= dao.addCar(new Car("Honda","Fancy2","2019","Matte black"));
        Car car3=dao.addCar(new Car("Honda","Fancy3","2019","Matte black"));
        Car car4=dao.addCar(new Car("Honda","Fancy4","2019","Matte black"));
        Car car5=dao.addCar(new Car("Honda","Fancy5","2019","Matte black"));
        List<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        //act and assert
        assertEquals(dao.getAllCars(),cars);
    }

    @Test
    public void shouldDeleteCarById(){
        //add
        Car carToAdd =new Car("Honda","Fancy","2019","Matte black");
        //act
        Car carAfterAdding=dao.addCar(carToAdd);
        carToAdd.setId(carAfterAdding.getId());
        int expectedId=carToAdd.getId();
        dao.deleteCar(expectedId);
        //assert
        assertEquals(dao.getAllCars().size(),0);
    }

    @Test
    public void shouldUpdateCarById(){
        //add
        Car carToAdd =new Car("Honda","Fancy","2019","Matte black");
        Car carToUpdate =new Car("Hondaalksdfhian","Fancy","2019","Matte black");
        //act
        Car carAfterAdding=dao.addCar(carToAdd);
        carToAdd.setId(carAfterAdding.getId());
        int expectedId=carToAdd.getId();
        carToUpdate.setId(expectedId);
        dao.updateCar(carToUpdate);
        //assert
        assertEquals(carToUpdate,dao.getCar(expectedId));
    }

    @Test
    public void shouldGetAllCarByMake(){
        //add
        Car car1= dao.addCar(new Car("Honda","Fancy","2019","Matte black"));
        Car car2= dao.addCar(new Car("Honda","Fancy2","2019","Matte black"));
        Car car3=dao.addCar(new Car("Honda2","Fancy3","2019","Matte black"));
        Car car4=dao.addCar(new Car("Honda2","Fancy4","2019","Matte black"));
        Car car5=dao.addCar(new Car("Honda2","Fancy5","2019","Matte black"));
        List<Car> cars=new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        //act and assert
        assertEquals(cars,dao.getCarsByMake("Honda"));
    }


    @Test
    public void shouldGetAllCarByColor(){
        //add
        Car car1= dao.addCar(new Car("Honda","Fancy","2019","Matte black"));
        Car car2= dao.addCar(new Car("Honda","Fancy2","2019","Matte black"));
        Car car3=dao.addCar(new Car("Honda2","Fancy3","2019","Matte Chartreuse"));
        Car car4=dao.addCar(new Car("Honda2","Fancy4","2019","Matte Chartreuse"));
        Car car5=dao.addCar(new Car("Honda2","Fancy5","2019","Matte Chartreuse"));
        List<Car> cars=new ArrayList<>();
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        //act and assert
        assertEquals(cars,dao.getCarsByColor("Matte Chartreuse"));
    }
}