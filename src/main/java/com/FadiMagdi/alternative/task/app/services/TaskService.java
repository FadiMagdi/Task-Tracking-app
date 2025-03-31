package com.FadiMagdi.alternative.task.app.services;

import com.FadiMagdi.alternative.task.app.domain.entities.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    List<Task> listTasks(UUID taskListID);

    Task createTask(UUID taskListId,Task task);

    Optional<Task> getTask(UUID taskListId,UUID taskId);

    Task updateTask(UUID TaskListID ,UUID taskID, Task task );

    void deleteTask(UUID taskListId, UUID taskId);

}
