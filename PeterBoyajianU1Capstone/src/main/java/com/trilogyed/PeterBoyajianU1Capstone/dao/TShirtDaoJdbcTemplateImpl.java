package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class TShirtDaoJdbcTemplateImpl implements TShirtDao {
    private static final String SELECT_ALL_TSHIRTS_SQL="select * from t_shirt";
    private static final String DELETE_TSHIRT_SQL="delete from t_shirt where t_shirt_id=?";
    private static final String SELECT_TSHIRT_BY_ID_SQL="select * from t_shirt where t_shirt_id=?";
    private static final String UPDATE_TSHIRT_SQL="update t_shirt set " +
            "color=?," +
            "size=?," +
            "description=?," +
            "price=?," +
            "quantity=? " +
            "where t_shirt_id=?";
    private static final String INSERT_TSHIRT_SQL="insert into t_shirt (color,size,description,price,quantity) values (?,?,?,?,?)";
    private static final String SELECT_ALL_TSHIRTS_BY_COLOR_SQL="select * from t_shirt where color=?";
    private static final String SELECT_ALL_TSHIRTS_BY_SIZE_SQL="select * from t_shirt where size=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public TShirtDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt=new TShirt();
        tShirt.setColor(rs.getString("color"));
        tShirt.setSize(rs.getString("size"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));
        tShirt.setId(rs.getInt("t_shirt_id"));
        return tShirt;
    }

    @Override
    public TShirt getTShirt(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_TSHIRT_BY_ID_SQL,this::mapRowToTShirt,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("error: "+erdae.getMessage());
            return null;
        }
    }

    @Override
    public List<TShirt> getAllTShirts() {
        return  jdbcTemplate.query(SELECT_ALL_TSHIRTS_SQL,this::mapRowToTShirt);
    }

    @Override
    public void deleteTShirt(int id) {
jdbcTemplate.update(DELETE_TSHIRT_SQL,id);
    }

    @Override
    public void updateTShirt(TShirt tShirt) {
jdbcTemplate.update(UPDATE_TSHIRT_SQL,
        tShirt.getColor(),
        tShirt.getSize(),
        tShirt.getDescription(),
        tShirt.getPrice(),
        tShirt.getQuantity(),
        tShirt.getId());
    }

    @Override
    @Transactional
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_TSHIRT_SQL,
                tShirt.getColor(),
                tShirt.getSize(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity());
        int id=jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        tShirt.setId(id);
        return tShirt;
    }

    @Override
    public List<TShirt> getAllTShirtsByColor(String color) {
        return  jdbcTemplate.query(SELECT_ALL_TSHIRTS_BY_COLOR_SQL,this::mapRowToTShirt,color);
    }

    @Override
    public List<TShirt> getAllTShirtsBySize(String size) {
        return  jdbcTemplate.query(SELECT_ALL_TSHIRTS_BY_SIZE_SQL,this::mapRowToTShirt,size);
    }
}
