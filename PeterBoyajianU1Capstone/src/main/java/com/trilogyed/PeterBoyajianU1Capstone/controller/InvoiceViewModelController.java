package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
import com.trilogyed.PeterBoyajianU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/purchase")
public class InvoiceViewModelController {
    @Autowired
    private ServiceLayer serviceLayer;
    @PostMapping
    public InvoiceViewModel createInvoiceViewModel(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
        return serviceLayer.saveInvoiceViewModel(invoiceViewModel);
    }

}
