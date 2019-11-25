package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Tax;
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
public class TaxDaoTest {
@Autowired
private TaxDaoJdbcTemplateImpl taxDaoJdbcTemplate;
    @Test
    public void shouldGetOneByProductType(){
        Tax tax;
        tax=new Tax();
        tax.setRate(BigDecimal.valueOf(0.05));
        tax.setState("IL");
        assertEquals(tax, taxDaoJdbcTemplate.getTax("IL"));
        tax.setRate(BigDecimal.valueOf(0.03));
        tax.setState("TX");
        assertEquals(tax, taxDaoJdbcTemplate.getTax("TX"));
        tax.setRate(BigDecimal.valueOf(0.06));
        tax.setState("NY");
        assertEquals(tax, taxDaoJdbcTemplate.getTax("NY"));
    }
}