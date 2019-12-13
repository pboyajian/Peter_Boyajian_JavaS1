package com.example.clientservice.controller;

import com.example.clientservice.exceptions.NotFoundException;
import com.example.clientservice.model.Account;
import com.example.clientservice.util.feign.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping(value = "/creditcard")
public class ClientController {
    @Autowired
    private AccountClient accountRepo;

    @PutMapping(value = "/creditcard/debitfunds/{cardNumber}/{debitAmount}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void debitFunds(@PathVariable Integer cardNumber, Double debitAmount){
     try{accountRepo.debitFunds(cardNumber,debitAmount);}catch
     (Exception e){throw new NotFoundException("Did not find an account with credit card number " + cardNumber);}
    }

    @GetMapping(value = "/creditcard/{cardNumber}")
    public Account getAccountByCardNumber(@PathVariable int cardNumber){
//        try{
            return accountRepo.getAccountById(cardNumber);
//        }catch
//        (Exception e){throw new NotFoundException("Did not find an account with credit card number " + cardNumber);}
    }

}
