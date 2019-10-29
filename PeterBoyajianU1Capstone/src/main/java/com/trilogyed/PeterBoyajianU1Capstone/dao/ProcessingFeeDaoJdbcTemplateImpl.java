package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.ProcessingFee;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {
    private JdbcTemplate jdbcTemplate;
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    @Override
    public ProcessingFee getProcessingFee(int id) {
        return null;
    }
}
