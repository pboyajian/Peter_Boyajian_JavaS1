package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {
    @Autowired
    private TShirtDao tShirtDao;
    private TShirt tShirt;
    @Before
    public void setUp() throws Exception {
        tShirtDao.getAllTShirts().forEach(tShirt1 -> tShirtDao.deleteTShirt(tShirt1.getId()));
        tShirt=new TShirt();
        tShirt.setPrice(BigDecimal.valueOf(7.77));
        tShirt.setColor("red");
        tShirt.setDescription("ugly");
        tShirt.setSize("xxxxxxxxxxxxxxxxl");
        tShirt.setQuantity(679);

    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){

        TShirt tShirtAfterAdding=tShirtDao.addTShirt(tShirt);
        tShirt.setId(tShirtAfterAdding.getId());
        assertEquals(tShirt,tShirtAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        TShirt tShirtAfterAdding=tShirtDao.addTShirt(tShirt);
        assertEquals(1,tShirtDao.getAllTShirts().size());
        tShirtDao.deleteTShirt(tShirtAfterAdding.getId());
        assertEquals(0,tShirtDao.getAllTShirts().size());
    }

    @Test
    public void shouldGetAll(){
        tShirtDao.addTShirt(tShirt);
        tShirtDao.addTShirt(tShirt);
        assertEquals(2,tShirtDao.getAllTShirts().size());
    }

    @Test
    public void shouldGetOneById(){
        TShirt tShirtAfterAdding=tShirtDao.addTShirt(tShirt);
        int id=tShirtAfterAdding.getId();
        tShirt.setId(id);
        assertEquals(tShirt, tShirtDao.getTShirt(id));
    }

    @Test
    public void shouldUpdateTShirt(){
        TShirt tShirtAfterAdding=tShirtDao.addTShirt(tShirt);
        int id=tShirtAfterAdding.getId();
        tShirt.setId(id);
        tShirt.setDescription("slightly less ugly");
        tShirtDao.updateTShirt(tShirt);
        assertEquals(tShirt, tShirtDao.getTShirt(id));
    }
    @Test
    public void shouldGetAllByColor(){
        tShirtDao.addTShirt(tShirt);
        tShirtDao.addTShirt(tShirt);
        assertEquals(2,tShirtDao.getAllTShirtsByColor("red").size());
        assertEquals(0,tShirtDao.getAllTShirtsByColor("purple").size());
    }
    @Test
    public void shouldGetAllBySize(){
        tShirtDao.addTShirt(tShirt);
        tShirtDao.addTShirt(tShirt);
        assertEquals(2,tShirtDao.getAllTShirtsBySize("xxxxxxxxxxxxxxxxl").size());
        assertEquals(0,tShirtDao.getAllTShirtsBySize("small").size());
    }

}