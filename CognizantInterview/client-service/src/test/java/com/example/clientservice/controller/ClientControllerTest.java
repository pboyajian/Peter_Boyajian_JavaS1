package com.example.clientservice.controller;

import com.example.clientservice.model.Account;
import com.example.clientservice.util.feign.AccountClient;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountClient accountRepo;
    private JacksonTester<Account> accountJacksonTester;
    private JacksonTester<List<Account>> accountListJacksonTester;
    private Account account;
    private static final double BALANCE_THAT_EXISTS = 1000;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        account = new Account();
        account.setBalanceAmount(BALANCE_THAT_EXISTS);
    }
    @Test
    public void shouldGetAccountById() throws Exception {
        account.setId(1);
        Optional<Account> optionalAccount = Optional.of(account);
        given(accountRepo.getAccountById(1))
                .willReturn(optionalAccount.get());

        MockHttpServletResponse response = mockMvc.perform(
                get("/creditcard/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                accountJacksonTester.write(account).getJson());
    }
    @Test
    public void shouldDebitFunds() throws Exception {
        Account accountToUpdate = account;
        accountToUpdate.setId(1);
        MockHttpServletResponse updateResponse = mockMvc.perform(
                put("/creditcard/debitfunds/{1}/{1000}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJacksonTester
                                .write(accountToUpdate)
                                .getJson()))
                .andReturn().getResponse();

        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());
        account.setId(1);
        Optional<Account> optionalAccount = Optional.of(account);
        given(accountRepo.getAccountById(1))
                .willReturn(optionalAccount.get());
        Account accountExpected = new Account();
        accountExpected.setId(1);
        accountExpected.setBalanceAmount(2000);
//        Optional<Account> accountExpected = Optional.of(account);
        MockHttpServletResponse response = mockMvc.perform(
                get("/creditcard/",Integer.valueOf(1))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                accountJacksonTester.write(accountExpected).getJson());
    }

}