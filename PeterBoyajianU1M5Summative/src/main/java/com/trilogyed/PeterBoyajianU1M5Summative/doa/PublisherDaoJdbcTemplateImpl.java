package com.trilogyed.PeterBoyajianU1M5Summative.doa;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoJdbcTemplateImpl implements PublisherDao {
    private PublisherDao publisherDao;
    private JdbcTemplate jdbcTemplate;
    @Autowired //This is where dependency injection happens.
    public PublisherDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private static final String SELECT_ALL_PUBLISHERS_SQL= "select * from publisher";
    private static final String SELECT_PUBLISHER_SQL= "select * from publisher where publisher_id = ?";
    private static final String UPDATE_PUBLISHER_SQL= "update publisher set name=?,street=?,city=?,state=?,postal_code=?,phone=?,email=? where publisher_id = ?";
    private static final String DELETE_PUBLISHER_SQL= "delete from publisher where publisher_id = ?";
    private static final String INSERT_PUBLISHER_SQL= "insert into publisher ( name, street, city,state,postal_code,phone,email) values (?,?,?,?,?,?,?); ";
    @Override
    public Publisher getPublisher(int id) {
        try{ return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL,this::mapRowToPublisher,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL,this::mapRowToPublisher);//may return an empty list, but will not return null
    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL,
                id);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisher_id());
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail());
        int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        publisher.setPublisher_id(id);
        return publisher;
    }

    private Publisher mapRowToPublisher (ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(Integer.parseInt(rs.getString("publisher_id")));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostal_code(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));
        return publisher;
    }
}
