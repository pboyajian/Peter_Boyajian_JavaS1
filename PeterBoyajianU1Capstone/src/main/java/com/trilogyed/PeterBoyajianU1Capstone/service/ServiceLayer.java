package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
import com.trilogyed.PeterBoyajianU1Capstone.exceptions.InvalidQuantityException;
import com.trilogyed.PeterBoyajianU1Capstone.model.*;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public List<Console> getAllConsolesByManufacturer(String manufacturer) {
        return consoleDao.getAllConsolesByManufacturer(manufacturer);
    }
    public List<TShirt> getAllTShirtsByColor(String color) {
        return tShirtDao.getAllTShirtsByColor(color);
    }
    public List<TShirt> getAllTShirtsBySize(String size) {
        return tShirtDao.getAllTShirtsBySize(size);
    }
    public InvoiceViewModel findInvoiceViewModel(int invoiceId) {
        InvoiceViewModel ivm= buildInvoiceViewModel(invoiceDao.getInvoice(invoiceId));
        ivm.setId(invoiceId);
        return ivm;
    }
    public InvoiceViewModel saveInvoiceViewModel(InvoiceViewModel ivm) {
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
        invoice.setItemType(getItemTypeFromInvoiceViewModel(ivm));
        invoice.setItemId(ivm.getItem().getId());
        invoice=addInvoice(invoice);
        ivm.setId(invoice.getInvoiceId());
        if (ivm.getQuantity()>ivm.getItem().getQuantity()){
            throw new InvalidQuantityException("The quantity requested exceeds the quantity available.");
        }else{
            Item item=ivm.getItem();
            item.setQuantity(item.getQuantity()-ivm.getQuantity());
            String itemType=invoice.getItemType();
            if (itemType.equalsIgnoreCase("game")){
                updateGame((Game) item);
            }
            else if (itemType.equalsIgnoreCase("console")){
                updateConsole((Console) item);
            }
            else {
                updateTShirt((TShirt) item);}
        }
        return ivm;
    }
    public InvoiceViewModel saveInvoiceViewModel(Invoice invoice) {
        //invoice=addInvoice(invoice);//now it has an id
        InvoiceViewModel ivm=buildInvoiceViewModel(invoice);
        ivm=saveInvoiceViewModel(ivm);
        return ivm;
    }
    String getItemTypeFromInvoiceViewModel(InvoiceViewModel ivm) {
        String str=ivm.getItem().getClass().toString();//looks like blah.blah.blah.ClassName
        //we want to take everything after the last '.' in the input string.
        int lastOccurOfDot=0;
        int len=str.length();
        for (int i = len-1; i >=0 ; i--) {
            char c=str.charAt(i);
            if (c=='.') {
                lastOccurOfDot=i;
            break;}
        }
        return str.substring(lastOccurOfDot+1,len);
    }
    public List<InvoiceViewModel> getAllInvoiceViewModels() {
        List<Invoice> invoices = invoiceDao.getAllInvoices();

        List<InvoiceViewModel> ivmList = new ArrayList<>();
        invoices.forEach(invoice -> {
            InvoiceViewModel invoiceViewModelToAdd=buildInvoiceViewModel(invoice);
            invoiceViewModelToAdd.setId(invoice.getInvoiceId());
            ivmList.add(invoiceViewModelToAdd);});

        return ivmList;
    }
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel ivm = new InvoiceViewModel();
        //ivm.setInvoiceId(invoice.getInvoiceId());
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
        ivm.setProcessingFee(getProcessingFeeFromInvoice(invoice));
        ivm.setTax(getTaxFromInvoice(ivm));
        ivm.setTotal(getTotalFromInvoice(ivm));
        return ivm;
    }
    BigDecimal getProcessingFeeFromInvoice(Invoice invoice) {
       BigDecimal retVal;
       String itemType=invoice.getItemType();
        int itemId=invoice.getItemId();
        if (itemType.equalsIgnoreCase("game")){
            retVal=getProcessingFee("Games").getFee();
        }
        else if (itemType.equalsIgnoreCase("console")){
            retVal=getProcessingFee("Consoles").getFee();   }
        else {
            retVal=getProcessingFee("T-Shirts").getFee();}
        if (invoice.getQuantity()>10){
            retVal=retVal.add(BigDecimal.valueOf(15.49));
        }
        return retVal;
    }
    BigDecimal getTaxFromInvoice(InvoiceViewModel ivm) {
        return BigDecimal.valueOf(ivm.getQuantity())
                .multiply(getTax(ivm.getState())
                        .getRate())
                .multiply(ivm.getUnitPrice());
    }
    BigDecimal getTotalFromInvoice(InvoiceViewModel ivm) {
        return ivm.getSubtotal()
                .add(ivm.getTax())
                .add(ivm.getProcessingFee());
    }
    BigDecimal getSubTotal(InvoiceViewModel invoice) {
        return invoice.getUnitPrice().multiply(BigDecimal.valueOf(invoice.getQuantity()));
    }
    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }
    public void deleteGameById(int id) {
        gameDao.deleteGame(id);
    }
    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }
    public void deleteConsoleById(int id) {
        consoleDao.deleteConsole(id);
    }
    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }
    public void deleteTShirtById(int id) {
        tShirtDao.deleteTShirt(id);
    }
    public Invoice addInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }
}