package com.edwin.task.service;

import com.edwin.task.domain.CreateTaskRequest;
import com.edwin.task.domain.UpdateTaskRequest;
import com.edwin.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
    List<Task> listTasks();
    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
