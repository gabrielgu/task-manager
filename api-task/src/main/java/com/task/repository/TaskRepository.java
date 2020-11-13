package com.task.repository;

import java.util.List;

import com.task.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>  {
    
    List<Task> findByIdUser(Integer idUser);
}
