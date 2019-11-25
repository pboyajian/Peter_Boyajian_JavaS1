package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;

import java.util.List;

public interface TShirtDao {
    TShirt getTShirt(int id );
    List<TShirt> getAllTShirts();
    void deleteTShirt(int id);
    void updateTShirt(TShirt tShirt);
    TShirt addTShirt(TShirt tShirt);
    List<TShirt> getAllTShirtsByColor(String Color);
    List<TShirt> getAllTShirtsBySize(String Size);
}
