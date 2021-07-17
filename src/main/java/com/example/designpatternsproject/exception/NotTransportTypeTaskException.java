package com.example.designpatternsproject.exception;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class NotTransportTypeTaskException extends RuntimeException {
    public NotTransportTypeTaskException(@NotNull UUID id) {
        super(String.format("Task not transport {task id: %s}", id));
    }
}