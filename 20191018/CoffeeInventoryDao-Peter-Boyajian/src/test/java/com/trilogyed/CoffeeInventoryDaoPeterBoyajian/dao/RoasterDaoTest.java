package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

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
public class RoasterDaoTest {
    @Autowired
    private RoasterDao dao;

    @org.junit.Before
    public void setUp() throws Exception {

        List<Roaster> roasters=dao.getAllRoasters();
        roasters.forEach(a->dao.deleteRoaster(a.getRoaster_id()));
    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        //add
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        //act
        Roaster roasterAfterAdding=dao.addRoaster(roasterToAdd);
        roasterToAdd.setRoaster_id(roasterAfterAdding.getRoaster_id());
        //assert
        assertEquals(roasterAfterAdding,roasterToAdd);
    }

    @Test
    public void shouldGetRoasterById(){
        //add
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        //act
        Roaster roasterAfterAdding=dao.addRoaster(roasterToAdd);
        roasterToAdd.setRoaster_id(roasterAfterAdding.getRoaster_id());
        int expectedId=roasterToAdd.getRoaster_id();
        //assert
        assertEquals(roasterToAdd,dao.getRoaster(expectedId));
    }

    @Test
    public void shouldGetAllRoaster(){
        //add
        Roaster roaster1= dao.addRoaster(new Roaster("name1","street","city","IL","12345","5555555555","nunya@business.com","note"));
        Roaster roaster2= dao.addRoaster(new Roaster("name2","street","city","IL","12345","5555555555","nunya@business.com","note"));
        Roaster roaster3=dao.addRoaster(new Roaster("name3","street","city","IL","12345","5555555555","nunya@business.com","note"));
        Roaster roaster4=dao.addRoaster(new Roaster("name4","street","city","IL","12345","5555555555","nunya@business.com","note"));
        Roaster roaster5=dao.addRoaster(new Roaster("name5","street","city","IL","12345","5555555555","nunya@business.com","note"));
        List<Roaster> roasters=new ArrayList<>();
        roasters.add(roaster1);
        roasters.add(roaster2);
        roasters.add(roaster3);
        roasters.add(roaster4);
        roasters.add(roaster5);
        //act and assert
        assertEquals(dao.getAllRoasters(),roasters);

}


    @Test
    public void shouldDeleteRoasterById(){
        //add
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        //act
        Roaster roasterAfterAdding=dao.addRoaster(roasterToAdd);
        roasterToAdd.setRoaster_id(roasterAfterAdding.getRoaster_id());
        int expectedId=roasterToAdd.getRoaster_id();
        dao.deleteRoaster(expectedId);
        //assert
        assertEquals(dao.getAllRoasters().size(),0);
    }

    @Test
    public void shouldUpdateRoasterById(){
        //add
        Roaster roasterToAdd =new Roaster("name","street","city","IL","12345","5555555555","nunya@business.com","note");
        Roaster roasterToUpdate =new Roaster("name_updated","street","city","IL","12345","5555555555","nunya@business.com","note");
        //act
        Roaster roasterAfterAdding=dao.addRoaster(roasterToAdd);
        roasterToAdd.setRoaster_id(roasterAfterAdding.getRoaster_id());
        int expectedId=roasterToAdd.getRoaster_id();
        roasterToUpdate.setRoaster_id(expectedId);
        dao.updateRoaster(roasterToUpdate);
        //assert
        assertEquals(roasterToUpdate,dao.getRoaster(expectedId));
    }
}