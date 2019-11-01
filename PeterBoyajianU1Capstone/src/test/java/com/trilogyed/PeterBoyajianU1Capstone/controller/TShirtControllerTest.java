package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.PeterBoyajianU1Capstone.model.TShirt;
import com.trilogyed.PeterBoyajianU1Capstone.service.ServiceLayer;
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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceLayer serviceLayer;
    private JacksonTester<TShirt> tShirtJacksonTester;
    private JacksonTester<List<TShirt>> tShirtListJacksonTester;
    private TShirt tShirt;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        tShirt=new TShirt();
        tShirt.setPrice(BigDecimal.valueOf(7.77));
        tShirt.setColor("red");
        tShirt.setDescription("ugly");
        tShirt.setSize("xxxxxxxxxxxxxxxxl");
        tShirt.setQuantity(679);
    }
    @Test
    public void shouldGetAllTShirts() throws Exception {
        tShirt.setId(1);
        List<TShirt> tShirts =new ArrayList<TShirt>(){
            {add(tShirt);}};
        given(serviceLayer.getAllTShirts())
                .willReturn(tShirts);

        MockHttpServletResponse response = mockMvc.perform(
                get("/tShirt")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(tShirtListJacksonTester.write(tShirts).getJson());
    }
    @Test
    public void shouldGetTShirtById() throws Exception{
        tShirt.setId(1);
        given(serviceLayer.getTShirt(1))
                .willReturn(tShirt);

        MockHttpServletResponse response = mockMvc.perform(
                get("/tShirt/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                tShirtJacksonTester.write(tShirt).getJson());
    }
    @Test
    public void shouldCreateUpdateAndDeleteTShirt() throws Exception {
        TShirt tShirtAdded = tShirt;
        tShirtAdded.setId(1);

        given(serviceLayer.addTShirt(tShirt)).willReturn(tShirtAdded);
        MockHttpServletResponse createResponse = mockMvc.perform(
                post("/tShirt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tShirtJacksonTester
                                .write(tShirt)
                                .getJson()))
                .andReturn().getResponse();
        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(createResponse.getContentAsString()).isEqualTo(tShirtJacksonTester.write(tShirtAdded).getJson());

        TShirt tShirt2=tShirt;
        tShirt2.setColor("green");
        MockHttpServletResponse updateResponse = mockMvc.perform(
                put("/tShirt")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tShirtJacksonTester
                                .write(tShirt2)
                                .getJson()))
                .andReturn().getResponse();

        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());

        MockHttpServletResponse deleteResponse = mockMvc.perform(
                delete("/tShirt/1"))
                .andReturn().getResponse();

        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }
    @Test
    public void shouldGetAllTShirtsByGroups() throws Exception {
        tShirt.setId(1);
        List<TShirt> tShirts=new ArrayList<TShirt>();
        tShirts.add(tShirt);
        given(serviceLayer.getAllTShirtsByColor("red")).willReturn(tShirts);
        given(serviceLayer.getAllTShirtsBySize("xxxxxxxxxxxxxxxxl")).willReturn(tShirts);

        MockHttpServletResponse response = mockMvc.perform(
                get("/tShirt/color/red")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(tShirtListJacksonTester.write(tShirts).getJson());

         response = mockMvc.perform(
                get("/tShirt/size/xxxxxxxxxxxxxxxxl")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(tShirtListJacksonTester.write(tShirts).getJson());

    }
    @Test
    public void shouldReturn422WhenInvalidInput() throws Exception {

        MockHttpServletResponse addEmptyStringResponse = mockMvc.perform(
                post("/tShirt").contentType(MediaType.APPLICATION_JSON)
                        .content(tShirtJacksonTester.write(new TShirt()).getJson())
        ).andReturn().getResponse();

        assertThat(addEmptyStringResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());

        MockHttpServletResponse addNullResponse = mockMvc.perform(
                post("/tShirt").contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(addNullResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}