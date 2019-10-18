package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Coffee;
import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CoffeeDaoJdbcTemplateImpl implements CoffeeDao{
private RoasterDao roasterDao;
    private JdbcTemplate jdbcTemplate;//this connects us to the database

    @Autowired //This is where dependency injection happens.
    public CoffeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private static final String SELECT_ALL_COFFEES_SQL= "select * from coffee";
    private static final String SELECT_COFFEE_SQL= "select * from coffee where coffee_id = ?";
    private static final String UPDATE_COFFEE_SQL= "update coffee set roaster_id=?,name=?,count=?,unit_price=?,description=?,type=? where coffee_id = ?";
    private static final String DELETE_COFFEE_SQL= "delete from coffee where coffee_id = ?";
    private static final String INSERT_COFFEE_SQL= "insert into coffee ( roaster_id, name, count, unit_price,description,type) values ( ?, ?,?,?,?,?); ";
    private static final String SELECT_COFFEE_SQL_BY_TYPE= "select * from coffee where type = ?";
    private static final String SELECT_COFFEE_SQL_BY_ROASTER_ID= "select * from coffee where roaster_id = ?";
    @Override
    public Coffee getCoffee(int id) {
        try{ return jdbcTemplate.queryForObject(SELECT_COFFEE_SQL,this::mapRowToCoffee,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }}

    @Override
    public List<Coffee> getAllCoffees() {
        return jdbcTemplate.query(SELECT_ALL_COFFEES_SQL,this::mapRowToCoffee);//may return an empty list, but will not return null
    }

    @Override
    public void deleteCoffee(int id) {
        jdbcTemplate.update(DELETE_COFFEE_SQL,
                id);
    }

    @Override
    public void updateCoffee(Coffee coffee) {
        try{
        jdbcTemplate.update(UPDATE_COFFEE_SQL,
                coffee.getRoaster_id(),
                coffee.getName(),
                coffee.getCount(),
                coffee.getUnit_price(),
                coffee.getDescription(),
                coffee.getType(),
                coffee.getCoffee_id());
    }catch(NullPointerException e){
            Roaster roaster=new Roaster();
            roaster.setRoaster_id(coffee.getRoaster_id());
            updateCoffee(coffee);}
    }

    @Override
    @Transactional
    public Coffee addCoffee(Coffee coffee) {
        try{
            jdbcTemplate.update(INSERT_COFFEE_SQL,coffee.getRoaster_id(),coffee.getName(),coffee.getCount(),coffee.getUnit_price(),coffee.getDescription(),coffee.getType());
            int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
            coffee.setCoffee_id(id);
            return coffee;
}catch(NullPointerException e){
            Roaster roaster=new Roaster();
            roaster.setRoaster_id(coffee.getRoaster_id());
            roasterDao.addRoaster(roaster);
            addCoffee(coffee);}
        return null;
    }

    @Override
    public List<Coffee> getCoffeesByType(String type) {
        return jdbcTemplate.query(SELECT_COFFEE_SQL_BY_TYPE,this::mapRowToCoffee,type);
    }

    @Override
    public List<Coffee> getCoffeesByRoaster_id(int roaster_id) {

        return jdbcTemplate.query(SELECT_COFFEE_SQL_BY_ROASTER_ID, this::mapRowToCoffee, roaster_id);
    }


        private Coffee mapRowToCoffee (ResultSet rs,int rowNum) throws SQLException {
            Coffee coffee = new Coffee();
            coffee.setCoffee_id(Integer.parseInt(rs.getString("coffee_id")));
            coffee.setRoaster_id(Integer.parseInt(rs.getString("roaster_id")));
            coffee.setName(rs.getString("name"));
            coffee.setCount(Integer.parseInt(rs.getString("count")));
            coffee.setUnit_price(Double.parseDouble(rs.getString("unit_price")));
            coffee.setDescription(rs.getString("description"));
            coffee.setType(rs.getString("type"));
            return coffee;
        }
    }
