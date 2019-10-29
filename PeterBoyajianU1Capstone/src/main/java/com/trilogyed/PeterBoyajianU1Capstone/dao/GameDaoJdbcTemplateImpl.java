package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Game;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class GameDaoJdbcTemplateImpl implements GameDao {
    private static final String SELECT_ALL_GAMES_SQL="select * from game";
    private static final String DELETE_GAME_SQL="delete from game where game_id=?";
    private static final String SELECT_GAME_BY_ID_SQL="select * from game where game_id=?";
    private static final String UPDATE_GAME_SQL="update game set " +
            "price=?," +
            "description=?," +
            "studio=?," +
            "title=?," +
            "esrb_rating=?," +
            "quantity=? where game_id=?";
    private static final String INSERT_GAME_SQL="insert into game (price,description,studio,title,esrb_rating,quantity) values (?,?,?,?,?,?)";
    private static final String SELECT_ALL_GAMES_BY_STUDIO_SQL="select * from game where studio=?";
    private static final String SELECT_ALL_GAMES_BY_RATING_SQL="select * from game where esrb_rating=?";
    private static final String SELECT_ALL_GAMES_BY_TITLE_SQL="select * from game where title=?";
    private JdbcTemplate jdbcTemplate;
    public GameDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    @Override
    public Game getGame(int id) {
        try{return jdbcTemplate.queryForObject(SELECT_GAME_BY_ID_SQL,this::mapRowToGame,id);}
        catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;}
    }

    private Game mapRowToGame(ResultSet rs, int rowNum) throws SQLException {
        Game game=new Game();
        game.setQuantity(rs.getInt("quantity"));
        game.setTitle(rs.getString("title"));
        game.setDescription(rs.getString("description"));
        game.setStudio(rs.getString("studio"));
        game.setEsrbRating(rs.getString("esrb_rating"));
        game.setPrice(rs.getBigDecimal("price"));
        game.setId(rs.getInt("game_id"));
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        return jdbcTemplate.query(SELECT_ALL_GAMES_SQL,this::mapRowToGame);
    }

    @Override
    public void deleteGame(int id) {
        jdbcTemplate.update(DELETE_GAME_SQL,id);
    }

    @Override
    public void updateGame(Game game) {
        jdbcTemplate.update(UPDATE_GAME_SQL,
                game.getPrice(),
                game.getDescription(),
                game.getStudio(),
                game.getTitle(),
                game.getEsrbRating(),
                game.getQuantity(),
                game.getId());
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        jdbcTemplate.update(INSERT_GAME_SQL,
                game.getPrice(),
                game.getDescription(),
                game.getStudio(),
                game.getTitle(),
                game.getEsrbRating(),
                game.getQuantity());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        game.setId(id);
        return game;

    }

    @Override
    public List<Game> getAllGamesByStudio(String studio) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_STUDIO_SQL,this::mapRowToGame,studio);
    }

    @Override
    public List<Game> getAllGamesByRating(String rating) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_RATING_SQL,this::mapRowToGame,rating);
    }

    @Override
    public List<Game> getAllGamesByTitle(String title) {
        return jdbcTemplate.query(SELECT_ALL_GAMES_BY_TITLE_SQL,this::mapRowToGame,title);
    }
}
