package com.example.designpatternsproject.domain.service.decorator;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public abstract class BonusSalary implements Payment {

    private Payment payment;

    public BonusSalary(@NotNull @Valid Payment payment) {
        this.payment = payment;
    }

    @Override
    public BigDecimal getSalary() {
        return payment.getSalary();
    }
}