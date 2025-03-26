package com.FadiMagdi.alternative.task.app.services.Impl;

import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import com.FadiMagdi.alternative.task.app.repositories.TaskListRepository;
import com.FadiMagdi.alternative.task.app.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {


    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }


    @Override
    public List<TaskList> listTaskList() {
        return this.taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskListToCreate) {

        // to validate that the task is new
        if(taskListToCreate.getId() != null){
            throw new IllegalArgumentException("Task list already exists");
        }

        // to assert that the task has a title

        if((null == taskListToCreate.getTitle())  ||  taskListToCreate.getTitle().isBlank()){
            throw new IllegalArgumentException("a task list should have a title");
        }


        // creation of the new list
        LocalDateTime now = LocalDateTime.now();
        return this.taskListRepository.save(new TaskList(

                        null,
                        taskListToCreate.getTitle(),
                        taskListToCreate.getDescription(),
                now,
                now,
                null





                ));
    }
}
