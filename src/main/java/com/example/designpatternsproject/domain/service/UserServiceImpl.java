package com.example.designpatternsproject.domain.service;

import com.example.designpatternsproject.command.CreateUserCommand;
import com.example.designpatternsproject.domain.model.User;
import com.example.designpatternsproject.domain.repository.UserRepository;
import com.example.designpatternsproject.domain.service.decorator.BonusSalary;
import com.example.designpatternsproject.domain.service.decorator.DiscretionaryBonus;
import com.example.designpatternsproject.domain.service.decorator.HolidayBonus;
import com.example.designpatternsproject.domain.service.decorator.MonthSalary;
import com.example.designpatternsproject.domain.service.decorator.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(@NotNull @Valid CreateUserCommand createUserCommand) {
        userRepository.save(User.of(createUserCommand));
    }

    @Override
    public Set<User> get() {
        return userRepository.findAll();
    }

    @Override
    public User get(@NotNull UUID id) {
        return userRepository.get(id);
    }

    @Override
    public void startWork(@NotNull UUID id) {
        User user = userRepository.get(id);
        if (Objects.nonNull(user.getUserSubscribers())) {
            user.getUserSubscribers().updateInProgress(user, true);
        }
    }

    @Override
    public void stopWork(@NotNull UUID id) {
        User user = userRepository.get(id);
        if (Objects.nonNull(user.getUserSubscribers())) {
            user.getUserSubscribers().updateInProgress(user, false);
        }
    }

    @Override
    public BigDecimal getSalary(@NotNull UUID id) {
        User user = userRepository.get(id);
        Payment payment = new MonthSalary();
        user.setThisMonthPayment(payment.getSalary());

        return user.getThisMonthPayment();
    }

    @Override
    public BigDecimal getSalaryWithHolidayBonus(@NotNull UUID id) {
        User user = userRepository.get(id);
        Payment payment = new MonthSalary();
        BonusSalary holidayBonus = new HolidayBonus(payment);
        user.setThisMonthPayment(holidayBonus.getSalary());

        return user.getThisMonthPayment();
    }

    @Override
    public BigDecimal getSalaryWithDiscretionaryBonus(@NotNull UUID id) {
        User user = userRepository.get(id);
        Payment payment = new MonthSalary();
        BonusSalary discretionaryBonus = new DiscretionaryBonus(payment);
        user.setThisMonthPayment(discretionaryBonus.getSalary());

        return user.getThisMonthPayment();
    }
}
