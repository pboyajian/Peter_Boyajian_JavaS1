package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
import com.trilogyed.PeterBoyajianU1Capstone.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceLayer {
    private GameDao gameDao;
    private ConsoleDao consoleDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;
    private TaxDao taxDao;
    private ProcessingFeeDao processingFeeDao;
@Autowired
    public ServiceLayer(GameDao gameDao, ConsoleDao consoleDao, TShirtDao tShirtDao, InvoiceDao invoiceDao, TaxDao taxDao, ProcessingFeeDao processingFeeDao) {
        this.gameDao = gameDao;
        this.consoleDao = consoleDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.taxDao = taxDao;
        this.processingFeeDao = processingFeeDao;
    }


    public Game addGame(Game game) {
    }

    public Game getGame(int i) {
    }

    public List<Game> getAllGames() {
    }

    public Console addConsole(Console console) {
    }

    public Console getConsole(int i) {
    }

    public List<Console> getAllConsoles() {
    }

    public TShirt addTShirt(TShirt tShirt) {
    }

    public TShirt getTShirt(int i) {
    }

    public List<TShirt> getAllTShirts() {
    }

    public Tax getTax(String ny) {
    }

    public ProcessingFee getProcessingFee(String games) {
    }

    public List<Game> getAllGamesByStudio(String s) {
    }

    public List<Game> getAllGamesByTitle(String game) {
    }

    public List<Game> getAllGamesByRating(String bad) {
    }

    public List<Console> getAllConsolesByManufacturer(String sony) {
    }

    public List<TShirt> getAllTShirtsByColor(String ugly) {
    }

    public List<TShirt> getAllTShirtsBySize(String xxxxxxxxxxxxxxxxl) {
    }
}
