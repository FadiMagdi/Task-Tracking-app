package com.FadiMagdi.alternative.task.app.mappers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskDto;
import com.FadiMagdi.alternative.task.app.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
