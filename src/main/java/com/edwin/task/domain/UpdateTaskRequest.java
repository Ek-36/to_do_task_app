package com.edwin.task.domain;

import com.edwin.task.domain.entity.TaskPriority;
import com.edwin.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {

}
