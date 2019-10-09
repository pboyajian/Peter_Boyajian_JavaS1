package com.company.recordstore.controller;

import com.company.recordstore.models.Record;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RecordStoreController.class)
public class RecordStoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //ObjectMapper user to convert Java objects to JSON and vice-versa
    private ObjectMapper mapper=new ObjectMapper();

    private List<Record> recordList;
    @Before
    public void setUp() throws Exception{
        recordList=new ArrayList<>();
        recordList.add(new Record("Eagles","Greatest Hits1"));
        recordList.add(new Record("Eagles2","Greatest Hits2"));
        recordList.add(new Record("Eagles3","Greatest Hits3"));
        recordList.add(new Record("Eagles4","Greatest Hits4"));
    }
    @Test
    public void shouldReturnAllRecordsInCollection() throws Exception{
        String outputJson =mapper.writeValueAsString(recordList);
        mockMvc.perform(get("/records"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldCreateANewRecord() throws Exception{
        String inputJson =mapper.writeValueAsString(new Record("BelVilDevoe","recordName"));
        String outputJson =mapper.writeValueAsString(new Record("BelVilDevoe","recordName",5));
        mockMvc.perform(
                post("/records")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldRetrieveAnExistingRecord() throws Exception{
        String outputJson =mapper.writeValueAsString(recordList.get(3));
        mockMvc.perform(
                get("/records/{ix} ",4)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test

    public void shouldUpdateExistingRecord() throws Exception{
        String inputJson=mapper.writeValueAsString(new Record("name","album",3));
        String outputJson=mapper.writeValueAsString(new Record("name","album",3));
        mockMvc.perform(
                put("/records/{ix} ",3)
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().json(outputJson));
    }
    @Test

    public void shouldDeleteExistingRecord() throws Exception{
        mockMvc.perform(
                delete("/records/{ix} ",4)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidId() throws Exception {
        // build parameters and expected output if necessary...
        short year=2000;
        String inputJson =mapper.writeValueAsString(new Record("akjsdlf","recordName",-1,year));
        // act
        mockMvc.perform(
                post("/records")                            //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("invalid id")));
                //.andExpect(content().string(containsString("<if theres another error message>")))
                //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }

    @Test
    public void shouldHandle422WhenWeUpdateInvalidId() throws Exception {
        // build parameters and expected output if necessary...
        short year=2000;
        String inputJson =mapper.writeValueAsString(new Record("akjsdlf","recordName",-1,year));
        // act
        mockMvc.perform(
                put("/records/{ix}",-1)                            //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("invalid id")));
        //.andExpect(content().string(containsString("<if theres another error message>")))
        //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }

    @Test
    public void shouldHandle404WhenWeEnterInvalidId() throws Exception {
        // build parameters and expected output if necessary...

        //String inputJson =mapper.writeValueAsString(new Record("akjsdlf","recordName",-1,year));
        // act
        mockMvc.perform(
                get("/records/{ix}",-1)                            //perform the post
  // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isNotFound())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("not found")));
        //.andExpect(content().string(containsString("<if theres another error message>")))
        //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidArtist() throws Exception {
        // build parameters and expected output if necessary...
        short year=2000;
        String inputJson =mapper.writeValueAsString(new Record("","recordName",10,year));
        // act
        mockMvc.perform(
                post("/records")                            //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("artist")));
        //.andExpect(content().string(containsString("<if theres another error message>")))
        //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }

    @Test
    public void shouldHandle422WhenWeEnterInvalidAlbum() throws Exception {
        // build parameters and expected output if necessary...
        short year=2000;
        String inputJson =mapper.writeValueAsString(new Record("sdadsf","",10,year));
        // act
        mockMvc.perform(
                post("/records")                            //perform the post
                        .content(inputJson)                         // set the request body
                        .contentType(MediaType.APPLICATION_JSON)   // add the header (Postman helps us with this when we
                //                 use Postman)
        )
                .andDo(print())                                 // print the output
                .andExpect(status().isUnprocessableEntity())   //assert     // we should have gotten back a 201 - created
                .andExpect(content().string(containsString("album")));
        //.andExpect(content().string(containsString("<if theres another error message>")))
        //.andExpect(content().string(containsString("<you can do as many matches as you need>")));       // our json should match


    }

    }

