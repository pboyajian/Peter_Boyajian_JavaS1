package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ConsoleDaoJdbcTemplateImpl implements ConsoleDao {

    private JdbcTemplate jdbcTemplate;
    public ConsoleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    @Override
    public Console getConsole(int id) {
        return null;
    }

    @Override
    public List<Console> getAllConsoles() {
        return null;
    }

    @Override
    public void deleteConsole(int id) {

    }

    @Override
    public void updateConsole(Console console) {

    }

    @Override
    public Console addConsole(Console console) {
        return null;
    }

    @Override
    public List<Console> getAllConsolesByManufacturer(String Manufacturer) {
        return null;
    }
}
