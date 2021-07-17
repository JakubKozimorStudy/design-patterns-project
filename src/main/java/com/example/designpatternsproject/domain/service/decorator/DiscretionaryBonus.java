package com.example.designpatternsproject.domain.service.decorator;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class DiscretionaryBonus extends BonusSalary {

    public DiscretionaryBonus(@NotNull @Valid Payment payment) {
        super(payment);
    }

    @Override
    public BigDecimal getSalary() {
        return super.getSalary().add(BigDecimal.valueOf(300));
    }
}