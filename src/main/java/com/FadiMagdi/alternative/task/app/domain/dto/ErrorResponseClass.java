package com.FadiMagdi.alternative.task.app.domain.dto;

public class ErrorResponseClass {

    int status;
    String message;
    String details;

    public ErrorResponseClass(int status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
