package com.example.designpatternsproject.domain.model;

import com.example.designpatternsproject.domain.service.observer.Observer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public abstract class Task implements Observer {

    private UUID id;
    private Boolean inProgress;

    public abstract void task();

    public Task() {
        this.id = UUID.randomUUID();
        this.inProgress = true;
    }

    @Override
    public void updateInProgress(@NotNull Boolean inProgress) {
        this.inProgress = inProgress;
    }
}
