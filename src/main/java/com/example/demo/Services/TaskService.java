package com.example.demo.Services;

import com.example.demo.Dtos.TaskDto;
import com.example.demo.Entities.TaskEntity;
import com.example.demo.Repositories.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepo taskRepository;

    public TaskService(TaskRepo repo){
        this.taskRepository = repo;
    }

    public TaskEntity fromDtoToTask(TaskDto dto)
    {
        TaskEntity task = new TaskEntity();
        if(dto.getId() != null) task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return task;
    }
    @Transactional
    public String createTask(TaskDto task) {
        try{
            TaskEntity toTask = fromDtoToTask(task);
            taskRepository.save(toTask);

        } catch (Exception e){
            return "Error e: "+e.getMessage();
        }
        return task.toString();
    }

    public List<TaskDto> getTasks(){

        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> new TaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public String updateTask(UUID id,TaskDto task){
        try{
            Optional<TaskEntity> exist = taskRepository.findById(id);
            TaskEntity toTask = fromDtoToTask(task);
            toTask.setId(id);
            if(exist.isEmpty())
                return "Task not found with ID: " + task.getId();
            taskRepository.save(toTask);
        }catch (Exception e){
            return "Error e: "+e.getMessage();
        }
        return "Task is updated well.";
    }


    @Transactional
    public boolean deleteTask(UUID id){
        try{
            taskRepository.deleteById(id);
            return  true;
        }catch (Exception e){
            System.out.println("Error e: "+e.getMessage());
            return false;
        }
    }

    @Transactional
    public String taskCompleted(UUID id) {
        try {
            Optional<TaskEntity> optionalTask = taskRepository.findById(id);

            if (optionalTask.isEmpty()) {
                return "Task not found with ID: " + id;
            }
            TaskEntity task = optionalTask.get();
            task.setCompleted(true);
            taskRepository.save(task);
            return "Task marked as completed successfully.";
        } catch (Exception e) {
            return "Error completing task: " + e.getMessage();
        }
    }

}
