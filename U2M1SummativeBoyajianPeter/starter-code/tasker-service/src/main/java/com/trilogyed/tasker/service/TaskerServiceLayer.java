package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    private TaskerDao dao;
    private AdServerClient adServerClient;

    public TaskerServiceLayer(TaskerDao dao,AdServerClient adServerClient) {
        this.dao = dao;
        this.adServerClient=adServerClient;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        String ad=adServerClient.getAd();
        tvm.setAdvertisement(ad);

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks=dao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        tasks.forEach(task->taskViewModels.add(fetchTask(task.getId())));
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks=dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = new ArrayList<>();
        tasks.forEach(task->taskViewModels.add(fetchTask(task.getId())));
        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        String ad=adServerClient.getAd();
        taskViewModel.setAdvertisement(ad);
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task=new Task();
        task.setId(taskViewModel.getId());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setDescription(taskViewModel.getDescription());
        dao.updateTask(task);
    }
}
