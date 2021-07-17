package com.example.designpatternsproject.controller;

import com.example.designpatternsproject.command.AddTaskCommand;
import com.example.designpatternsproject.domain.model.enums.TransportStrategyType;
import com.example.designpatternsproject.domain.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NotNull @Valid @RequestBody AddTaskCommand addTaskCommand) {
        taskService.create(addTaskCommand);
    }

    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeTransportStrategy(@NotNull @PathVariable("id") UUID id, @NotNull @Valid @RequestBody TransportStrategyType transportStrategyType) {
        taskService.changeTransportStrategy(id, transportStrategyType);
    }
}
