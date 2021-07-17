package com.example.designpatternsproject.domain.model;

import com.example.designpatternsproject.command.CreateUserCommand;
import com.example.designpatternsproject.domain.service.observer.UserSubscribers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private Set<Task> tasks;
    private BigDecimal thisMonthPayment;
    private boolean atWork;
    private UserSubscribers userSubscribers;

    public static User of(@NotNull String firstName, @NotNull String lastName) {
        return User.builder()
                .id(UUID.randomUUID())
                .firstName(firstName)
                .lastName(lastName)
                .atWork(false)
                .userSubscribers(new UserSubscribers())
                .build();
    }

    public static User of(@NotNull @Valid CreateUserCommand createUserCommand) {
        return User.builder()
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .atWork(false)
                .userSubscribers(new UserSubscribers())
                .build();
    }

    public void addTask(@NotNull @Valid Task task) {
        if (Objects.isNull(tasks)) {
            tasks = new HashSet<>();
        }
        tasks.add(task);
    }
}
