package com.FadiMagdi.alternative.task.app.services;

import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskList();

    TaskList createTaskList(TaskList taskListToCreate);

    Optional<TaskList> getTaskListById(UUID id);
    
    TaskList updateTaskList(UUID TaskListID , TaskList taskList);

    void deleteTaskList(UUID TaskListId);

}
