package com.trilogyed.PeterBoyajianU1Capstone.service;

import com.trilogyed.PeterBoyajianU1Capstone.dao.*;
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
public void shouldGetGetAllAndPostGame(){
    Game game=new Game();
    game.setPrice(BigDecimal.valueOf(7.77));
    game.setDescription("default description");
    game.setEsrbRating("bad");
    game.setStudio("Studio 1");
    game.setTitle("gameName");
    game.setQuantity(6);
    Game gameFromService=serviceLayer.addGame(game);
    game.setId(1);
    assertEquals(game,gameFromService);
    assertEquals(game,serviceLayer.getGame(1));
    List<Game> games=new ArrayList<>();
    games.add(game);
    assertEquals(games,serviceLayer.getAllGames());
}
@Test
public void shouldGetGetAllAndPostConsole(){
    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(6);
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
    tShirt.setId(1);
    assertEquals(tShirt,tShirtFromService);
    assertEquals(tShirt,serviceLayer.getTShirt(1));
    List<TShirt> tShirts=new ArrayList<>();
    tShirts.add(tShirt);
    assertEquals(tShirts,serviceLayer.getAllTShirts());
}
@Test
public void shouldGetGetAllAndPostInvoice(){
    InvoiceViewModel ivm = new InvoiceViewModel();
    ivm.setCity("city");
    ivm.setName("name");
    ivm.setState("st");
    ivm.setStreet("street");
    ivm.setQuantity(7);
    ivm.setProcessingFee(BigDecimal.valueOf(8.01));
    ivm.setSubtotal(BigDecimal.valueOf(8.01));
    ivm.setTotal(BigDecimal.valueOf(8.01));
    ivm.setTax(BigDecimal.valueOf(8.01));
    ivm.setZipcode("66666");
    ivm.setUnitPrice(BigDecimal.valueOf(8.01));

    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(6);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    ivm.setItem(console);
    ivm=serviceLayer.saveInvoice(ivm);
    InvoiceViewModel returnedIvm=serviceLayer.findInvoice(ivm.getInvoiceId());
    assertEquals(ivm,returnedIvm);
    List<InvoiceViewModel> invoiceViewModels=new ArrayList<>();
    invoiceViewModels.add(ivm);
    assertEquals(invoiceViewModels,serviceLayer.getAllInvoices());

}
@Test
public void shouldGetTax(){
    Tax tax=new Tax();
    tax.setRate(BigDecimal.valueOf(0.06));
    tax.setState("NY");
    assertEquals(tax,serviceLayer.getTax("NY"));
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
    game.setId(1);
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
    console.setQuantity(6);
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
    tShirt.setId(1);
    List<TShirt> tShirts=new ArrayList<>();
    tShirts.add(tShirt);
    assertEquals(tShirts,serviceLayer.getAllTShirtsBySize("xxxxxxxxxxxxxxxxl"));
    assertEquals(tShirts,serviceLayer.getAllTShirtsByColor("red"));
}
@Test
public void shouldCalculateTaxOnCostOfItem(){
    InvoiceViewModel ivm = new InvoiceViewModel();
    ivm.setCity("city");
    ivm.setName("name");
    ivm.setState("st");
    ivm.setStreet("street");
    ivm.setQuantity(7);
    ivm.setProcessingFee(BigDecimal.valueOf(8.01));
    ivm.setSubtotal(BigDecimal.valueOf(8.01));
    ivm.setTotal(BigDecimal.valueOf(8.01));
    ivm.setTax(BigDecimal.valueOf(8.01));
    ivm.setZipcode("66666");
    ivm.setUnitPrice(BigDecimal.valueOf(8.01));

    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(6);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    ivm.setItem(console);
    ivm=serviceLayer.saveInvoice(ivm);

}
@Test
public void shouldOnlyApplyProcessingFeeOncePerOrder(){}
@Test
public void shouldCalculateTotal(){}
@Test
public void shouldCalculateSubTotal(){}
//-------------------------------------------Mocks----------------------------------------------------
private void setUpProcessingFeeDaoMock() {
    processingFeeDao=mock(ProcessingFeeDao.class);
    ProcessingFee processingFee=new ProcessingFee();
    processingFee.setFee(BigDecimal.valueOf(1.49));
    processingFee.setProduct_type("Games");
    doReturn(processingFee).when(processingFeeDao).getProcessingFee("Games");
}
private void setUpTaxDaoMock() {
    taxDao=mock(TaxDao.class);
    Tax tax=new Tax();
    tax.setRate(BigDecimal.valueOf(0.06));
    tax.setState("NY");
    doReturn(tax).when(taxDao).getTax("NY");
}
private void setUpInvoiceDaoMock() {
    invoiceDao=mock(InvoiceDao.class);
    Invoice invoice=new Invoice();
    invoice.setCity("city");
    invoice.setItemId(1);
    invoice.setItemType("Game");
    invoice.setName("name");
    invoice.setState("st");
    invoice.setStreet("street");
    invoice.setQuantity(7);
    invoice.setProcessingFee(BigDecimal.valueOf(8.01));
    invoice.setSubtotal(BigDecimal.valueOf(8.01));
    invoice.setTotal(BigDecimal.valueOf(8.01));
    invoice.setTax(BigDecimal.valueOf(8.01));
    invoice.setZipcode("66666");
    invoice.setUnitPrice(BigDecimal.valueOf(8.01));
    invoice.setInvoiceId(1);
    Invoice invoice2=new Invoice();
    invoice2.setCity("city");
    invoice2.setItemId(1);
    invoice2.setItemType("Game");
    invoice2.setName("name");
    invoice2.setState("st");
    invoice2.setStreet("street");
    invoice2.setQuantity(7);
    invoice2.setProcessingFee(BigDecimal.valueOf(8.01));
    invoice2.setSubtotal(BigDecimal.valueOf(8.01));
    invoice2.setTotal(BigDecimal.valueOf(8.01));
    invoice2.setTax(BigDecimal.valueOf(8.01));
    invoice2.setZipcode("66666");
    invoice2.setUnitPrice(BigDecimal.valueOf(8.01));
    List<Invoice> invoiceList = new ArrayList<>();
    invoiceList.add(invoice);
    doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
    doReturn(invoice).when(invoiceDao).getInvoice(1);
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
    tShirt.setId(1);
    TShirt tShirt2=new TShirt();
    tShirt2.setPrice(BigDecimal.valueOf(7.77));
    tShirt2.setColor("red");
    tShirt2.setDescription("ugly");
    tShirt2.setSize("xxxxxxxxxxxxxxxxl");
    tShirt2.setQuantity(679);
    List<TShirt> tShirtList = new ArrayList<>();
    tShirtList.add(tShirt);
    doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
    doReturn(tShirt).when(tShirtDao).getTShirt(1);
    doReturn(tShirtList).when(tShirtDao).getAllTShirts();
    doReturn(tShirtList).when(tShirtDao).getAllTShirtsByColor("red");
    doReturn(tShirtList).when(tShirtDao).getAllTShirtsBySize("xxxxxxxxxxxxxxxxl");
}
private void setUpConsoleDaoMock() {
    consoleDao=mock(ConsoleDao.class);
    Console console=new Console();
    console.setPrice(BigDecimal.valueOf(7.77));
    console.setQuantity(6);
    console.setProcessor("i7");
    console.setModel("model 1");
    console.setMemoryAmount("500 GB");
    console.setManufacturer("Sony");
    console.setId(1);
    Console console2=new Console();
    console2.setPrice(BigDecimal.valueOf(7.77));
    console2.setQuantity(6);
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
    game.setId(1);
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
    doReturn(game).when(gameDao).getGame(1);
    doReturn(gameList).when(gameDao).getAllGames();
    doReturn(gameList).when(gameDao).getAllGamesByRating("bad");
    doReturn(gameList).when(gameDao).getAllGamesByStudio("Studio 1");
    doReturn(gameList).when(gameDao).getAllGamesByTitle("game");
}
}