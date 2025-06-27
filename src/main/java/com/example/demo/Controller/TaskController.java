package com.example.demo.Controller;

import com.example.demo.Dtos.TaskDto;
import com.example.demo.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController{

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDto> getTasks()
    {
        return service.getTasks();
    }

    @PostMapping
    public String createTasks(@RequestBody TaskDto task){
        return  service.createTask(task);
    }
    @PutMapping("/{id}")
    public String updateTasks(@PathVariable UUID id,@RequestBody TaskDto task){
        return  service.updateTask(id,task);
    }
    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable UUID id)
    {
        return  service.deleteTask(id);
    }
    @PatchMapping("/{id}/complete")
    public String completeTask(@PathVariable UUID id)
    {
        return  service.taskCompleted(id);
    }
}
