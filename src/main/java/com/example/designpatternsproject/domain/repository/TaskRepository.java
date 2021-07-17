package com.example.designpatternsproject.domain.repository;

import com.example.designpatternsproject.domain.model.Task;
import com.example.designpatternsproject.exception.TaskNotFoundException;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class TaskRepository {

    private Set<Task> tasks = new HashSet<>();

    public Task get(@NotNull UUID id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task save(@NotNull @Valid Task task) {
        tasks.add(task);
        return task;
    }
}
