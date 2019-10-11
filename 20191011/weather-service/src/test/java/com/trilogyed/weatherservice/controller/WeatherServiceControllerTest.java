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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    private WeatherServiceController weatherServiceController;
    @Before
    public void setUp() throws Exception{
        weatherServiceController=new WeatherServiceController();
    }


    @Test
    public void shouldReturnTemperatureGivenZipcode() throws Exception{
        int zipcode=12345;
        Temperature temp=new Temperature(23455);
        temp.setTempInKelvin(zipcode/300.0-33);
        mockMvc.perform(get("/temp/{zipcode}",zipcode)
                        .content(mapper.writeValueAsString(new Temperature(zipcode)))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(temp)));
    }


    @Test
    public void shouldReturnConditionsGivenZipcode() throws Exception{
        int zipcode=12345;
        Conditions weather=new Conditions(new Temperature(23455),7,"West","Cloudy","It gon rain");
        mockMvc.perform(get("/temp/{zipcode}",zipcode)
                .content(mapper.writeValueAsString(new Temperature(zipcode)))
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(mapper.writeValueAsString(weather)));
    }
}