package com.trilogyed.cityservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.cityservice.models.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityServiceController.class)
public class CityServiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper user to convert Java objects to JSON and vice-versa
    private ObjectMapper mapper=new ObjectMapper();

    private List<City> cityList;
    @Before
    public void setUp() throws Exception{
        cityList=new ArrayList<>();
        cityList.add(new City("City1","State1",1,true));
        cityList.add(new City("City2","State2",2));
        cityList.add(new City("City3","State3",3,true));
        cityList.add(new City("City4","State4",4));
        cityList.add(new City("City5","State5",5,true));
        cityList.add(new City("City6","State6",6));
        cityList.add(new City("City7","State7",7,true));
        cityList.add(new City("City8","State8",8));
        cityList.add(new City("City9","State9",9,true));
    }
    @Test
    public void shouldReturnAllCitiesInCityList() throws Exception{
        String outputJson =mapper.writeValueAsString(cityList);
        mockMvc.perform(get("/city"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldCreateANewCity() throws Exception{
        String inputJson =mapper.writeValueAsString(new City("City10","State10",10));
        String outputJson =mapper.writeValueAsString(new City("City10","State10",10));
        mockMvc.perform(
                post("/city")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldRetrieveAnExistingCity() throws Exception{
        String outputJson =mapper.writeValueAsString(
                new City("City4","State4",4));
        mockMvc.perform(
                get("/city/{name}","City4")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldDeleteAnExistingCity() throws Exception{
        String outputJson =mapper.writeValueAsString(
                new City("City4","State4",4));
        mockMvc.perform(
                delete("/city/{name}","City4")
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}