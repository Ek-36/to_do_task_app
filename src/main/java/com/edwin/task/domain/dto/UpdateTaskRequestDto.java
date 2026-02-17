package com.edwin.task.domain.dto;

import com.edwin.task.domain.entity.TaskPriority;
import com.edwin.task.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message = error_message_title)
        @Length(max = 255,message = error_message_title)
        String title,
        @Length(max = 1000,message = error_message_description)
        @Nullable
        String description,
        @Nullable
        @FutureOrPresent(message = error_message_due_date)
        LocalDate dueDate,
        @NotNull(message = error_message_priority)
        TaskPriority priority,
        @NotNull(message = error_message_status)
        TaskStatus status
) {
    private static final String error_message_title = "tital must be between 1 and 255 characters";
    private static final String error_message_description = "Description must be less then 1000 characters";
    private static final String error_message_due_date = "due date must be in the future";
    private static final String error_message_priority = "priority must be provided";
    private static final String error_message_status = "status must be provided";
}
