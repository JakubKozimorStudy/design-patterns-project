package com.example.designpatternsproject.domain.service;

import com.example.designpatternsproject.command.AddTaskCommand;
import com.example.designpatternsproject.domain.model.enums.TransportStrategyType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface TaskService {

    void create(@NotNull @Valid AddTaskCommand addTaskCommand);

    void changeTransportStrategy(@NotNull UUID id, @NotNull @Valid TransportStrategyType transportStrategyType);
}
