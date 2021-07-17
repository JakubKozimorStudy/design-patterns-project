package com.example.designpatternsproject.handler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ApiError {

    private String error;
    private String message;
    private Integer status;
    private String timestamp;

    public static ApiError of(@NotBlank String error, @NotBlank String message, @NotNull Integer status) {
        return ApiError.builder()
                .error(error)
                .message(message)
                .status(status)
                .timestamp(LocalDateTime.now().toString())
                .build();
    }
}
