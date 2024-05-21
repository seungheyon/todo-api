package com.example.todoapi.task.controller

import com.example.todoapi.common.dto.StatusResponseDto
import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.dto.TasksResponseDto
import com.example.todoapi.task.service.TaskService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TaskController(
    val taskService : TaskService
) {

    @PostMapping("/tasks")
    fun createTask(
        @RequestBody taskRequestDto: TaskRequestDto
    ) : ResponseEntity<TaskResponseDto> {
        val taskResponseDto = taskService.createTask(taskRequestDto)
        val headers = HttpHeaders()
        headers.add(HttpHeaders.ACCEPT,"headerValue")
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(taskResponseDto)
    }

    @GetMapping("/tasks/{taskId}")
    fun getTask(@PathVariable taskId : Long) : ResponseEntity<TaskResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.getTask(taskId))
    }

    @GetMapping("/tasks")
    fun getTasks() : ResponseEntity<TasksResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.getTasks())
    }

    @PutMapping("/tasks/{taskId}")
    fun updateTask(
        @PathVariable taskId : Long,
        @RequestBody taskRequestDto : TaskRequestDto
    ) : ResponseEntity<TaskResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.updateTask(taskId, taskRequestDto))
    }

    @DeleteMapping("/tasks/{taskId}")
    fun deleteTask(@PathVariable taskId : Long) : ResponseEntity<StatusResponseDto> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(StatusResponseDto("할 일이 삭제되었습니다."))
    }
}