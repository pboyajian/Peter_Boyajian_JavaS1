package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Game;

import java.util.List;

public interface GameDao {
    Game getGame(int id );
    List<Game> getAllGames();
    void deleteGame(int id);
    void updateGame(Game game);
    Game addGame(Game game);
    List<Game> getAllGamesByStudio(String studio);
    List<Game> getAllGamesByRating(String rating);
    List<Game> getAllGamesByTitle(String title);

}
