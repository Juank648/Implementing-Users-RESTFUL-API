package com.restfulapi.springboot.data;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task {

    public String id;
    public String name;
    public String description;
    public Status status;
    public String assignedTo;
    public Date dueDate;
    public Date created;

    public Task(String name, String description, Status status, String assignedTo, Date dueDate) {
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.created = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status && Objects.equals(assignedTo, task.assignedTo) && Objects.equals(dueDate, task.dueDate) && Objects.equals(created, task.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, assignedTo, dueDate, created);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", dueDate=" + dueDate +
                ", created=" + created +
                '}';
    }
}
