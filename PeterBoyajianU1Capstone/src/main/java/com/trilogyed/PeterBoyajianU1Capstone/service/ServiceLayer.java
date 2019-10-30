package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
import com.trilogyed.PeterBoyajianU1Capstone.model.*;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
        return gameDao.getAllGamesByRating(rating);
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
        Invoice invoice=new Invoice();
        invoice.setUnitPrice(ivm.getUnitPrice());
        invoice.setZipcode(ivm.getZipcode());
        invoice.setStreet(ivm.getStreet());
        invoice.setState(ivm.getState());
        invoice.setCity(ivm.getCity());
        invoice.setTax(ivm.getTax());
        invoice.setTotal(ivm.getTotal());
        invoice.setSubtotal(ivm.getSubtotal());
        invoice.setProcessingFee(ivm.getProcessingFee());
        invoice.setQuantity(ivm.getQuantity());
        invoice.setName(ivm.getName());
        invoice.setItemType(ivm.getItem().getClass().toString());
        invoice.setItemId(ivm.getItem().getId());
        invoice=invoiceDao.addInvoice(invoice);
        ivm.setInvoiceId(invoice.getInvoiceId());
        return ivm;
    }
    public List<InvoiceViewModel> getAllInvoices() {
        return null;
    }
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setCity(invoice.getCity());
        ivm.setName(invoice.getName());
        ivm.setState(invoice.getState());
        ivm.setStreet(invoice.getStreet());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setQuantity(invoice.getQuantity());
        String itemType=invoice.getItemType();
        int itemId=invoice.getItemId();
        Item itemToReturn;
        if (itemType.equalsIgnoreCase("game")){
            itemToReturn=getGame(itemId);
        }
        else if (itemType.equalsIgnoreCase("console")){
            itemToReturn=getConsole(itemId);        }
        else {
            itemToReturn=getTShirt(itemId);}
        ivm.setItem(itemToReturn);
        ivm.setUnitPrice(itemToReturn.getPrice());
        ivm.setSubtotal(getSubTotal(ivm));
        ivm.setProcessingFee(getProcessingFeeFromInvoice(ivm));
        ivm.setTax(getTaxFromInvoice(ivm));
        ivm.setTotal(getTotalFromInvoice(ivm));
        return ivm;
    }

    private BigDecimal getProcessingFeeFromInvoice(InvoiceViewModel ivm) {
       BigDecimal retVal;
        retVal=ivm.getUnitPrice().multiply(BigDecimal.valueOf(ivm.getQuantity()));
        if (ivm.getQuantity()>10){
            retVal=retVal.add(BigDecimal.valueOf(15.49));
        }
        return retVal;
    }

    private BigDecimal getTaxFromInvoice(InvoiceViewModel ivm) {
        return BigDecimal.valueOf(ivm.getQuantity()).multiply(getTax(ivm.getState()).getRate());
    }

    private BigDecimal getTotalFromInvoice(InvoiceViewModel ivm) {
        return ivm.getSubtotal()
                .add(ivm.getTax())
                .add(ivm.getProcessingFee());
    }

    private BigDecimal getSubTotal(InvoiceViewModel invoice) {
        return invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
    }
}