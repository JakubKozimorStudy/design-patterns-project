package com.example.designpatternsproject.domain.service.task;

import com.example.designpatternsproject.domain.model.TransportTask;
import com.example.designpatternsproject.domain.model.WarehouseTask;
import com.example.designpatternsproject.domain.model.enums.TaskType;
import com.example.designpatternsproject.domain.model.Task;

public class TaskFactory {

    public static Task createTask(TaskType task) {
        switch (task) {
            case TRANSPORT:
                return new TransportTask();
            case WAREHOUSE:
                return new WarehouseTask();
        }
        return null;
    }
}
