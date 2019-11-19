package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
    @Autowired
    private TaskerDao taskerDao;
    private Task task;

    @Before
    public void setUp() throws Exception {
        taskerDao.getAllTasks().forEach(task1 -> taskerDao.deleteTask(task1.getId()));
        task = new Task();
        task.setDescription("description");
        task.setDueDate(LocalDate.parse("2019-11-11"));
        task.setCreateDate(LocalDate.parse("2019-11-11"));
        task.setCategory("category");

    }

    @Test
    public void shouldBeInDatabaseAfterWeAdd() {
        Task taskAfterAdding = taskerDao.createTask(task);
        task.setId(taskAfterAdding.getId());
        assertEquals(task, taskAfterAdding);
    }

    @Test
    public void shouldDeleteById() {
        Task taskAfterAdding = taskerDao.createTask(task);
        assertEquals(1, taskerDao.getAllTasks().size());
        taskerDao.deleteTask(taskAfterAdding.getId());
        assertEquals(0, taskerDao.getAllTasks().size());
    }

    @Test
    public void shouldGetAll() {
        taskerDao.createTask(task);
        taskerDao.createTask(task);
        assertEquals(2, taskerDao.getAllTasks().size());
    }

    @Test
    public void shouldGetOneById() {
        Task taskAfterAdding = taskerDao.createTask(task);
        int id = taskAfterAdding.getId();
        task.setId(id);
        assertEquals(task, taskerDao.getTask(id));
    }

    @Test
    public void shouldUpdateTask() {
        Task taskAfterAdding = taskerDao.createTask(task);
        int id = taskAfterAdding.getId();
        task.setId(id);
        task.setDescription("updated description");
        taskerDao.updateTask(task);
        assertEquals(task, taskerDao.getTask(id));
    }

    @Test
    public void shouldGetAllByCategory() {
        taskerDao.createTask(task);
        taskerDao.createTask(task);
        assertEquals(2, taskerDao.getTasksByCategory("category").size());
        assertEquals(0, taskerDao.getTasksByCategory("shmategory").size());
    }

}