package com.trilogyed.PeterBoyajianU1Capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.PeterBoyajianU1Capstone.model.Console;
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
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ServiceLayer serviceLayer;
    private JacksonTester<Console> consoleJacksonTester;
    private JacksonTester<List<Console>> consoleListJacksonTester;
    private Console console;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        console=new Console();
        console.setPrice(BigDecimal.valueOf(7.77));
        console.setQuantity(6);
        console.setProcessor("i7");
        console.setModel("model 1");
        console.setMemoryAmount("500 GB");
        console.setManufacturer("Sony");
    }
    @Test
    public void shouldGetAllConsoles() throws Exception {
        console.setId(1);
        List<Console> consoles =new ArrayList<Console>(){
            {add(console);}};
        given(serviceLayer.getAllConsoles())
                .willReturn(consoles);

        MockHttpServletResponse response = mockMvc.perform(
                get("/console")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(consoleListJacksonTester.write(consoles).getJson());
    }
    @Test
    public void shouldGetConsoleById() throws Exception{
        console.setId(1);
        given(serviceLayer.getConsole(1))
                .willReturn(console);

        MockHttpServletResponse response = mockMvc.perform(
                get("/console/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                consoleJacksonTester.write(console).getJson());
    }
    @Test
    public void shouldCreateUpdateAndDeleteConsole() throws Exception {
        Console consoleAdded = console;
        consoleAdded.setId(1);

        given(serviceLayer.addConsole(console)).willReturn(consoleAdded);
        MockHttpServletResponse createResponse = mockMvc.perform(
                post("/console")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(consoleJacksonTester
                                .write(console)
                                .getJson()))
                .andReturn().getResponse();
        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(createResponse.getContentAsString()).isEqualTo(consoleJacksonTester.write(consoleAdded).getJson());

        Console console2=console;
        console2.setManufacturer("newman");
        MockHttpServletResponse updateResponse = mockMvc.perform(
                put("/console")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(consoleJacksonTester
                                .write(console2)
                                .getJson()))
                .andReturn().getResponse();

        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.ACCEPTED.value());

        MockHttpServletResponse deleteResponse = mockMvc.perform(
                delete("/console/1"))
                .andReturn().getResponse();

        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }
    @Test
    public void shouldGetAllConsolesByManufacturer() throws Exception {
        console.setId(1);
        List<Console> consoles=new ArrayList<Console>();
        consoles.add(console);
        given(serviceLayer.getAllConsolesByManufacturer("Sony")).willReturn(consoles);

        MockHttpServletResponse response = mockMvc.perform(
                get("/console/manufacturer/Sony")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(consoleListJacksonTester.write(consoles).getJson());

    }
    @Test
    public void shouldReturn422WhenInvalidInput() throws Exception {

        MockHttpServletResponse addEmptyStringResponse = mockMvc.perform(
                post("/console").contentType(MediaType.APPLICATION_JSON)
                        .content(consoleJacksonTester.write(new Console()).getJson())
        ).andReturn().getResponse();

        assertThat(addEmptyStringResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());

        MockHttpServletResponse addNullResponse = mockMvc.perform(
                post("/console").contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(addNullResponse.getStatus()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}