package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {
@Autowired
private GameDao gameDao;
private Game game;
    @Before
    public void setUp() throws Exception {
        gameDao.getAllGames().forEach(game1 -> gameDao.deleteGame(game1.getId()));
        game=new Game();
        game.setPrice(BigDecimal.valueOf(7.77));
        game.setDescription("default description");
        game.setEsrbRating("bad");
        game.setStudio("Studio 1");
        game.setTitle("gameName");
        game.setQuantity(6);
        
    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){

        Game gameAfterAdding=gameDao.addGame(game);
        game.setId(gameAfterAdding.getId());
        assertEquals(game,gameAfterAdding);
    }

    @Test
    public void shouldDeleteById(){
        Game gameAfterAdding=gameDao.addGame(game);
        assertEquals(1,gameDao.getAllGames().size());
        gameDao.deleteGame(gameAfterAdding.getId());
        assertEquals(0,gameDao.getAllGames().size());
    }

    @Test
    public void shouldGetAll(){
        gameDao.addGame(game);
        gameDao.addGame(game);
        assertEquals(2,gameDao.getAllGames().size());
    }

    @Test
    public void shouldGetOneById(){
        Game gameAfterAdding=gameDao.addGame(game);
        int id=gameAfterAdding.getId();
        game.setId(id);
        assertEquals(game, gameDao.getGame(id));
    }

    @Test
    public void shouldUpdateGame(){
        Game gameAfterAdding=gameDao.addGame(game);
        int id=gameAfterAdding.getId();
        game.setId(id);
        game.setDescription("updated_name");
        gameDao.updateGame(game);
        assertEquals(game, gameDao.getGame(id));
    }
    @Test
    public void shouldGetAllByStudio(){
        gameDao.addGame(game);
        gameDao.addGame(game);
        assertEquals(2,gameDao.getAllGamesByStudio("Studio 1").size());
        assertEquals(0,gameDao.getAllGamesByStudio("Studio 2").size());
    }
    @Test
    public void shouldGetAllByTitle(){
        gameDao.addGame(game);
        gameDao.addGame(game);
        assertEquals(2,gameDao.getAllGamesByTitle("game").size());
        assertEquals(0,gameDao.getAllGamesByTitle("lameName").size());
    }
    @Test
    public void shouldGetAllByESRBRating(){
        gameDao.addGame(game);
        gameDao.addGame(game);
        assertEquals(2,gameDao.getAllGamesByRating("bad").size());
        assertEquals(0,gameDao.getAllGamesByRating("good").size());
    }
}