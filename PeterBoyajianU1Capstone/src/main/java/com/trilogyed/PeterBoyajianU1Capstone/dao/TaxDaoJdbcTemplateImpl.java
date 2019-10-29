package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Tax;
import org.springframework.jdbc.core.JdbcTemplate;

public class TaxDaoJdbcTemplateImpl implements TaxDao{
    private JdbcTemplate jdbcTemplate;

    public TaxDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax getTax(int id) {
        return null;
    }
}
