package com.example.creditcardservice.controller;

import com.example.creditcardservice.dao.AccountRepo;
import com.example.creditcardservice.dto.Account;
import com.example.creditcardservice.exceptions.NotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/creditcard")
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody @Valid Account account) {
        return accountRepo.save(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAccount(@RequestBody @Valid Account account) {
        accountRepo.save(account);
    }

    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable int id) {
        Optional<Account> account = accountRepo.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new NotFoundException("Did not find an account with credit card number " + id);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountById(@PathVariable int id) throws JsonMappingException {
        Optional<Account> account = accountRepo.findById(id);
        if (account.isPresent()) {
            accountRepo.deleteById(id);
        } else {
            throw new NotFoundException("Did not find an account with credit card number" + id);
        }
    }
    @PutMapping(value = "/debitfunds/{cardNumber}/{debitAmount}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void debitFunds(@PathVariable Integer cardNumber,Double debitAmount){
        Optional<Account> account = accountRepo.findById(cardNumber);
        if (account.isPresent()) {
             account.get().setBalanceAmount(account.get().getBalanceAmount()+debitAmount);
        } else {
            throw new NotFoundException("Did not find an account with credit card number " + cardNumber);
        }
    }

}