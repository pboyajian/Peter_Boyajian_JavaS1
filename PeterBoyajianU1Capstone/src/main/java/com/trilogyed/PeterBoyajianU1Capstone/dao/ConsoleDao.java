package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {
    Console getConsole(int id );
    List<Console> getAllConsoles();
    void deleteConsole(int id);
    void updateConsole(Console console);
    Console addConsole(Console console);
    List<Console> getAllConsolesByManufacturer(String Manufacturer);
}
