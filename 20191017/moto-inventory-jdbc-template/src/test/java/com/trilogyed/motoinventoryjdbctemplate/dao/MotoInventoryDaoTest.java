package com.trilogyed.motoinventoryjdbctemplate.dao;

import com.trilogyed.motoinventoryjdbctemplate.model.Motorcycle;
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
public class MotoInventoryDaoTest {
    @Autowired
    private MotoInventoryDao dao;
    @Before
    public void setUp() throws Exception {
        List<Motorcycle> motorcycles=dao.getAllMotorcycles();
        motorcycles.forEach(a->dao.deleteMotorcycle(a.getId()));
    }
    @Test
    public void shouldBeInDatabaseAfterWeAdd(){
        //add
        Motorcycle motorcycleToAdd =new Motorcycle("12345","BMW","Fancy","2019","Matte black");
        //act
        Motorcycle motorcycleAfterAdding=dao.addMotorcycle(motorcycleToAdd);
        motorcycleToAdd.setId(motorcycleAfterAdding.getId());
        //assert
        assertEquals(motorcycleAfterAdding,motorcycleToAdd);
    }
    @Test
    public void shouldGetMotoById(){
        //add
        Motorcycle motorcycleToAdd =new Motorcycle("12345","BMW","Fancy","2019","Matte black");
        //act
        Motorcycle motorcycleAfterAdding=dao.addMotorcycle(motorcycleToAdd);
        motorcycleToAdd.setId(motorcycleAfterAdding.getId());
        int expectedId=motorcycleToAdd.getId();
        //assert
        assertEquals(dao.getMotorcycle(expectedId),motorcycleToAdd);
    }

        @Test
        public void shouldGetAllMoto(){
            //add
            Motorcycle moto1= dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy","2019","Matte black"));
            Motorcycle moto2= dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy2","2019","Matte black"));
            Motorcycle moto3=dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy3","2019","Matte black"));
            Motorcycle moto4=dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy4","2019","Matte black"));
            Motorcycle moto5=dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy5","2019","Matte black"));
            List<Motorcycle> motorcycles=new ArrayList<>();
            motorcycles.add(moto1);
            motorcycles.add(moto2);
            motorcycles.add(moto3);
            motorcycles.add(moto4);
            motorcycles.add(moto5);
            //act and assert
            assertEquals(dao.getAllMotorcycles(),motorcycles);
        }

        @Test
        public void shouldDeleteMotoById(){
            //add
            Motorcycle motorcycleToAdd =new Motorcycle("12345","BMW","Fancy","2019","Matte black");
            //act
            Motorcycle motorcycleAfterAdding=dao.addMotorcycle(motorcycleToAdd);
            motorcycleToAdd.setId(motorcycleAfterAdding.getId());
            int expectedId=motorcycleToAdd.getId();
            dao.deleteMotorcycle(expectedId);
            //assert
            assertEquals(dao.getAllMotorcycles().size(),0);
        }

        @Test
        public void shouldUpdateMotoById(){
            //add
            Motorcycle motorcycleToAdd =new Motorcycle("12345","BMW","Fancy","2019","Matte black");
            Motorcycle motorcycleToUpdate =new Motorcycle("12345","BMWalksdfhian","Fancy","2019","Matte black");
            //act
            Motorcycle motorcycleAfterAdding=dao.addMotorcycle(motorcycleToAdd);
            motorcycleToAdd.setId(motorcycleAfterAdding.getId());
            int expectedId=motorcycleToAdd.getId();
            motorcycleToUpdate.setId(expectedId);
            dao.updateMotorcycle(motorcycleToUpdate);
            //assert
            assertEquals(motorcycleToUpdate,dao.getMotorcycle(expectedId));
        }

        @Test
        public void shouldGetAllMotoByMake(){
            //add
            Motorcycle moto1= dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy","2019","Matte black"));
            Motorcycle moto2= dao.addMotorcycle(new Motorcycle("12345","BMW","Fancy2","2019","Matte black"));
            Motorcycle moto3=dao.addMotorcycle(new Motorcycle("12345","BMW2","Fancy3","2019","Matte black"));
            Motorcycle moto4=dao.addMotorcycle(new Motorcycle("12345","BMW2","Fancy4","2019","Matte black"));
            Motorcycle moto5=dao.addMotorcycle(new Motorcycle("12345","BMW2","Fancy5","2019","Matte black"));
            List<Motorcycle> motorcycles=new ArrayList<>();
            motorcycles.add(moto1);
            motorcycles.add(moto2);
            //act and assert
            assertEquals(dao.getMotorcyclesByMake("BMW"),motorcycles);
        }


}