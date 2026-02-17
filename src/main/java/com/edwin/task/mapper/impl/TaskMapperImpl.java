package com.edwin.task.mapper.impl;

import com.edwin.task.domain.CreateTaskRequest;
import com.edwin.task.domain.UpdateTaskRequest;
import com.edwin.task.domain.dto.CreateTaskRequestDto;
import com.edwin.task.domain.dto.TaskDto;
import com.edwin.task.domain.dto.UpdateTaskRequestDto;
import com.edwin.task.domain.entity.Task;
import com.edwin.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
