package com.FadiMagdi.alternative.task.app.domain.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        Integer cout,
        Double progress,
        List<TaskDto> tasks
) {
}
