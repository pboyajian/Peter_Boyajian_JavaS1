package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
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
public class ConsoleDaoTest {
    @Autowired
    private ConsoleDao consoleDao;
    private Console console;
    @Before
    public void setUp() throws Exception {
        consoleDao.getAllConsoles().forEach(console1 -> consoleDao.deleteConsole(console1.getId()));
        console=new Console();
        console.setPrice(BigDecimal.valueOf(7.77));
        console.setQuantity(6);
        console.setProcessor("i7");
        console.setModel("model 1");
        console.setMemoryAmount("500 GB");
        console.setManufacturer("Sony");

    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){

        Console consoleAfterAdding=consoleDao.addConsole(console);
        console.setId(consoleAfterAdding.getId());
        assertEquals(console,consoleAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        Console consoleAfterAdding=consoleDao.addConsole(console);
        assertEquals(1,consoleDao.getAllConsoles().size());
        consoleDao.deleteConsole(consoleAfterAdding.getId());
        assertEquals(0,consoleDao.getAllConsoles().size());
    }

    @Test
    public void shouldGetAll(){
        consoleDao.addConsole(console);
        consoleDao.addConsole(console);
        assertEquals(2,consoleDao.getAllConsoles().size());
    }

    @Test
    public void shouldGetOneById(){
        Console consoleAfterAdding=consoleDao.addConsole(console);
        int id=consoleAfterAdding.getId();
        console.setId(id);
        assertEquals(console, consoleDao.getConsole(id));
    }

    @Test
    public void shouldUpdateConsole(){
        Console consoleAfterAdding=consoleDao.addConsole(console);
        int id=consoleAfterAdding.getId();
        console.setId(id);
        console.setManufacturer("updated_manufacturer");
        consoleDao.updateConsole(console);
        assertEquals(console, consoleDao.getConsole(id));
    }
    @Test
    public void shouldGetAllByManufacturer(){
        consoleDao.addConsole(console);
        consoleDao.addConsole(console);
        assertEquals(2,consoleDao.getAllConsolesByManufacturer("Sony").size());
        assertEquals(0,consoleDao.getAllConsolesByManufacturer("Nintendo").size());
    }
}