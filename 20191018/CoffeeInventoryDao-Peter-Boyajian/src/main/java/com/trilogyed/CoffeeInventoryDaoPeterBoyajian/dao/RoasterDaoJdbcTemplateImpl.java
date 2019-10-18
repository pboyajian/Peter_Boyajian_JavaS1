package com.trilogyed.CoffeeInventoryDaoPeterBoyajian.dao;

import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Coffee;
import com.trilogyed.CoffeeInventoryDaoPeterBoyajian.model.Roaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class RoasterDaoJdbcTemplateImpl implements RoasterDao {

    private JdbcTemplate jdbcTemplate;//this connects us to the database


    @Autowired //This is where dependency injection happens.
    public RoasterDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private static final String SELECT_ALL_ROASTERS_SQL= "select * from roaster";
    private static final String SELECT_ROASTER_SQL= "select * from roaster where roaster_id = ?";
    private static final String UPDATE_ROASTER_SQL= "update roaster set name=?,street=?,city=?,state=?,postal_code=?,phone=?,email=?,note=? where roaster_id = ?";
    private static final String DELETE_ROASTER_SQL= "delete from roaster where roaster_id = ?";
    private static final String INSERT_ROASTER_SQL= "insert into roaster ( name, street, city, state,postal_code,phone,email,note) values (?,?,?,?,?,?,?,?); ";
    @Override
    public Roaster getRoaster(int id) {
        try{ return jdbcTemplate.queryForObject(SELECT_ROASTER_SQL,this::mapRowToRoaster,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }}

    @Override
    public List<Roaster> getAllRoasters() {
        return jdbcTemplate.query(SELECT_ALL_ROASTERS_SQL,this::mapRowToRoaster);//may return an empty list, but will not return null
    }

    @Override
    public void deleteRoaster(int id) {
        jdbcTemplate.update(DELETE_ROASTER_SQL,
                id);
    }

    @Override
    public void updateRoaster(Roaster roaster) {

        jdbcTemplate.update(UPDATE_ROASTER_SQL,
                roaster.getName(),
                roaster.getStreet(),
                roaster.getCity(),
                roaster.getState(),
                roaster.getPostal_code(),
                roaster.getPhone(),
                roaster.getEmail(),
                roaster.getNote(),
                roaster.getRoaster_id());

    }

    @Override
    @Transactional
    public Roaster addRoaster(Roaster roaster) {
        jdbcTemplate.update(INSERT_ROASTER_SQL,roaster.getName(),roaster.getStreet(),roaster.getCity(),roaster.getState(),roaster.getPostal_code(),roaster.getPhone(),roaster.getEmail(),roaster.getNote());
        int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        roaster.setRoaster_id(id);
        return roaster;


    }


    private Roaster mapRowToRoaster(ResultSet rs, int rowNum) throws SQLException {
        Roaster roaster =new Roaster();
        roaster.setRoaster_id(Integer.parseInt(rs.getString("roaster_id")));
        roaster.setName(rs.getString("name"));
        roaster.setCity(rs.getString("city"));
        roaster.setStreet(rs.getString("street"));
        roaster.setState(rs.getString("state"));
        roaster.setPostal_code(rs.getString("postal_code"));
        roaster.setPhone(rs.getString("phone"));
        roaster.setEmail(rs.getString("email"));
        roaster.setNote(rs.getString("note"));

        return roaster;
    }
}
