package com.FadiMagdi.alternative.task.app.controllers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskDto;
import com.FadiMagdi.alternative.task.app.domain.entities.Task;
import com.FadiMagdi.alternative.task.app.mappers.TaskMapper;
import com.FadiMagdi.alternative.task.app.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path="/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

@Autowired
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID  tasklistId){
return this.taskService.listTasks(tasklistId)
        .stream()
        .map(this.taskMapper::toDto)
        .toList();
    }

    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id") UUID taskListId,
@RequestBody TaskDto taskDto
    ){
        Task createdTask = this.taskService.createTask(taskListId,this.taskMapper.fromDto(taskDto));

return taskMapper.toDto(createdTask);


}



@GetMapping("/{task_id}")
    public Optional<TaskDto> getTask(
            @PathVariable("task_list_id") UUID taskListID,
            @PathVariable("task-id") UUID taskID){

    return taskService.getTask(taskListID,taskID).map(taskMapper::toDto);


}


}
