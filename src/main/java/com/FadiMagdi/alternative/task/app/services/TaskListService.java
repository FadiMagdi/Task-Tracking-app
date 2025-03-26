package com.FadiMagdi.alternative.task.app.services;

import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskList();

    TaskList createTaskList(TaskList taskListToCreate);

}
