package com.example.designpatternsproject.domain.model;

import com.example.designpatternsproject.domain.service.strategy.TransportStrategy;
import com.example.designpatternsproject.domain.service.strategy.transport.CarTransportStrategy;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class TransportTask extends Task implements TransportStrategy {

    private TransportStrategy transportStrategy;
    private String task;

    public TransportTask() {
        super();
        this.transportStrategy = new CarTransportStrategy();
    }

    @Override
    public void task() {
        this.task = "Deliver package";
    }

    @Override
    public void deliverPackage(@NotNull @Valid TransportTask task) {
        transportStrategy.deliverPackage(task);
    }
}
