package com.example.designpatternsproject.domain.service.decorator;

import java.math.BigDecimal;

public class MonthSalary implements Payment {
    @Override
    public BigDecimal getSalary() {
        return BigDecimal.valueOf(3000);
    }
}