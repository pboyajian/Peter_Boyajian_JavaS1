package com.trilogyed.monthconverter.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MonthConverterController.class)
public class MonthConverterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MonthConverterController monthConverterController;
    @Before
    public void setUp() throws Exception{
        monthConverterController=new MonthConverterController();
    }

    @Test
    public void shouldGetTheNameOfAMonth(){
        int input=5;
        String output="May";
        assertEquals(output,monthConverterController.getMonthName(input));

    }

    @Test
    public void shouldReturnMonthNameMatchingNumberProvided() throws Exception{
        int inputNum=1;
        String output ="January";
        mockMvc.perform(get("/day/{monthNumber}",inputNum))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(output)));
    }


    @Test
    public void shouldHandle418WhenWeEnterNumberOutOfBounds() throws Exception {
        // build parameters and expected output if necessary...
        short inputNum=13;
        // act
        mockMvc.perform(get("/day/{monthNumber}",inputNum))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().string(containsString("invalid input")));
    }


    }
