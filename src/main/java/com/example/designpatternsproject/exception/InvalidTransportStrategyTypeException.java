package com.example.designpatternsproject.exception;

import com.example.designpatternsproject.domain.model.enums.TransportStrategyType;

import javax.validation.constraints.NotNull;

public class InvalidTransportStrategyTypeException extends RuntimeException {
    public InvalidTransportStrategyTypeException(@NotNull TransportStrategyType type) {
        super(String.format("Transport strategy type {type: %s}", type));
    }
}
