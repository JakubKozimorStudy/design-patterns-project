package com.example.designpatternsproject.exception;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(@NotNull UUID id) {
        super(String.format("Task not found {id: %s}", id));
    }
}
