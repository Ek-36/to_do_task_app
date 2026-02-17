package com.edwin.task.controller;

import com.edwin.task.domain.CreateTaskRequest;
import com.edwin.task.domain.UpdateTaskRequest;
import com.edwin.task.domain.dto.CreateTaskRequestDto;
import com.edwin.task.domain.dto.TaskDto;
import com.edwin.task.domain.dto.UpdateTaskRequestDto;
import com.edwin.task.domain.entity.Task;
import com.edwin.task.mapper.TaskMapper;
import com.edwin.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
           @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
        CreateTaskRequest createTaskRequest= taskMapper.fromDto(createTaskRequestDto);
        Task task= taskService.createTask(createTaskRequest);
        TaskDto createTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos= tasks.stream().map(taskMapper::toDto).toList();

        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
       @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ){

        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);

        Task task = taskService.updateTask(taskId, updateTaskRequest);

        TaskDto dto = taskMapper.toDto(task);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){

        taskService.deleteTask(taskId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
