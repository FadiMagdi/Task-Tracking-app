package com.FadiMagdi.alternative.task.app.services.Impl;

import com.FadiMagdi.alternative.task.app.domain.entities.Task;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskPriority;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskStatus;
import com.FadiMagdi.alternative.task.app.repositories.TaskListRepository;
import com.FadiMagdi.alternative.task.app.repositories.TaskRepository;
import com.FadiMagdi.alternative.task.app.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
private final TaskListRepository taskListRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListID) {
        return this.taskRepository.findByTaskListId(taskListID) ;
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {

        if(task.getId() != null){
            throw new IllegalArgumentException("Task already has an ID!");
        }
if(task.getTitle() == null ||  task.getTitle().isBlank()){
    throw new IllegalArgumentException("Task must have a title");
}

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
                .orElse(TaskPriority.MEDIUM);


        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList  = this.taskListRepository.findById(taskListId)
                .orElseThrow(()-> new IllegalArgumentException("Invalid Task List ID provided"));

LocalDateTime currentTime = LocalDateTime.now();
        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                currentTime,
                currentTime,
                taskList


        );
return this.taskRepository.save(taskToSave);

    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId,taskId);
    }
}
