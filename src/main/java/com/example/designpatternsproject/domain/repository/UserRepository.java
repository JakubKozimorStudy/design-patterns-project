package com.example.designpatternsproject.domain.repository;

import com.example.designpatternsproject.domain.model.User;
import com.example.designpatternsproject.exception.UserNotFoundException;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Repository
public class UserRepository {

    private Set<User> users = Sets.newHashSet(User.of("Adrian", "Czarnecki"), User.of("Fryderyk", "Zalewski"));

    public Set<User> findAll() {
        return users;
    }

    public User get(@NotNull UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User save(@NotNull @Valid User user) {
        user.setId(UUID.randomUUID());
        users.add(user);
        return user;
    }
}
