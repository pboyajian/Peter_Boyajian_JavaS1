package com.trilogyed.tasker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskerController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class TaskerControllerTest {
//    @MockBean
//    private TaskerServiceLayer service;
//    @MockBean
//    AdServerClient adServerClient;
//    @Autowired
//    MockMvc mockMvc;
//    private JacksonTester<TaskViewModel> taskViewModelJacksonTester;
//    private JacksonTester<List<TaskViewModel>> listJacksonTester;
//    private Task task;
//    private TaskViewModel tvm;
//    private String ad;
//
//    @Before
//    public void setUp() throws Exception {
//        JacksonTester.initFields(this,new ObjectMapper());
//        tvm=new TaskViewModel();
//        tvm.setDescription("description");
//        tvm.setCategory("category");
//        tvm.setDueDate(LocalDate.parse("2019-11-11"));
//        tvm.setCreateDate(LocalDate.parse("2019-11-11"));
//    }
//
//
//    @Test
//    public void shouldGetTaskById() throws Exception{
//        tvm.setId(1);
//        given(service.fetchTask(1))
//                .willReturn(tvm);
//
//        MockHttpServletResponse response = mockMvc.perform(
//                get("/tasks/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                taskViewModelJacksonTester.write(tvm).getJson());
//    }
//    @Test
//    public void shouldCreateUpdateAndDeleteTask() throws Exception {
//        TaskViewModel tvmAdded = tvm;
//        tvmAdded.setId(1);
//
//        given(service.newTask(tvm)).willReturn(tvmAdded);
//        given(service.fetchTask(1)).willReturn(tvmAdded);
//        MockHttpServletResponse createResponse = mockMvc.perform(
//                post("/tasks")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(taskViewModelJacksonTester
//                                .write(tvm)
//                                .getJson()))
//                .andReturn().getResponse();
//        assertThat(createResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());
//        assertThat(createResponse.getContentAsString()).isEqualTo(taskViewModelJacksonTester.write(tvmAdded).getJson());
//
//        TaskViewModel tvm2=tvm;
//        tvm2.setCategory("purple");
//        MockHttpServletResponse updateResponse = mockMvc.perform(
//                put("/tasks/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(taskViewModelJacksonTester
//                                .write(tvm2)
//                                .getJson()))
//                .andReturn().getResponse();
//
//        assertThat(updateResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
//
//        MockHttpServletResponse deleteResponse = mockMvc.perform(
//                delete("/tasks/1"))
//                .andReturn().getResponse();
//
//        assertThat(deleteResponse.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
//    }
}