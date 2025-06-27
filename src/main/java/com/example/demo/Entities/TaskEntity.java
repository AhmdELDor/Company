package com.example.demo.Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Task")
public class TaskEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column
    private String title;

    @Column
    private String description;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean completed;

//    for Spring generation
    public TaskEntity(){}

    public TaskEntity(UUID id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
