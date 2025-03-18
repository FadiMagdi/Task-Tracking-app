package com.FadiMagdi.alternative.task.app.mappers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskDto;
import com.FadiMagdi.alternative.task.app.domain.dto.TaskListDto;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}
