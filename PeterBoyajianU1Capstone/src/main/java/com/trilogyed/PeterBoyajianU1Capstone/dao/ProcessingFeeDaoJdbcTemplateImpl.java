package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.ProcessingFee;
import com.trilogyed.PeterBoyajianU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {   
//    private static final String SELECT_ALL_PROCESSINGFEES_SQL="select * from processing_fee";
//    private static final String DELETE_PROCESSINGFEE_SQL="delete from processing_fee where processing_fee_id=?";
    private static final String SELECT_PROCESSINGFEE_BY_PRODUCTTYPE_SQL="select * from processing_fee where product_type=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee=new ProcessingFee();
        processingFee.setFee(rs.getBigDecimal("fee"));
        processingFee.setProduct_type(rs.getString("product_type"));
        return processingFee;
    }
    @Override
    public ProcessingFee getProcessingFee(String productType) {
        try{
            return jdbcTemplate.queryForObject(SELECT_PROCESSINGFEE_BY_PRODUCTTYPE_SQL,this::mapRowToProcessingFee,productType);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("error: "+erdae.getMessage());
            return null;
        }
    }
//    public List<ProcessingFee> getAllProcessingFees() {
//        return  jdbcTemplate.query(SELECT_ALL_PROCESSINGFEES_SQL,this::mapRowToProcessingFee);
//    }
//    public void deleteProcessingFee(int id) {
//        jdbcTemplate.update(DELETE_PROCESSINGFEE_SQL,id);
//    }
    
}
