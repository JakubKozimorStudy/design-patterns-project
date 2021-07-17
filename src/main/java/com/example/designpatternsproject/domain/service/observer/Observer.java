package com.example.designpatternsproject.domain.service.observer;

import javax.validation.constraints.NotNull;

public interface Observer {
    void updateInProgress(@NotNull Boolean inProgress);
}
