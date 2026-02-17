package com.edwin.task.mapper;

import com.edwin.task.domain.CreateTaskRequest;
import com.edwin.task.domain.UpdateTaskRequest;
import com.edwin.task.domain.dto.CreateTaskRequestDto;
import com.edwin.task.domain.dto.TaskDto;
import com.edwin.task.domain.dto.UpdateTaskRequestDto;
import com.edwin.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);
}
