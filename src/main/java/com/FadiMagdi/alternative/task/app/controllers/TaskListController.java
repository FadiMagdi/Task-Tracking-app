package com.FadiMagdi.alternative.task.app.controllers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskListDto;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import com.FadiMagdi.alternative.task.app.mappers.TaskListMapper;
import com.FadiMagdi.alternative.task.app.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/task-lists")

public class TaskListController {
    private final TaskListService taskListService;

    private final TaskListMapper taskListMapper;
    @Autowired
    public TaskListController(TaskListService taskListService , TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

@GetMapping
    public List<TaskListDto> listTaskLists(){

        return taskListService.listTaskList()
                .stream()
                .map(taskListMapper::toDto).toList();



}


@PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto){

        TaskList createdTaskList = this.taskListService.createTaskList(

                taskListMapper.fromDto(taskListDto)

        );
return taskListMapper.toDto(createdTaskList);

}

}
