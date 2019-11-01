package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
import com.trilogyed.PeterBoyajianU1Capstone.model.Invoice;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceViewModelController.class)
public class InvoiceViewModelControllerTest {
@Autowired
private MockMvc mockMvc;
@MockBean
private ServiceLayer serviceLayer;
private JacksonTester<Invoice> invoiceJacksonTester;
private JacksonTester<InvoiceViewModel> invoiceViewModelJacksonTester;
private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        invoice=new Invoice();
        invoice.setCity("city");
        invoice.setName("name");
        invoice.setState("IL");
        invoice.setStreet("street");
        invoice.setQuantity(7);
        invoice.setZipcode("66666");
        invoice.setItemType("Console");
        invoice.setItemId(1);
    }
    @Test
    public void shouldCreateInvoiceViewModel() throws Exception {
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
        ivm.setInvoiceId(1);
        Console console=new Console();
        console.setPrice(BigDecimal.valueOf(7.77));
        console.setQuantity(6);
        console.setProcessor("i7");
        console.setModel("model 1");
        console.setMemoryAmount("500 GB");
        console.setManufacturer("Sony");
        console.setId(1);
        ivm.setItem(console);

        given(serviceLayer.saveInvoiceViewModel(invoice)).willReturn(ivm);
        MockHttpServletResponse createResponse = mockMvc.perform(
                post("/purchase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invoiceJacksonTester
                                .write(invoice)
                                .getJson()))
                .andReturn().getResponse();
        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(createResponse.getContentAsString()).isEqualTo(invoiceViewModelJacksonTester.write(ivm).getJson());
    }
}