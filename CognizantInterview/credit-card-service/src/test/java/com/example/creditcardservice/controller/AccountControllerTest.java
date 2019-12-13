package com.example.creditcardservice.controller;

import com.example.creditcardservice.dao.AccountRepo;
import com.example.creditcardservice.dto.Account;
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

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AccountRepo accountRepo;
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
    public void shouldGetAllAccount() throws Exception {
        account.setId(1);
        given(accountRepo.findAll())
                .willReturn(new ArrayList<Account>() {
                    {
                        add(account);
                    }
                });

        MockHttpServletResponse response = mockMvc.perform(
                get("/creditcard")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        List<Account> accounts = new ArrayList<Account>() {
            {
                add(account);
            }
        };

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(accountListJacksonTester.write(accounts).getJson());
    }

    @Test
    public void shouldGetAccountById() throws Exception {
        account.setId(1);
        Optional<Account> optionalAccount = Optional.of(account);
        given(accountRepo.findById(1))
                .willReturn(optionalAccount);

        MockHttpServletResponse response = mockMvc.perform(
                get("/creditcard/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                accountJacksonTester.write(account).getJson());
    }

    @Test
    public void shouldCreateUpdateAndDeleteAccount() throws Exception {
        Account accountAdded = account;
        accountAdded.setId(1);

        given(accountRepo.save(account)).willReturn(accountAdded);
        Optional<Account> optionalAccountAdded = Optional.of(account);
        given(accountRepo.findById(1)).willReturn(optionalAccountAdded);
        MockHttpServletResponse createResponse = mockMvc.perform(
                post("/creditcard")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJacksonTester
                                .write(account)
                                .getJson()))
                .andReturn().getResponse();
        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(createResponse.getContentAsString()).isEqualTo(accountJacksonTester.write(accountAdded).getJson());

        Account account2 = account;
        //update account
        //creditcard2.setTitle("new title");
        MockHttpServletResponse updateResponse = mockMvc.perform(
                put("/creditcard")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(accountJacksonTester
                                .write(account2)
                                .getJson()))
                .andReturn().getResponse();

        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());

        MockHttpServletResponse deleteResponse = mockMvc.perform(
                delete("/creditcard/1"))
                .andReturn().getResponse();

        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

//    @Test
//    public void shouldReturn422WhenInvalidInput() throws Exception {
//
//        MockHttpServletResponse addEmptyStringResponse = mockMvc.perform(
//                post("/creditcard").contentType(MediaType.APPLICATION_JSON)
//                        .content(accountJacksonTester.write(new Account()).getJson())
//        ).andReturn().getResponse();
//
//        assertThat(addEmptyStringResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
//
//        MockHttpServletResponse addNullResponse = mockMvc.perform(
//                post("/creditcard").contentType(MediaType.APPLICATION_JSON)
//        ).andReturn().getResponse();
//
//        assertThat(addNullResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
//    }

    @Test
    public void shouldReturn404WhenIdIsInvalid() throws Exception {

        MockHttpServletResponse deleteResponse = mockMvc.perform(
                delete("/creditcard/10"))
                .andReturn().getResponse();

        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());

        MockHttpServletResponse response = mockMvc.perform(
                get("/creditcard/10")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
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
        given(accountRepo.findById(1))
                .willReturn(optionalAccount);
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