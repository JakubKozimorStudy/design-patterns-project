package com.example.designpatternsproject.domain.model;

import lombok.Data;

@Data
public class WarehouseTask extends Task {

    private String task;

    public WarehouseTask() {
        super();
    }

    @Override
    public void task() {
        this.task = "Sort packages";
    }
}
