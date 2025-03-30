package com.FadiMagdi.alternative.task.app.controllers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskListDto;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import com.FadiMagdi.alternative.task.app.mappers.TaskListMapper;
import com.FadiMagdi.alternative.task.app.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

@GetMapping(path="/{task_list_id}")
public Optional<TaskListDto> getTaskListDto(@PathVariable("task_list_id")UUID taskListId){

        return this.taskListService.getTaskListById(taskListId).map(this.taskListMapper::toDto);

}


@PutMapping(path="/{task_list_id}")
public TaskListDto updateTaskList(
        @PathVariable("task_list_id") UUID taskListId,
        @RequestBody TaskListDto taskListDto){

        TaskList updatedTaskList = this.taskListService.updateTaskList(
                taskListId,
                this.taskListMapper.fromDto(taskListDto)

        );

        return this.taskListMapper.toDto(updatedTaskList);


}


@DeleteMapping(path="/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID tasklistid){
        this.taskListService.deleteTaskList(tasklistid);
}

}
