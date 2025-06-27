package com.example.demo.Repositories;

import com.example.demo.Entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<TaskEntity, UUID> {
}
