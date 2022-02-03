package com.restfulapi.springboot.controller;

import com.restfulapi.springboot.data.Task;
import com.restfulapi.springboot.dto.TaskDto;
import com.restfulapi.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id ) {
        try {
            return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto ) {
        Task task = new Task(taskDto.getName(),taskDto.getDescription(), taskDto.getStatus(), taskDto.getAssignedTo(), taskDto.getDueDate());
        return new ResponseEntity<> (taskService.create(task), HttpStatus.ACCEPTED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        return new ResponseEntity<>(taskService.update(taskDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        return new ResponseEntity<>(taskService.deleteById(id), HttpStatus.ACCEPTED);
    }

}
