package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.exceptions.InvalidQuantityException;
import com.trilogyed.PeterBoyajianU1Capstone.model.Invoice;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/purchase")
public class InvoiceViewModelController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createInvoiceViewModel(@RequestBody @Valid Invoice invoice){
        InvoiceViewModel ivm= serviceLayer.saveInvoiceViewModel(invoice);
        return ivm;
    }

}
