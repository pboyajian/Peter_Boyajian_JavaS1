package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Invoice;
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
public class InvoiceDaoTest {
@Autowired
private InvoiceDao invoiceDao;
private Invoice invoice;
    @Before
    public void setUp() throws Exception {
        invoiceDao.getAllInvoices().forEach(invoice1 -> invoiceDao.deleteInvoice(invoice1.getInvoiceId()));
        invoice=new Invoice();
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
    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd(){

        Invoice invoiceAfterAdding=invoiceDao.addInvoice(invoice);
        invoice.setInvoiceId(invoiceAfterAdding.getInvoiceId());
        assertEquals(invoice,invoiceAfterAdding);
    }

    @Test
    public void shouldDeleteByInvoiceId(){
        Invoice invoiceAfterAdding=invoiceDao.addInvoice(invoice);
        assertEquals(1,invoiceDao.getAllInvoices().size());
        invoiceDao.deleteInvoice(invoiceAfterAdding.getInvoiceId());
        assertEquals(0,invoiceDao.getAllInvoices().size());
    }

    @Test
    public void shouldGetAll(){
        invoiceDao.addInvoice(invoice);
        invoiceDao.addInvoice(invoice);
        assertEquals(2,invoiceDao.getAllInvoices().size());
    }

    @Test
    public void shouldGetOneByInvoiceId(){
        Invoice invoiceAfterAdding=invoiceDao.addInvoice(invoice);
        int id=invoiceAfterAdding.getInvoiceId();
        invoice.setInvoiceId(id);
        assertEquals(invoice, invoiceDao.getInvoice(id));
    }

    @Test
    public void shouldUpdateInvoice(){
        Invoice invoiceAfterAdding=invoiceDao.addInvoice(invoice);
        int id=invoiceAfterAdding.getInvoiceId();
        invoice.setInvoiceId(id);
        invoice.setStreet("new st");
        invoiceDao.updateInvoice(invoice);
        assertEquals(invoice, invoiceDao.getInvoice(id));
    }
}