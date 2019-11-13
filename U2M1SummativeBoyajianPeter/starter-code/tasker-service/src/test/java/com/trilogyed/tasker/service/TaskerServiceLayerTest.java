package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {
    private TaskerServiceLayer service;
    private TaskerDao taskerDao;
    private Task task;
    private TaskViewModel tvm;
    private AdServerClient adServerClient;
    private String ad;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpAdServerClientMock();
        service = new TaskerServiceLayer(taskerDao, adServerClient);
        ad = "test ad";
    }

    @Test
    public void shouldFetchAndCreateTask() {
        tvm = new TaskViewModel();
        tvm.setDescription("description");
        tvm.setCategory("category");
        tvm.setDueDate(LocalDate.parse("2019-11-11"));
        tvm.setCreateDate(LocalDate.parse("2019-11-11"));
        TaskViewModel tvmExpected = tvm;
        tvmExpected.setAdvertisement(ad);
        tvmExpected.setId(1);
        TaskViewModel tvmCreated = service.newTask(tvm);
        assertEquals(tvmExpected, tvmCreated);
        TaskViewModel tvmRetrieved = service.fetchTask(1);
        assertEquals(tvmExpected, tvmRetrieved);
    }

    @Test
    public void shouldFetchAllTasksEvenByCategory() {
        tvm = new TaskViewModel();
        tvm.setDescription("description");
        tvm.setCategory("category");
        tvm.setDueDate(LocalDate.parse("2019-11-11"));
        tvm.setCreateDate(LocalDate.parse("2019-11-11"));
        tvm.setAdvertisement(ad);
        tvm.setId(1);
        List<TaskViewModel> tasksExpected = new ArrayList<>();
        tasksExpected.add(tvm);
        assertEquals(tasksExpected, service.fetchAllTasks());
        assertEquals(tasksExpected, service.fetchTasksByCategory("category"));
    }

    private void setUpTaskerDaoMock() {
        taskerDao = mock(TaskerDao.class);
        task = new Task();
        task.setDescription("description");
        task.setCategory("category");
        task.setDueDate(LocalDate.parse("2019-11-11"));
        task.setCreateDate(LocalDate.parse("2019-11-11"));
        Task task2 = new Task();
        task2.setDescription("description");
        task2.setCategory("category");
        task2.setDueDate(LocalDate.parse("2019-11-11"));
        task2.setCreateDate(LocalDate.parse("2019-11-11"));
        task2.setId(1);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task2);
        doReturn(task2).when(taskerDao).createTask(task);
        doReturn(task2).when(taskerDao).getTask(1);
        doReturn(tasks).when(taskerDao).getAllTasks();
        doReturn(tasks).when(taskerDao).getTasksByCategory("category");
    }

    private void setUpAdServerClientMock() {
        ad = "test ad";
        adServerClient = mock(AdServerClient.class);
        doReturn(ad).when(adServerClient).getAd();
    }
}
