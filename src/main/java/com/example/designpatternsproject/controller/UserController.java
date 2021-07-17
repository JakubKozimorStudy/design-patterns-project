package com.example.designpatternsproject.controller;

import com.example.designpatternsproject.command.CreateUserCommand;
import com.example.designpatternsproject.domain.model.User;
import com.example.designpatternsproject.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NotNull @Valid @RequestBody CreateUserCommand createUserCommand) {
        userService.create(createUserCommand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<User> get() {
        return userService.get();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User get(@PathVariable("id") @NotNull UUID id) {
        return userService.get(id);
    }

    @GetMapping(value = "/start/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void startWork(@PathVariable("id") @NotNull UUID id) {
        userService.startWork(id);
    }

    @GetMapping(value = "/stop/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void stopWork(@PathVariable("id") @NotNull UUID id) {
        userService.stopWork(id);
    }

    @GetMapping(value = "/salary/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getSalary(@PathVariable("id") @NotNull UUID id) {
        return userService.getSalary(id);
    }

    @GetMapping(value = "/salary/holiday-bonus/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getSalaryWithHolidayBonus(@PathVariable("id") @NotNull UUID id) {
        return userService.getSalaryWithHolidayBonus(id);
    }

    @GetMapping(value = "/salary/discretionary-bonus/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getSalaryWithDiscretionaryBonus(@PathVariable("id") @NotNull UUID id) {
        return userService.getSalaryWithDiscretionaryBonus(id);
    }
}
