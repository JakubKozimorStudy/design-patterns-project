package com.example.designpatternsproject.domain.service.strategy;

import com.example.designpatternsproject.domain.model.TransportTask;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface TransportStrategy {

    void deliverPackage(@NotNull @Valid TransportTask task);
}
