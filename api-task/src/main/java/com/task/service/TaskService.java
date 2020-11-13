package com.task.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.task.exception.BusinessException;
import com.task.model.Task;
import com.task.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository repository;

    @Transactional
    public Task save(Task task){
        task.setCreationDate(LocalDateTime.now());
        return this.repository.save(task);
    }

    @Transactional
    public Task update(Task task){
        Task taskFound = this.findById(task.getId());
        taskFound.setDescription(task.getDescription());
        return this.repository.save(taskFound);
    }

    @Transactional
    public void delete(Integer id){
        Task taskFound = this.findById(id);
        this.repository.delete(taskFound);
    }

    public Task findById(Integer id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(!optionalTask.isPresent()){
            throw new BusinessException("Task not found.");
        }
        return optionalTask.get();
    }

    public List<Task> findByIdUser(Integer idUser){
        return this.repository.findByIdUser(idUser);
    }

    @Transactional
    public Task finish(Integer id){
        Task taskFound = this.findById(id);
        taskFound.setFinishDate(LocalDateTime.now());
        return this.repository.save(taskFound);
    }
    
}
