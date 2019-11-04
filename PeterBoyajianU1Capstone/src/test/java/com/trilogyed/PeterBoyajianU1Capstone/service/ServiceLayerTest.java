package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
import com.trilogyed.PeterBoyajianU1Capstone.exceptions.InvalidQuantityException;
import com.trilogyed.PeterBoyajianU1Capstone.model.*;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {
    private ServiceLayer serviceLayer;
    private GameDao gameDao;
    private ConsoleDao consoleDao;
    private TShirtDao tShirtDao;
    private InvoiceDao invoiceDao;
    private TaxDao taxDao;
    private ProcessingFeeDao processingFeeDao;
    @Before
    public void setUp(){
        setUpGameDaoMock();
        setUpConsoleDaoMock();
        setUpTShirtDaoMock();
        setUpInvoiceDaoMock();
        setUpTaxDaoMock();
        setUpProcessingFeeDaoMock();
        serviceLayer = new ServiceLayer(gameDao, consoleDao, tShirtDao, invoiceDao,taxDao,processingFeeDao);

    }
@Test
public void shouldAddExpensiveProcessingFeeForOver10Items(){
    Invoice tShirtInvoice=new Invoice();
    tShirtInvoice.setCity("city");
    tShirtInvoice.setItemId(6);
    tShirtInvoice.setItemType("TShirt");
    tShirtInvoice.setName("name");
    tShirtInvoice.setState("IL");
    tShirtInvoice.setStreet("street");
    tShirtInvoice.setQuantity(17);
    tShirtInvoice.setZipcode("66666");
    BigDecimal expectedProcessingFee=BigDecimal.valueOf(15.49+1.98);
    BigDecimal processingFee=serviceLayer.saveInvoiceViewModel(tShirtInvoice).getProcessingFee();
    assertEquals(expectedProcessingFee,processingFee);

}
@Test
public void shouldThrowErrorWhenQuantityInInvoiceIsTooHigh(){
    Invoice gameInvoice=new Invoice();
    gameInvoice.setCity("city");
    gameInvoice.setItemId(5);
    gameInvoice.setItemType("Game");
    gameInvoice.setName("name");
    gameInvoice.setState("IL");
    gameInvoice.setStreet("street");
    gameInvoice.setQuantity(7);
    gameInvoice.setZipcode("66666");
    try{InvoiceViewModel returnedGameIVM=serviceLayer.saveInvoiceViewModel(gameInvoice);}
    catch(InvalidQuantityException iqe){
        assertTrue(iqe.getMessage().contains("Invalid quantity"));
    }
    }
@Test
public void shouldGetGetAllAndPostGame(){
    Game game=new Game();
    game.setPrice(BigDecimal.valueOf(7.77));
    game.setDescription("default description");
    game.setEsrbRating("bad");
    game.setStudio("Studio 1");
    game.setTitle("gameName");
    game.setQuantity(6);
    Game gameFromService=serviceLayer.addGame(game);
    game.setId(5);
    assertEquals(game,gameFromService);
    assertEquals(game,serviceLayer.getGame(5));
    List<Game> games=new ArrayList<>();
    games.add(game);
    assertEquals(games,serviceLayer.getAllGames());
}
@Test
public void shouldGetGetAllAndPostConsole(){
    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(8);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    Console consoleFromService=serviceLayer.addConsole(console);
    console.setId(1);
    assertEquals(console,consoleFromService);
    assertEquals(console,serviceLayer.getConsole(1));
    List<Console> consoles=new ArrayList<>();
    consoles.add(console);
    assertEquals(consoles,serviceLayer.getAllConsoles());
}
@Test
public void shouldGetGetAllAndPostTShirt(){
    TShirt tShirt=new TShirt();
    tShirt.setPrice(BigDecimal.valueOf(7.77));
    tShirt.setColor("red");
    tShirt.setDescription("ugly");
    tShirt.setSize("xxxxxxxxxxxxxxxxl");
    tShirt.setQuantity(679);
    TShirt tShirtFromService=serviceLayer.addTShirt(tShirt);
    tShirt.setId(6);
    assertEquals(tShirt,tShirtFromService);
    assertEquals(tShirt,serviceLayer.getTShirt(6));
    List<TShirt> tShirts=new ArrayList<>();
    tShirts.add(tShirt);
    assertEquals(tShirts,serviceLayer.getAllTShirts());
}
@Test
public void shouldGetGetAllAndPostInvoice(){
    InvoiceViewModel ivm = new InvoiceViewModel();
    ivm.setCity("city");
    ivm.setName("name");
    ivm.setState("IL");
    ivm.setStreet("street");
    ivm.setQuantity(7);
    ivm.setProcessingFee(BigDecimal.valueOf(14.99));
    ivm.setSubtotal(BigDecimal.valueOf(54.39));
    ivm.setTotal(BigDecimal.valueOf(72.0995));
    ivm.setTax(BigDecimal.valueOf(2.7195));
    ivm.setZipcode("66666");
    ivm.setUnitPrice(BigDecimal.valueOf(7.77));

    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(8);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    ivm.setItem(console);
    ivm=serviceLayer.saveInvoiceViewModel(ivm);
    InvoiceViewModel returnedIvm=serviceLayer.findInvoiceViewModel(ivm.getId());
    assertEquals(ivm,returnedIvm);
    List<InvoiceViewModel> invoiceViewModels=new ArrayList<>();
    invoiceViewModels.add(ivm);
    assertEquals(invoiceViewModels,serviceLayer.getAllInvoiceViewModels());

}
@Test
public void shouldGetTax(){
    Tax tax=new Tax();
    tax.setRate(BigDecimal.valueOf(0.05));
    tax.setState("IL");
    assertEquals(tax,serviceLayer.getTax("IL"));
}
@Test
public void shouldGetProcessingFee(){
    ProcessingFee processingFee=new ProcessingFee();
    processingFee.setFee(BigDecimal.valueOf(1.49));
    processingFee.setProduct_type("Games");
    assertEquals(processingFee,serviceLayer.getProcessingFee("Games"));
}
@Test
public void shouldGetGameByStudioRatingAndTitle(){
    Game game=new Game();
    game.setPrice(BigDecimal.valueOf(7.77));
    game.setDescription("default description");
    game.setEsrbRating("bad");
    game.setStudio("Studio 1");
    game.setTitle("gameName");
    game.setQuantity(6);
    game.setId(5);
    List<Game> games=new ArrayList<>();
    games.add(game);
    assertEquals(games,serviceLayer.getAllGamesByStudio("Studio 1"));
    assertEquals(games,serviceLayer.getAllGamesByTitle("game"));
    assertEquals(games,serviceLayer.getAllGamesByRating("bad"));
}
@Test
public void shouldGetConsoleByManufacturer(){
    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(8);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    List<Console> consoles=new ArrayList<>();
    consoles.add(console);
    assertEquals(consoles,serviceLayer.getAllConsolesByManufacturer("Sony"));
}
@Test
public void shouldGetTShirtByColorAndSize(){
    TShirt tShirt=new TShirt();
    tShirt.setPrice(BigDecimal.valueOf(7.77));
    tShirt.setColor("red");
    tShirt.setDescription("ugly");
    tShirt.setSize("xxxxxxxxxxxxxxxxl");
    tShirt.setQuantity(679);
    tShirt.setId(6);
    List<TShirt> tShirts=new ArrayList<>();
    tShirts.add(tShirt);
    assertEquals(tShirts,serviceLayer.getAllTShirtsBySize("xxxxxxxxxxxxxxxxl"));
    assertEquals(tShirts,serviceLayer.getAllTShirtsByColor("red"));
}
@Test
public void shouldCalculateTaxOnCostOfItem(){
    InvoiceViewModel ivm = serviceLayer.findInvoiceViewModel(1);
    double illinoisTaxRate=0.05;
    int quantity=7;
    double unitPrice=7.77;
    assertEquals(BigDecimal.valueOf(illinoisTaxRate*quantity*unitPrice),serviceLayer.getTaxFromInvoice(ivm));

}
@Test
public void shouldOnlyApplyProcessingFeeOncePerOrder(){
        //InvoiceViewModel ivm=serviceLayer.findInvoiceViewModel(1);
        double consoleProcessingFee=14.99;
        assertEquals(BigDecimal.valueOf(consoleProcessingFee),serviceLayer.getProcessingFeeFromInvoice(invoiceDao.getInvoice(1)));
}
@Test
public void shouldCalculateSubTotal(){
    int quantity=7;
    double unitPrice=7.77;
    InvoiceViewModel ivm=serviceLayer.findInvoiceViewModel(1);
    assertEquals(BigDecimal.valueOf(quantity*unitPrice),serviceLayer.getSubTotal(ivm));
}
@Test
public void shouldCalculateTotal(){
    double consoleProcessingFee=14.99;
    int quantity=7;
    double unitPrice=7.77;
    double illinoisTaxRate=0.05;
    double expectedTotal=consoleProcessingFee+(1+illinoisTaxRate)*(quantity*unitPrice);
    InvoiceViewModel ivm=serviceLayer.findInvoiceViewModel(1);
    assertEquals(BigDecimal.valueOf(expectedTotal),serviceLayer.getTotalFromInvoice(ivm));
}
@Test
public void shouldGetItemTypeFromInvoiceViewModel(){
        InvoiceViewModel ivm=serviceLayer.findInvoiceViewModel(1);
        assertEquals("Console",serviceLayer.getItemTypeFromInvoiceViewModel(ivm));
}
//-------------------------------------------Mocks----------------------------------------------------
private void setUpProcessingFeeDaoMock() {
    processingFeeDao=mock(ProcessingFeeDao.class);
    ProcessingFee processingFee=new ProcessingFee();
    processingFee.setFee(BigDecimal.valueOf(1.49));
    processingFee.setProduct_type("Games");
    doReturn(processingFee).when(processingFeeDao).getProcessingFee("Games");
    ProcessingFee processingFee2=new ProcessingFee();
    processingFee2.setFee(BigDecimal.valueOf(14.99));
    processingFee2.setProduct_type("Consoles");
    doReturn(processingFee2).when(processingFeeDao).getProcessingFee("Consoles");
    ProcessingFee processingFee3=new ProcessingFee();
    processingFee3.setFee(BigDecimal.valueOf(1.98));
    processingFee3.setProduct_type("TShirts");
    doReturn(processingFee3).when(processingFeeDao).getProcessingFee("T-Shirts");
}
private void setUpTaxDaoMock() {
    taxDao=mock(TaxDao.class);
    Tax tax=new Tax();
    tax.setRate(BigDecimal.valueOf(0.05));
    tax.setState("IL");
    doReturn(tax).when(taxDao).getTax("IL");
}
private void setUpInvoiceDaoMock() {
    invoiceDao=mock(InvoiceDao.class);
    Invoice consoleInvoice=new Invoice();
    consoleInvoice.setCity("city");
    consoleInvoice.setItemId(1);
    consoleInvoice.setItemType("Console");
    consoleInvoice.setName("name");
    consoleInvoice.setState("IL");
    consoleInvoice.setStreet("street");
    consoleInvoice.setQuantity(7);
    consoleInvoice.setProcessingFee(BigDecimal.valueOf(14.99));
    consoleInvoice.setSubtotal(BigDecimal.valueOf(54.39));
    consoleInvoice.setTotal(BigDecimal.valueOf(72.0995));
    consoleInvoice.setTax(BigDecimal.valueOf(2.7195));
    consoleInvoice.setZipcode("66666");
    consoleInvoice.setUnitPrice(BigDecimal.valueOf(7.77));
    consoleInvoice.setInvoiceId(1);
    Invoice consoleInvoice2=new Invoice();
    consoleInvoice2.setCity("city");
    consoleInvoice2.setItemId(1);
    consoleInvoice2.setItemType("Console");
    consoleInvoice2.setName("name");
    consoleInvoice2.setState("IL");
    consoleInvoice2.setStreet("street");
    consoleInvoice2.setQuantity(7);
    consoleInvoice2.setProcessingFee(BigDecimal.valueOf(14.99));
    consoleInvoice2.setSubtotal(BigDecimal.valueOf(54.39));
    consoleInvoice2.setTotal(BigDecimal.valueOf(72.0995));
    consoleInvoice2.setTax(BigDecimal.valueOf(2.7195));
    consoleInvoice2.setZipcode("66666");
    consoleInvoice2.setUnitPrice(BigDecimal.valueOf(7.77));
    Invoice gameInvoice=new Invoice();
    gameInvoice.setCity("city");
    gameInvoice.setItemId(5);
    gameInvoice.setItemType("Game");
    gameInvoice.setName("name");
    gameInvoice.setState("IL");
    gameInvoice.setStreet("street");
    gameInvoice.setQuantity(7);
    gameInvoice.setZipcode("66666");
    gameInvoice.setProcessingFee(BigDecimal.valueOf(1.49));
    gameInvoice.setSubtotal(BigDecimal.valueOf(54.39));
    gameInvoice.setTotal(BigDecimal.valueOf(58.5995));
    gameInvoice.setTax(BigDecimal.valueOf(2.7195));
    gameInvoice.setUnitPrice(BigDecimal.valueOf(7.77));
    gameInvoice.setInvoiceId(1);
    Invoice gameInvoice2=new Invoice();
    gameInvoice2.setCity("city");
    gameInvoice2.setItemId(5);
    gameInvoice2.setItemType("Game");
    gameInvoice2.setName("name");
    gameInvoice2.setState("IL");
    gameInvoice2.setStreet("street");
    gameInvoice2.setQuantity(7);
    gameInvoice2.setZipcode("66666");
    gameInvoice2.setProcessingFee(BigDecimal.valueOf(1.49));
    gameInvoice2.setSubtotal(BigDecimal.valueOf(54.39));
    gameInvoice2.setTotal(BigDecimal.valueOf(58.5995));
    gameInvoice2.setTax(BigDecimal.valueOf(2.7195));
    gameInvoice2.setUnitPrice(BigDecimal.valueOf(7.77));
    Invoice tShirtInvoice=new Invoice();
    tShirtInvoice.setCity("city");
    tShirtInvoice.setItemId(6);
    tShirtInvoice.setItemType("TShirt");
    tShirtInvoice.setName("name");
    tShirtInvoice.setState("IL");
    tShirtInvoice.setStreet("street");
    tShirtInvoice.setQuantity(17);
    tShirtInvoice.setInvoiceId(3);
    tShirtInvoice.setZipcode("66666");
    tShirtInvoice.setProcessingFee(BigDecimal.valueOf(17.47));
    tShirtInvoice.setSubtotal(BigDecimal.valueOf(132.09));
    tShirtInvoice.setTotal(BigDecimal.valueOf(156.1645));
    tShirtInvoice.setTax(BigDecimal.valueOf(6.6045));
    tShirtInvoice.setUnitPrice(BigDecimal.valueOf(7.77));
    Invoice tShirtInvoice2=new Invoice();
    tShirtInvoice2.setCity("city");
    tShirtInvoice2.setItemId(6);
    tShirtInvoice2.setItemType("TShirt");
    tShirtInvoice2.setName("name");
    tShirtInvoice2.setState("IL");
    tShirtInvoice2.setStreet("street");
    tShirtInvoice2.setQuantity(17);
    tShirtInvoice2.setZipcode("66666");
    tShirtInvoice2.setProcessingFee(BigDecimal.valueOf(17.47));
    tShirtInvoice2.setSubtotal(BigDecimal.valueOf(132.09));
    tShirtInvoice2.setTotal(BigDecimal.valueOf(156.1645));
    tShirtInvoice2.setTax(BigDecimal.valueOf(6.6045));
    tShirtInvoice2.setUnitPrice(BigDecimal.valueOf(7.77));
    List<Invoice> invoiceList = new ArrayList<>();
    invoiceList.add(consoleInvoice);
//    invoiceList.add(gameInvoice);
//    invoiceList.add(tShirtInvoice);
    doReturn(consoleInvoice).when(invoiceDao).addInvoice(consoleInvoice2);
    doReturn(gameInvoice).when(invoiceDao).addInvoice(gameInvoice2);
    doReturn(tShirtInvoice).when(invoiceDao).addInvoice(tShirtInvoice2);
    doReturn(consoleInvoice).when(invoiceDao).getInvoice(1);
    doReturn(invoiceList).when(invoiceDao).getAllInvoices();
}
private void setUpTShirtDaoMock() {
    tShirtDao=mock(TShirtDao.class);
    TShirt tShirt=new TShirt();
    tShirt.setPrice(BigDecimal.valueOf(7.77));
    tShirt.setColor("red");
    tShirt.setDescription("ugly");
    tShirt.setSize("xxxxxxxxxxxxxxxxl");
    tShirt.setQuantity(679);
    tShirt.setId(6);
    TShirt tShirt2=new TShirt();
    tShirt2.setPrice(BigDecimal.valueOf(7.77));
    tShirt2.setColor("red");
    tShirt2.setDescription("ugly");
    tShirt2.setSize("xxxxxxxxxxxxxxxxl");
    tShirt2.setQuantity(679);
    List<TShirt> tShirtList = new ArrayList<>();
    tShirtList.add(tShirt);
    doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
    doReturn(tShirt).when(tShirtDao).getTShirt(6);
    doReturn(tShirtList).when(tShirtDao).getAllTShirts();
    doReturn(tShirtList).when(tShirtDao).getAllTShirtsByColor("red");
    doReturn(tShirtList).when(tShirtDao).getAllTShirtsBySize("xxxxxxxxxxxxxxxxl");
}
private void setUpConsoleDaoMock() {
    consoleDao=mock(ConsoleDao.class);
    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(8);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    Console console2=new Console();
    console2.setPrice(BigDecimal.valueOf(7.77));
    console2.setQuantity(8);
    console2.setProcessor("i7");
    console2.setModel("model 1");
    console2.setMemoryAmount("500 GB");
    console2.setManufacturer("Sony");
    List<Console> consoleList = new ArrayList<>();
    consoleList.add(console);
    doReturn(console).when(consoleDao).addConsole(console2);
    doReturn(console).when(consoleDao).getConsole(1);
    doReturn(consoleList).when(consoleDao).getAllConsoles();
    doReturn(consoleList).when(consoleDao).getAllConsolesByManufacturer("Sony");
}
private void setUpGameDaoMock() {
    gameDao=mock(GameDao.class);
    Game game=new Game();
    game.setPrice(BigDecimal.valueOf(7.77));
    game.setDescription("default description");
    game.setEsrbRating("bad");
    game.setStudio("Studio 1");
    game.setTitle("gameName");
    game.setQuantity(6);
    game.setId(5);
    Game game2=new Game();
    game2.setPrice(BigDecimal.valueOf(7.77));
    game2.setDescription("default description");
    game2.setEsrbRating("bad");
    game2.setStudio("Studio 1");
    game2.setTitle("gameName");
    game2.setQuantity(6);
    game2.setId(1);
    List<Game> gameList = new ArrayList<>();
    gameList.add(game);
    doReturn(game).when(gameDao).addGame(game2);
    doReturn(game).when(gameDao).getGame(5);
    doReturn(gameList).when(gameDao).getAllGames();
    doReturn(gameList).when(gameDao).getAllGamesByRating("bad");
    doReturn(gameList).when(gameDao).getAllGamesByStudio("Studio 1");
    doReturn(gameList).when(gameDao).getAllGamesByTitle("game");
}
}