package com.example.designpatternsproject.exception;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(@NotNull UUID id) {
        super(String.format("User not found {id: %s}", id));
    }
}
