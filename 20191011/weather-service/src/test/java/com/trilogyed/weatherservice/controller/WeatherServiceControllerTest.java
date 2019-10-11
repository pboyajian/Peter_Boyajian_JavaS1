package com.trilogyed.weatherservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.weatherservice.models.Conditions;
import com.trilogyed.weatherservice.models.Temperature;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherServiceController.class)
public class WeatherServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper=new ObjectMapper();
//    private WeatherServiceController weatherServiceController;

    @Before
    public void setUp() throws Exception{
//        weatherServiceController=new WeatherServiceController();
    }


    @Test
    public void shouldReturnTemperatureGivenZipcode() throws Exception{
        int zipcode=12345;
        Temperature temp=new Temperature(zipcode);
        String inputJson=mapper.writeValueAsString(new Temperature(zipcode));
        temp.setTempInKelvin(zipcode/300.0-33);
        temp.setZipcode(zipcode);
        mockMvc.perform(get("/temp/{zipcode}",zipcode)
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(temp)));
    }


    @Test
    public void shouldReturnConditionsGivenZipcode() throws Exception{
        int zipcode=12345;
        Conditions weather=new Conditions(zipcode);
        mockMvc.perform(get("/conditions/{zipcode}",zipcode)
                .content(mapper.writeValueAsString(new Temperature(zipcode)))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(weather)));
    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidZipcode() throws Exception {
        // build parameters and expected output if necessary...
        int zipcode=2000;
        String inputJson =mapper.writeValueAsString(new Temperature(zipcode));
        // act
        mockMvc.perform(
                put("/temp/{zipcode}",zipcode)                            //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("invalid zipcode.")));
        //.andExpect(content().string(containsString("<if theres another error message>")))
        //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }
}