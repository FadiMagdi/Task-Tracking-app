package com.FadiMagdi.alternative.task.app.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details

) {
}
