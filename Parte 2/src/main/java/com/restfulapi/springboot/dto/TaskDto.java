package com.restfulapi.springboot.dto;

import com.restfulapi.springboot.data.Status;
import com.restfulapi.springboot.data.Task;

import java.util.Date;
import java.util.Objects;

public class TaskDto {

    public String name;
    public String description;
    public Status status;
    public String assignedTo;
    public Date dueDate;

    public TaskDto(Task task) {
        this.name = task.getName();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.assignedTo = task.getAssignedTo();
        this.dueDate = task.getDueDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return name.equals(taskDto.name) && Objects.equals(description, taskDto.description) && status == taskDto.status && Objects.equals(assignedTo, taskDto.assignedTo) && dueDate.equals(taskDto.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, status, assignedTo, dueDate);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
