package com.example.clientservice.util.feign;

import com.example.clientservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "credit-card-service")
//@RequestMapping(value = "/creditcard")
public interface AccountClient {

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Account createAccount(@RequestBody @Valid Account account);
//
//    @GetMapping
//    public List<Account> getAllAccounts();
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void updateAccount(@RequestBody @Valid Account account);

    @GetMapping(value = "/creditcard/{id}")
    public Account getAccountById(@PathVariable int id);

//    @DeleteMapping(value = "/creditcard/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteAccountById(@PathVariable int id);

    @PutMapping(value = "/creditcard/debitfunds/{cardNumber}/{debitAmount}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void debitFunds(@PathVariable Integer cardNumber,Double debitAmount);
}
