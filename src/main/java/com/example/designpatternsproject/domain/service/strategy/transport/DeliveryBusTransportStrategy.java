package com.example.designpatternsproject.domain.service.strategy.transport;

import com.example.designpatternsproject.domain.model.TransportTask;
import com.example.designpatternsproject.domain.model.enums.TransportStrategyType;
import com.example.designpatternsproject.domain.service.strategy.TransportStrategy;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class DeliveryBusTransportStrategy implements TransportStrategy {

    private TransportStrategyType type = TransportStrategyType.DELIVERY_BUS;

    @Override
    public void deliverPackage(@NotNull @Valid TransportTask task) {
        task.setTransportStrategy(this);
    }
}
