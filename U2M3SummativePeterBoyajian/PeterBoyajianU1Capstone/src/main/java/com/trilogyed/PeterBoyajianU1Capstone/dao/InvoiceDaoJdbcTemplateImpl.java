package com.trilogyed.PeterBoyajianU1Capstone.dao;

import com.trilogyed.PeterBoyajianU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    private static final String SELECT_ALL_INVOICES_SQL="select * from invoice";
    private static final String DELETE_INVOICE_SQL="delete from invoice where invoice_id=?";
    private static final String SELECT_INVOICE_BY_ID_SQL="select * from invoice where invoice_id=?";
    private static final String UPDATE_INVOICE_SQL="update invoice set " +
            "city=?," +
            "state=?," +
            "street=?," +
            "zipcode=?," +
            "item_id=?," +
            "item_type=?, " +
            "name=?, " +
            "quantity=?, " +
            "processing_fee=?, " +
            "subtotal=?, " +
            "total=?, " +
            "tax=?, " +
            "unit_price=? " +
            "where invoice_id=?";
    private static final String INSERT_INVOICE_SQL="insert into invoice (" +
            "city," +
            "state," +
            "street," +
            "zipcode," +
            "item_id," +
            "item_type," +
            "name," +
            "quantity," +
            "processing_fee," +
            "subtotal," +
            "total," +
            "tax," +
            "unit_price) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_INVOICES_BY_MANUFACTURER_SQL="select * from invoice where manufacturer=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice=new Invoice();
        invoice.setCity(rs.getString("city"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setName(rs.getString("name"));
        invoice.setState(rs.getString("state"));
        invoice.setStreet(rs.getString("street"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTotal(rs.getBigDecimal("total"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        return invoice;
    }
    @Override
    public Invoice getInvoice(int id) {
        try{return jdbcTemplate.queryForObject(SELECT_INVOICE_BY_ID_SQL,this::mapRowToInvoice,id);}
        catch(EmptyResultDataAccessException erdae){
            System.out.println("We caught an exception: "+erdae.getMessage());
            return null;}
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL,this::mapRowToInvoice);
    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL,id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getCity(),
                invoice.getState(),
                invoice.getStreet(),
                invoice.getZipcode(),
                invoice.getItemId(),
                invoice.getItemType(),
                invoice.getName(),
                invoice.getQuantity(),
                invoice.getProcessingFee(),
                invoice.getSubtotal(),
                invoice.getTotal(),
                invoice.getTax(),
                invoice.getUnitPrice(),
                invoice.getInvoiceId());
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getCity(),
                invoice.getState(),
                invoice.getStreet(),
                invoice.getZipcode(),
                invoice.getItemId(),
                invoice.getItemType(),
                invoice.getName(),
                invoice.getQuantity(),
                invoice.getProcessingFee(),
                invoice.getSubtotal(),
                invoice.getTotal(),
                invoice.getTax(),
                invoice.getUnitPrice());
        int id=jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        invoice.setInvoiceId(id);
        return invoice;
    }
}
