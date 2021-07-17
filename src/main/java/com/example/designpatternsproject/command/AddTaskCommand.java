package com.example.designpatternsproject.command;

import com.example.designpatternsproject.domain.model.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskCommand {
    @NotNull
    private UUID userId;
    @NotNull
    private TaskType taskType;
}
