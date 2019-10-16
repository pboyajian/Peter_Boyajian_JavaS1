package com.trilogyed.motoinventoryjdbctemplate.dao;

import com.trilogyed.motoinventoryjdbctemplate.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MotoInventoryDaoJdbcTemplateImpl implements MotoInventoryDao {

    private static final String SELECT_ALL_MOTOS_SQL= "select * from motorcycle";
    private static final String SELECT_MOTO_SQL= "select * from motorcycle where id = ?";
    private static final String UPDATE_MOTO_SQL= "update motorcycle set vin=?,make=?,model=?,year=?,color=? where id = ?";
    private static final String DELETE_MOTO_SQL= "delete from motorcycle where id = ?";
    private static final String INSERT_MOTO_SQL= "insert into motorcycle (vin, make, model, year , color) values (?, ?, ?,?,?); ";
    private static final String SELECT_MOTO_SQL_BY_MAKE= "select * from motorcycle where make = ?";

    @Override
    public Motorcycle getMotorcycle(int id) {
       try{ return jdbcTemplate.queryForObject(SELECT_MOTO_SQL,this::mapRowToMotorcycle,id);
    }catch(EmptyResultDataAccessException erdae){
           System.out.println("We caught an exception: "+erdae.getMessage());
           return null;

       }}

    @Override
    public List<Motorcycle> getAllMotorcycles() {
        return jdbcTemplate.query(SELECT_ALL_MOTOS_SQL,this::mapRowToMotorcycle);//may return an empty list, but will not return null
    }

    @Override
    public void deleteMotorcycle(int id) {
        jdbcTemplate.update(DELETE_MOTO_SQL,
                id);
    }

    @Override
    public void updateMotorcycle(Motorcycle motorcycle) {

         jdbcTemplate.update(UPDATE_MOTO_SQL,
                 motorcycle.getVin(),
                 motorcycle.getMake(),
                 motorcycle.getModel(),
                 motorcycle.getYear(),
                 motorcycle.getColor(),
                 motorcycle.getId());
    }

    @Override
    @Transactional
    public Motorcycle addMotorcycle(Motorcycle motorcycle) {
         jdbcTemplate.update(INSERT_MOTO_SQL,motorcycle.getVin(),motorcycle.getMake(),motorcycle.getModel(),motorcycle.getYear(),motorcycle.getColor());
         int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
         motorcycle.setId(id);
         return motorcycle;


    }

    @Override
    public List<Motorcycle> getMotorcyclesByMake(String make) {
        return jdbcTemplate.query(SELECT_MOTO_SQL_BY_MAKE,this::mapRowToMotorcycle,make);
    }
    private JdbcTemplate jdbcTemplate;//this connects us to the database

    @Autowired //This is where dependency injection happens.
    public MotoInventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private Motorcycle mapRowToMotorcycle(ResultSet rs, int rowNum) throws SQLException{
        Motorcycle moto =new Motorcycle();
        moto.setId(Integer.parseInt(rs.getString("id")));
        moto.setMake(rs.getString("make"));
        moto.setModel(rs.getString("model"));
        moto.setVin(rs.getString("vin"));
        moto.setYear(rs.getString("year"));
        moto.setColor(rs.getString("color"));
        return moto;
    }

}
