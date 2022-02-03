package com.restfulapi.springboot.service.impl;

import com.restfulapi.springboot.data.Task;
import com.restfulapi.springboot.dto.TaskDto;
import com.restfulapi.springboot.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceHashMap implements TaskService {

    public HashMap<String, Task> TaskMap = new HashMap <String, Task>();

    public HashMap<String, Task> getTaskMap() {
        return TaskMap;
    }

    public void setTaskMap(HashMap<String, Task> taskMap) {
        TaskMap = taskMap;
    }

    @Override
    public Task create(Task task) {
        TaskMap.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return TaskMap.getOrDefault(id, null);
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = TaskMap.values()
                .stream()
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            TaskMap.remove(id);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Task update(TaskDto taskDto, String id) {
        Task task = TaskMap.getOrDefault(id, null);
        task.setName(taskDto.getName());
        task.setDescription(task.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setDueDate(taskDto.getDueDate());
        return task;
    }
}
