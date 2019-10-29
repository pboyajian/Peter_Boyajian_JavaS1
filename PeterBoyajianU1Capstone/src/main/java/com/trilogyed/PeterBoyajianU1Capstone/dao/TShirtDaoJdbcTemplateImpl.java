package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TShirtDaoJdbcTemplateImpl implements TShirtDao {
    private JdbcTemplate jdbcTemplate;

    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TShirt getTShirt(int id) {
        return null;
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return null;
    }

    @Override
    public void deleteTShirt(int id) {

    }

    @Override
    public void updateTShirt(TShirt tShirt) {

    }

    @Override
    public TShirt addTShirt(TShirt tShirt) {
        return null;
    }

    @Override
    public List<TShirt> getAllTShirtsByColor(String Color) {
        return null;
    }

    @Override
    public List<TShirt> getAllTShirtsBySize(String Size) {
        return null;
    }
}
