package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.ProcessingFee;
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
public class ProcessingFeeDaoTest {
@Autowired
private ProcessingFeeDaoJdbcTemplateImpl processingFeeDaoJdbcTemplate;
    @Before
    public void setUp() throws Exception {
    }

//    @Test
//    public void shouldDeleteById(){
//        ProcessingFee processingFeeAfterAdding=processingFeeDao.addProcessingFee(processingFee);
//        assertEquals(1,processingFeeDao.getAllProcessingFees().size());
//        processingFeeDao.deleteProcessingFee(processingFeeAfterAdding.getId());
//        assertEquals(0,processingFeeDao.getAllProcessingFees().size());
//    }
//
//    @Test
//    public void shouldGetAll(){
//        processingFeeDao.addProcessingFee(processingFee);
//        processingFeeDao.addProcessingFee(processingFee);
//        assertEquals(2,processingFeeDao.getAllProcessingFees().size());
//    }

    @Test
    public void shouldGetOneById(){
        ProcessingFee processingFee;
        processingFee=new ProcessingFee();
        processingFee.setFee(BigDecimal.valueOf(1.49));
        processingFee.setProduct_type("Games");
        assertEquals(processingFee, processingFeeDaoJdbcTemplate.getProcessingFee("Games"));
        processingFee.setFee(BigDecimal.valueOf(1.98));
        processingFee.setProduct_type("T-Shirts");
        assertEquals(processingFee, processingFeeDaoJdbcTemplate.getProcessingFee("T-Shirts"));
        processingFee.setFee(BigDecimal.valueOf(14.99));
        processingFee.setProduct_type("Consoles");
        assertEquals(processingFee, processingFeeDaoJdbcTemplate.getProcessingFee("Consoles"));
    }
}