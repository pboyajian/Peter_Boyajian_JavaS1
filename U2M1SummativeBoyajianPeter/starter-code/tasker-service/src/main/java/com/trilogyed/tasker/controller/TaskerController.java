package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {
    @Autowired
    private AdServerClient adServerClient;
    @Autowired
    private TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @PostMapping(value = "/tasks")
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel tvm) {
        return service.newTask(tvm);
    }

    @PutMapping(value = "/tasks")
    public void updateTask(@RequestBody @Valid TaskViewModel tvm) {
        service.updateTask(tvm);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @GetMapping(value = "/tasks/id")
    public TaskViewModel findTaskById(@PathVariable int id){
        return service.fetchTask(id);
    }

    @GetMapping(value = "/tasks/category/{category}")
    public List<TaskViewModel> findTasksByCategory(@PathVariable String category){
        return service.fetchTasksByCategory(category);
    }
    @GetMapping(value = "/tasks")
    public List<TaskViewModel> findAllTasks(){
        return service.fetchAllTasks();
    }
    @GetMapping(value = "/ad")
    public String getAd() {
        return adServerClient.getAd();
    }
}
