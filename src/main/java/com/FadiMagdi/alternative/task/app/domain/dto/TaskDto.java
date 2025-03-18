package com.FadiMagdi.alternative.task.app.domain.dto;

import com.FadiMagdi.alternative.task.app.domain.entities.TaskPriority;
import com.FadiMagdi.alternative.task.app.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
