package com.trilogyed.PeterBoyajianCarLotJpaRepository.dao;

import com.trilogyed.PeterBoyajianCarLotJpaRepository.dto.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarLotTest {
@Autowired
    CarLot carLot;

    @Before
    public void setUp() throws Exception{
        carLot.deleteAll();
    }

    @Test
    public void shouldCreate(){
        carLot.deleteAll();
        List<Car> cars=carLot.findAll();
        assertEquals(0,cars.size());
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        carLot.save(car);
        List<Car> carsAfterAdding=carLot.findAll();
        assertEquals(1,carsAfterAdding.size());
    }
@Test
    public void shouldGetAll(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2019");
        carLot.save(car2);
        List<Car> carsWeAreAdding=new ArrayList<>();
        carsWeAreAdding.add(car);
        carsWeAreAdding.add(car2);
        List<Car> carsInDb=carLot.findAll();
        assertEquals(carsWeAreAdding.size(),carsInDb.size());
    }

    @Test
    public void shouldGetById(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        Car carAfterAdding=carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2019");
        Car car2AfterAdding= carLot.save(car2);
        Car carFound=carLot.findById( carAfterAdding.getId()).get();
        Car car2Found=carLot.findById( car2AfterAdding.getId()).get();
        assertEquals(car,carFound);
        assertEquals(car2,car2Found);
    }

    @Test
    public void shouldUpdate(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        Car carAfterAdding=carLot.save(car);
        Car carUpdated=carAfterAdding;
        carUpdated.setColor("Black");
        carLot.save(carUpdated);
        assertEquals(carUpdated,carLot.findById( carAfterAdding.getId()).get());
        List<Car> carsAfterAdding=carLot.findAll();
        assertEquals(1,carsAfterAdding.size());
    }

    @Test
    public void shouldDeleteById(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        Car carAfterAdding=carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2019");
        carLot.save(car2);
        carLot.deleteById(carAfterAdding.getId());
        assertEquals(1,carLot.findAll().size());
    }

    @Test
    public void shouldFindAllByMake(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2018");
        carLot.save(car2);
        Car car3=new Car();
        car3.setColor("Green");
        car3.setMake("Not Honda");
        car3.setModel("CRV");
        car3.setYear("2019");
        carLot.save(car2);
        List<Car> hondas=new ArrayList<>();
        hondas.add(car);
        hondas.add(car2);
        List<Car> carsFoundByMake=carLot.findByMake("Honda");
        assertEquals(hondas,carsFoundByMake);
    }
    @Test
    public void shouldFindAllByColor(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2018");
        carLot.save(car2);
        Car car3=new Car();
        car3.setColor("Not Green");
        car3.setMake("Not Honda");
        car3.setModel("CRV");
        car3.setYear("2019");
        carLot.save(car2);
        List<Car> greenCars=new ArrayList<>();
        greenCars.add(car);
        greenCars.add(car2);
        List<Car> carsFoundByColor=carLot.findByColor("Green");
        assertEquals(greenCars,carsFoundByColor);
    }

    @Test
    public void shouldFindAllByMakeAndColor(){
        Car car=new Car();
        car.setColor("Green");
        car.setMake("Honda");
        car.setModel("CRV");
        car.setYear("2019");
        carLot.save(car);
        Car car2=new Car();
        car2.setColor("Green");
        car2.setMake("Honda");
        car2.setModel("CRV");
        car2.setYear("2018");
        carLot.save(car2);
        Car car3=new Car();
        car3.setColor("Not Green");
        car3.setMake("Not Honda");
        car3.setModel("CRV");
        car3.setYear("2019");
        carLot.save(car2);
        List<Car> greenHondas=new ArrayList<>();
        greenHondas.add(car);
        greenHondas.add(car2);
        List<Car> carsFoundByMakeAndColor=carLot.findByMakeAndColor("Honda","Green");
        assertEquals(greenHondas,carsFoundByMakeAndColor);
    }
}