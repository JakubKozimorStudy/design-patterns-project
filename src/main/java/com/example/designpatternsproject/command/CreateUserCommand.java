package com.example.designpatternsproject.command;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class CreateUserCommand {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
