package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
import com.trilogyed.PeterBoyajianU1Capstone.model.*;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
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
        return gameDao.addGame(game);
    }
    public Game getGame(int i) {
        return gameDao.getGame(i);
    }
    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }
    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }
    public Console getConsole(int i) {
        return consoleDao.getConsole(i);
    }
    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }
    public TShirt addTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }
    public TShirt getTShirt(int i) {
        return tShirtDao.getTShirt(i);
    }
    public List<TShirt> getAllTShirts() {
        return tShirtDao.getAllTShirts();
    }
    public Tax getTax(String state) {
        return taxDao.getTax(state);
    }
    public ProcessingFee getProcessingFee(String procFee) {
        return processingFeeDao.getProcessingFee(procFee);
    }
    public List<Game> getAllGamesByStudio(String studio) {
        return gameDao.getAllGamesByStudio(studio);
    }
    public List<Game> getAllGamesByTitle(String title) {
        return gameDao.getAllGamesByTitle(title);
    }
    public List<Game> getAllGamesByRating(String rating) {
        return gameDao.getAllGamesByStudio(rating);
    }
    public List<Console> getAllConsolesByManufacturer(String manu) {
        return consoleDao.getAllConsolesByManufacturer(manu);
    }
    public List<TShirt> getAllTShirtsByColor(String color) {
        return tShirtDao.getAllTShirtsByColor(color);
    }
    public List<TShirt> getAllTShirtsBySize(String size) {
        return tShirtDao.getAllTShirtsBySize(size);
    }

    public InvoiceViewModel findInvoice(int invoiceId) {
        return null;
    }
    public InvoiceViewModel saveInvoice(InvoiceViewModel ivm) {
        return null;
    }
    public List<InvoiceViewModel> getAllInvoices() {
        return null;
    }
}