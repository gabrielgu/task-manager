package com.task.controller;

import java.util.List;

import com.task.dto.SaveTaskDTO;
import com.task.dto.UpdateTaskDTO;
import com.task.model.Task;
import com.task.service.TaskService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/task")
    public Task save(@RequestBody SaveTaskDTO taskDTO){
        Task task = this.modelMapper.map(taskDTO, Task.class);
        return this.service.save(task);
    }

    @PutMapping(path = "/task/{id}")
    public Task update(@PathVariable Integer id, @RequestBody UpdateTaskDTO taskDTO){
        Task task = this.modelMapper.map(taskDTO, Task.class);
        task.setId(id);
        return this.service.update(task);
    }

    @DeleteMapping(path = "/task/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/task/{id}")
    public Task findById(@PathVariable Integer id){
        return this.service.findById(id);
    }

    @GetMapping(path = "/user/{idUser}/task")
    public List<Task> findByIdUser(@PathVariable Integer idUser){
        return this.service.findByIdUser(idUser);
    }

    @PutMapping(path = "/task/{id}/finish")
    public Task finish(@PathVariable Integer id){
        return this.service.finish(id);
    }
    
}
