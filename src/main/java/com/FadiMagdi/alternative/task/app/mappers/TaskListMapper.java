package com.FadiMagdi.alternative.task.app.mappers;

import com.FadiMagdi.alternative.task.app.domain.dto.TaskDto;
import com.FadiMagdi.alternative.task.app.domain.dto.TaskListDto;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskList;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}
