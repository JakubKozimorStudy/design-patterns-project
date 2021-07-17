package com.example.designpatternsproject.domain.service;

import com.example.designpatternsproject.command.CreateUserCommand;
import com.example.designpatternsproject.domain.model.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface UserService {

    void create(@NotNull @Valid CreateUserCommand createUserCommand);

    Set<User> get();

    User get(@NotNull UUID id);

    void startWork(@NotNull UUID id);

    void stopWork(@NotNull UUID id);

    BigDecimal getSalary(@NotNull UUID id);

    BigDecimal getSalaryWithHolidayBonus(@NotNull UUID id);

    BigDecimal getSalaryWithDiscretionaryBonus(@NotNull UUID id);
}
