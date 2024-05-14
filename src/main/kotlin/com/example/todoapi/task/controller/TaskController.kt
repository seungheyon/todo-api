package com.example.todoapi.task.controller

import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.service.TaskService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController(
    val taskService : TaskService
) {

    @PostMapping("/tasks")
    fun createTask(
        @RequestBody taskRequestDto: TaskRequestDto
    ) : TaskResponseDto {
        return taskService.createTask(taskRequestDto)
    }
}