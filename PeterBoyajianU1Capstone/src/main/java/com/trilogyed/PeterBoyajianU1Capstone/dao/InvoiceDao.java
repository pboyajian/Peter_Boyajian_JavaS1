package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice getInvoice(int id );
    List<Invoice> getAllInvoices();
    void deleteInvoice(int id);
    void updateInvoice(Invoice invoice);
    Invoice addInvoice(Invoice invoice);
}
