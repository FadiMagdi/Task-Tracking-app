package com.FadiMagdi.alternative.task.app.mappers.impl;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskListDto;
import com.FadiMagdi.alternative.task.app.domain.entities.Task;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskStatus;
import com.FadiMagdi.alternative.task.app.mappers.TaskListMapper;
import com.FadiMagdi.alternative.task.app.mappers.TaskMapper;

import java.util.List;
import java.util.Optional;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

public class TaskListMapperimpl implements TaskListMapper {

private final TaskMapper taskMapper;

    public TaskListMapperimpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return
                new TaskList(
                        taskListDto.id(),
                        taskListDto.title(),
                        taskListDto.description(),
                        null,
                        null,
                        null,
                        Optional.ofNullable(taskListDto.tasks())
                                .map(tasks ->tasks.stream().map(taskMapper::fromDto)
                                        .toList()
                                ).orElse(null)
                )

                ;
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {

        final List<Task> tasks = taskList.getTasks();

return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(tasks)
                .map(List::size)
.orElse(0),
calculateTaskListProgress(tasks),
Optional.ofNullable(tasks)
.map(t -> t.stream()
                .map(taskMapper::toDto)
.toList())
.orElse(null)
);
    }

private Double calculateTaskListProgress(List<Task> tasks){
        if(null == tasks){
            return null;
        }

    long closedTaskCount = tasks.stream().filter(task-> TaskStatus.CLOSED ==task.getStatus()).count();

        return (double) closedTaskCount/tasks.size();
}

}
