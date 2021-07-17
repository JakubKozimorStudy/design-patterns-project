package com.example.designpatternsproject.domain.service.observer;

import com.example.designpatternsproject.domain.model.User;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserSubscribers {

    private Set<Observer> observers;

    public UserSubscribers() {
        this.observers = new HashSet<>();
    }

    public void subscribe(@NotNull @Valid Observer observer) {
        this.observers.add(observer);
    }

    public void updateInProgress(@NotNull @Valid User user, @NotNull Boolean atWork) {
        user.setAtWork(atWork);
        this.observers.forEach(observer -> observer.updateInProgress(atWork));
    }
}
