package com.trilogyed.PeterBoyajianU1M5Summative.dao;

import com.trilogyed.PeterBoyajianU1M5Summative.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbcTemplateImpl implements AuthorDao {
    private AuthorDao authorDao;
    private JdbcTemplate jdbcTemplate;
    @Autowired //This is where dependency injection happens.
    public AuthorDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    private static final String SELECT_ALL_AUTHORS_SQL= "select * from author";
    private static final String SELECT_AUTHOR_SQL= "select * from author where author_id = ?";
    private static final String UPDATE_AUTHOR_SQL= "update author set first_name=?,last_name=?,street=?,city=?,state=?,postal_code=?,phone=?,email=? where author_id = ?";
    private static final String DELETE_AUTHOR_SQL= "delete from author where author_id = ?";
    private static final String INSERT_AUTHOR_SQL= "insert into author ( first_name, last_name, street, city,state,postal_code,phone,email) values ( ?, ?,?,?,?,?,?,?); ";
    @Override
    public Author getAuthor(int id) {
        try{ return jdbcTemplate.queryForObject(SELECT_AUTHOR_SQL,this::mapRowToAuthor,id);
        }catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;

        }    }

    @Override
    public List<Author> getAllAuthors() {
        return jdbcTemplate.query(SELECT_ALL_AUTHORS_SQL,this::mapRowToAuthor);//may return an empty list, but will not return null
    }

    @Override
    public void deleteAuthor(int id) {
        jdbcTemplate.update(DELETE_AUTHOR_SQL,
                id);
    }

    @Override
    public void updateAuthor(Author author) {
        jdbcTemplate.update(UPDATE_AUTHOR_SQL,
                author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),
                author.getPostal_code(),
                author.getPhone(),
                author.getEmail(),
                author.getAuthor_id());
    }

    @Override
    public Author addAuthor(Author author) {
        jdbcTemplate.update(INSERT_AUTHOR_SQL,author.getFirst_name(),
                author.getLast_name(),
                author.getStreet(),
                author.getCity(),
                author.getState(),author.getPostal_code(),
                author.getPhone(),
                author.getEmail());
        int id=jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        author.setAuthor_id(id);
        return author;
    }

    private Author mapRowToAuthor (ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setAuthor_id(Integer.parseInt(rs.getString("author_id")));
        author.setFirst_name(rs.getString("first_name"));
        author.setLast_name(rs.getString("last_name"));
        author.setStreet(rs.getString("street"));
        author.setCity(rs.getString("city"));
        author.setState(rs.getString("state"));
        author.setPostal_code(rs.getString("postal_code"));
        author.setPhone(rs.getString("phone"));
        author.setEmail(rs.getString("email"));
        return author;
    }
}
