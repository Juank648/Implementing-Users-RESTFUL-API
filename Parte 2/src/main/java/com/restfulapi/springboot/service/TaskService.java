package com.restfulapi.springboot.service;

import com.restfulapi.springboot.data.Task;
import com.restfulapi.springboot.dto.TaskDto;

import java.util.List;

public interface TaskService {
    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    boolean deleteById( String id );

    Task update(TaskDto taskDto, String id );
}
