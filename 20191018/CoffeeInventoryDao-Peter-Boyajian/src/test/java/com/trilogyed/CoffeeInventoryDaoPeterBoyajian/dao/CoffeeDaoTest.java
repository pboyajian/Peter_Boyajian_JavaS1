package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Coffee;
import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Roaster;
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
public class CoffeeDaoTest {
    @Autowired
    private CoffeeDao coffeeDao;

    @Autowired
    private RoasterDao roasterDao;

   private List<Coffee> coffees;
   private List<Roaster> roasters;

    @org.junit.Before
    public void setUp() throws Exception {

        coffees=coffeeDao.getAllCoffees();
        coffees.forEach(a->coffeeDao.deleteCoffee(a.getCoffee_id()));

        roasters=roasterDao.getAllRoasters();
        roasters.forEach(a->roasterDao.deleteRoaster(a.getRoaster_id()));

//        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
//        roasterDao.addRoaster(roasterToAdd);
    }
    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd);
        int id=roasterToAdd.getRoaster_id();
        //add
        Coffee coffeeToAdd =new Coffee(id,"name",9,3.45,"decaf");
        //act
        Coffee coffeeAfterAdding=coffeeDao.addCoffee(coffeeToAdd);
        coffeeToAdd.setCoffee_id(coffeeAfterAdding.getCoffee_id());
        //assert
        assertEquals(coffeeAfterAdding,coffeeToAdd);
    }

    @Test
    public void shouldGetAllCoffee(){
        //add
        Roaster roasterToAdd1 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd1);
        int id1=roasterToAdd1.getRoaster_id();
        Roaster roasterToAdd2 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd2);
        int id2=roasterToAdd2.getRoaster_id();
        Roaster roasterToAdd3 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd3);
        int id3=roasterToAdd3.getRoaster_id();
        Roaster roasterToAdd4 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd4);
        int id4=roasterToAdd4.getRoaster_id();
        Roaster roasterToAdd5 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd5);
        int id5=roasterToAdd5.getRoaster_id();
        Coffee coffee1= coffeeDao.addCoffee(new Coffee(id1,"name",9,3.45,"decaf"));
        Coffee coffee2= coffeeDao.addCoffee(new Coffee(id2,"name",9,3.45,"decaf"));
        Coffee coffee3=coffeeDao.addCoffee(new Coffee(id3,"name",9,3.45,"decaf"));
        Coffee coffee4=coffeeDao.addCoffee(new Coffee(id4,"name",9,3.45,"decaf"));
        Coffee coffee5=coffeeDao.addCoffee(new Coffee(id5,"name",9,3.45,"decaf"));
        List<Coffee> coffees=new ArrayList<>();
        coffees.add(coffee1);
        coffees.add(coffee2);
        coffees.add(coffee3);
        coffees.add(coffee4);
        coffees.add(coffee5);
        //act and assert
        assertEquals(coffeeDao.getAllCoffees(),coffees);
    }

    @Test
    public void shouldDeleteCoffeeById(){
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd);
        int id=roasterToAdd.getRoaster_id();
        //add
        Coffee coffeeToAdd =new Coffee(id,"name",9,3.45,"decaf");
        //act
        Coffee coffeeAfterAdding=coffeeDao.addCoffee(coffeeToAdd);
        coffeeDao.deleteCoffee(coffeeAfterAdding.getCoffee_id());
        //assert
        assertEquals(coffeeDao.getAllCoffees().size(),0);
    }

    @Test
    public void shouldUpdateCoffeeById(){
        //add
        Roaster roasterToAdd1 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd1);
        int id1=roasterToAdd1.getRoaster_id();
        Roaster roasterToAdd2 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd2);
        int id2=roasterToAdd2.getRoaster_id();
        Coffee coffeeToAdd =new Coffee(id1,"name",9,3.45,"decaf");
        Coffee coffeeToUpdate =new Coffee(id2,"name",9,3.45,"decaf");
        //act
        Coffee coffeeAfterAdding=coffeeDao.addCoffee(coffeeToAdd);
        coffeeToAdd.setCoffee_id(coffeeAfterAdding.getCoffee_id());
        int expectedId=coffeeToAdd.getCoffee_id();
        coffeeToUpdate.setCoffee_id(expectedId);
        coffeeDao.updateCoffee(coffeeToUpdate);
        //assert
        assertEquals(coffeeToUpdate,coffeeDao.getCoffee(expectedId));
    }

    @Test
    public void shouldGetCoffeeById(){
        //add
        Roaster roasterToAdd1 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd1);
        int id1=roasterToAdd1.getRoaster_id();
        Coffee coffeeToAdd =new Coffee(id1,"name",9,3.45,"decaf");
        //act
        Coffee coffeeAfterAdding=coffeeDao.addCoffee(coffeeToAdd);
        coffeeToAdd.setCoffee_id(coffeeAfterAdding.getCoffee_id());
        int expectedId=coffeeToAdd.getCoffee_id();
        //assert
        assertEquals(coffeeDao.getCoffee(expectedId),coffeeToAdd);
    }
    @Test
    public void shouldGetAllCoffeesByRoasterId(){
        //add
        Roaster roasterToAdd1 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd1);
        int id1=roasterToAdd1.getRoaster_id();
        Roaster roasterToAdd2 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd2);
        int id2=roasterToAdd2.getRoaster_id();
        Roaster roasterToAdd3 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd3);
        int id3=roasterToAdd3.getRoaster_id();
        Roaster roasterToAdd4 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd4);
        int id4=roasterToAdd4.getRoaster_id();
        Roaster roasterToAdd5 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd5);
        int id5=roasterToAdd5.getRoaster_id();
        Coffee coffee1= coffeeDao.addCoffee(new Coffee(id1,"name",9,3.45,"decaf"));
        Coffee coffee2= coffeeDao.addCoffee(new Coffee(id1,"name",9,3.45,"decaf"));
        Coffee coffee8=coffeeDao.addCoffee(new Coffee(id5,"name2",9,3.45,"decaf"));
        Coffee coffee3=coffeeDao.addCoffee(new Coffee(id3,"name",9,3.45,"decaf"));
        Coffee coffee4=coffeeDao.addCoffee(new Coffee(id4,"name",9,3.45,"decaf"));
        Coffee coffee5=coffeeDao.addCoffee(new Coffee(id5,"name",9,3.45,"decaf"));
        Coffee coffee6=coffeeDao.addCoffee(new Coffee(id5,"name",9,3.45,"decaf"));
        Coffee coffee7=coffeeDao.addCoffee(new Coffee(id2,"name",9,3.45,"decaf"));
        List<Coffee> coffeesWithId5=new ArrayList<>();
        coffeesWithId5.add(coffee5);
        coffeesWithId5.add(coffee6);
        coffeesWithId5.add(coffee8);
        List<Coffee> coffeesWithId1=new ArrayList<>();
        coffeesWithId1.add(coffee1);
        coffeesWithId1.add(coffee2);
        //act and assert
        assertEquals(coffeeDao.getCoffeesByRoaster_id(id1).size(),coffeesWithId1.size());
        assertEquals(coffeeDao.getCoffeesByRoaster_id(id5).size(),coffeesWithId5.size());
    }

    @Test
    public void shouldGetAllCoffeesByType(){
        //add
        Roaster roasterToAdd1 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd1);
        int id1=roasterToAdd1.getRoaster_id();
        Roaster roasterToAdd2 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd2);
        int id2=roasterToAdd2.getRoaster_id();
        Roaster roasterToAdd3 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd3);
        int id3=roasterToAdd3.getRoaster_id();
        Roaster roasterToAdd4 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd4);
        int id4=roasterToAdd4.getRoaster_id();
        Roaster roasterToAdd5 =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        roasterDao.addRoaster(roasterToAdd5);
        int id5=roasterToAdd5.getRoaster_id();
        Coffee coffee1= coffeeDao.addCoffee(new Coffee(id1,"name",9,3.45,"decaf"));
        Coffee coffee2= coffeeDao.addCoffee(new Coffee(id1,"name",9,3.45,"decaf"));
        Coffee coffee3=coffeeDao.addCoffee(new Coffee(id3,"name",9,3.45,"decaf"));
        Coffee coffee4=coffeeDao.addCoffee(new Coffee(id4,"name",9,3.45,"decaf"));
        Coffee coffee5=coffeeDao.addCoffee(new Coffee(id5,"name",9,3.45,"decaf"));
        Coffee coffee6=coffeeDao.addCoffee(new Coffee(id5,"name",9,3.45,"caf"));
        Coffee coffee7=coffeeDao.addCoffee(new Coffee(id2,"name",9,3.45,"caf"));
        Coffee coffee8=coffeeDao.addCoffee(new Coffee(id5,"name2",9,3.45,"decaf"));
        List<Coffee> decafCoffees=new ArrayList<>();
        decafCoffees.add(coffee5);
        decafCoffees.add(coffee8);
        decafCoffees.add(coffee1);
        decafCoffees.add(coffee2);
        decafCoffees.add(coffee3);
        decafCoffees.add(coffee4);
        List<Coffee> cafCoffees=new ArrayList<>();
        cafCoffees.add(coffee6);
        cafCoffees.add(coffee7);
        //act and assert
        assertEquals(coffeeDao.getCoffeesByType("caf").size(),cafCoffees.size());
        assertEquals(coffeeDao.getCoffeesByType("decaf").size(),decafCoffees.size());
    }



}