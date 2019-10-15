package com.trilogyed.U1M4SummativeBoyajianPeter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.U1M4SummativeBoyajianPeter.models.Answer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(U1M4SummativeBoyajianPeterController.class)
public class U1M4SummativeBoyajianPeterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper user to convert Java objects to JSON and vice-versa
    private ObjectMapper mapper=new ObjectMapper();


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldGetRandomQuote() throws Exception{
        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{"+'"'+"author"+'"'+":")))
                .andExpect(content().string(containsString(","+'"'+"quote"+'"'+":")));
    }
    @Test
    public void shouldGetRandomDefinition() throws Exception{
        mockMvc.perform(get("/word"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{"+'"'+"word"+'"'+":")))
                .andExpect(content().string(containsString(","+'"'+"definition"+'"'+":")));
    }

    @Test
    public void shouldGetRandomAnswer() throws Exception{
        String question="test question?";
        String inputJson =mapper.writeValueAsString(new Answer(question));
        mockMvc.perform(
                post("/magic")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{"+'"'+"question"+'"'+":")))
                .andExpect(content().string(containsString(question)))
                .andExpect(content().string(containsString(","+'"'+"answer"+'"'+":")));
    }

    @Test
    public void shouldHandle422WhenWeEnterBlankQuestion() throws Exception {
        String inputJson =mapper.writeValueAsString(new Answer(""));
        // act
        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().string(containsString("must not be empty")));
}
}