package com.example.demo.Dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class TaskDto {

    private UUID id;

    @NotBlank(message = "Title is mandatory")
    @Size(max=200, message = "Title should not exceed 200 character")
    private String title;

    @Size(max = 500, message = "Description should not exceed 500 character")
    private String description;

    private boolean completed = false;

    public TaskDto(){}

    public TaskDto(UUID id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                " title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
