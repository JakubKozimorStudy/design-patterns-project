package com.example.designpatternsproject.domain.service;

import com.example.designpatternsproject.command.AddTaskCommand;
import com.example.designpatternsproject.domain.model.Task;
import com.example.designpatternsproject.domain.model.TransportTask;
import com.example.designpatternsproject.domain.model.User;
import com.example.designpatternsproject.domain.model.enums.TransportStrategyType;
import com.example.designpatternsproject.domain.repository.TaskRepository;
import com.example.designpatternsproject.domain.repository.UserRepository;
import com.example.designpatternsproject.domain.service.strategy.TransportStrategy;
import com.example.designpatternsproject.domain.service.strategy.transport.CarTransportStrategy;
import com.example.designpatternsproject.domain.service.strategy.transport.DeliveryBusTransportStrategy;
import com.example.designpatternsproject.domain.service.task.TaskFactory;
import com.example.designpatternsproject.exception.InvalidTransportStrategyTypeException;
import com.example.designpatternsproject.exception.NotTransportTypeTaskException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public void create(@NotNull @Valid AddTaskCommand addTaskCommand) {
        Task task = TaskFactory.createTask(addTaskCommand.getTaskType());
        User user = userRepository.get(addTaskCommand.getUserId());
        user.addTask(task);
        user.getUserSubscribers().subscribe(task);
        Task savedTask = taskRepository.save(task);
        savedTask.task();
    }

    @Override
    public void changeTransportStrategy(@NotNull UUID id, @NotNull TransportStrategyType transportStrategyType) {
        Task task = taskRepository.get(id);
        if (task instanceof TransportTask) {
            ((TransportTask) task).setTransportStrategy(getTransportStrategy(transportStrategyType));
        } else {
            throw new NotTransportTypeTaskException(task.getId());
        }
    }

    private TransportStrategy getTransportStrategy(@NotNull TransportStrategyType transportStrategyType) {
        switch (transportStrategyType) {
            case CAR:
                return new CarTransportStrategy();
            case DELIVERY_BUS:
                return new DeliveryBusTransportStrategy();
            default:
                throw new InvalidTransportStrategyTypeException(transportStrategyType);
        }
    }
}
