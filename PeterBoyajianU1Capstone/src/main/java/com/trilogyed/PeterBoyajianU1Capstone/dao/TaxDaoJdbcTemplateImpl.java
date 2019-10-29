package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Tax;
import com.trilogyed.PeterBoyajianU1Capstone.model.Tax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TaxDaoJdbcTemplateImpl implements TaxDao{
    private static final String SELECT_TAX_BY_STATE_SQL="select * from sales_tax_rate where state=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public TaxDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private Tax mapRowToTax(ResultSet rs, int rowNum) throws SQLException {
        Tax processingFee=new Tax();
        processingFee.setRate(rs.getBigDecimal("rate"));
        processingFee.setState(rs.getString("state"));
        return processingFee;
    }
    @Override
    public Tax getTax(String state) {
        try{
            return jdbcTemplate.queryForObject(SELECT_TAX_BY_STATE_SQL,this::mapRowToTax,state);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("error: "+erdae.getMessage());
            return null;
        }
    }
}
