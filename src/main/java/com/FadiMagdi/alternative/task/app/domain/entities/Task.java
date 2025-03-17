package com.FadiMagdi.alternative.task.app.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id",updatable = false,nullable = false)
    private UUID id;

@Column(name="title",nullable = false) // we want it updatable so it is true by default
    private String title;


@Column(name="description")
    private String description;

@Column(name="due_date")
    private LocalDateTime dueDate;

@Column(name="status",nullable = false)
private TaskStatus status;

@Column(name="priority",nullable = false)
    private TaskPriority priority;

@Column(name="created",nullable = false)
    private LocalDateTime created;
// does not hold a specific time zone also it is supported by jpa and json formatting

@Column(name="updated",nullable = false)
    private LocalDateTime updated;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="task_list_id")
private TaskList currentList;


public Task(){

}

    public Task(UUID id, String title, String description, LocalDateTime dueDate, TaskStatus status, TaskPriority priority, LocalDateTime created, LocalDateTime updated, TaskList currentList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.created = created;
        this.updated = updated;
        this.currentList = currentList;
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public TaskList getCurrentList() {
        return currentList;
    }

    public void setCurrentList(TaskList currentList) {
        this.currentList = currentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(dueDate, task.dueDate) && status == task.status && priority == task.priority && Objects.equals(created, task.created) && Objects.equals(updated, task.updated) && Objects.equals(currentList, task.currentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate, status, priority, created, updated, currentList);
    }
}
