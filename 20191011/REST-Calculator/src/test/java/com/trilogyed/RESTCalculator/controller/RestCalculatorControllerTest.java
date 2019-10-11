package com.trilogyed.RESTCalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.RESTCalculator.model.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestCalculatorController.class)
public class RestCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper user to convert Java objects to JSON and vice-versa

    @Autowired
    private ObjectMapper mapper=new ObjectMapper();

    private Calculator calculator;
    @Before
    public void setUp() throws Exception{
calculator=new Calculator(3,7);
    }
    @Test
    public void shouldReturnSum() throws Exception{
     mockMvc.perform(
                post("/add")                            //perform the post
                        .content(mapper.writeValueAsString(calculator))                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("10")));
    }

    @Test
    public void shouldReturnDifference() throws Exception{
        mockMvc.perform(
                post("/subtract")                            //perform the post
                        .content(mapper.writeValueAsString(calculator))                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("-4")));
    }

    @Test
    public void shouldReturnProduct() throws Exception{
        mockMvc.perform(
                post("/mult")                            //perform the post
                        .content(mapper.writeValueAsString(calculator))                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("21")));
    }

    @Test
    public void shouldReturnDividend() throws Exception{
        mockMvc.perform(
                post("/divide")                            //perform the post
                        .content(mapper.writeValueAsString(calculator))                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isCreated())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString((3/7.0)+"")));
    }
}