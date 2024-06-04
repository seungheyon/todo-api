package com.example.todoapi.task.controller

import com.example.todoapi.common.constants.SortEnum
import com.example.todoapi.common.dto.StatusResponseDto
import com.example.todoapi.task.dto.TaskDetailResponseDto
import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.dto.TasksResponseDto
import com.example.todoapi.task.service.TaskService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/tasks")
@RestController
class TaskController(
    val taskService: TaskService
) {

    @PostMapping("")
    fun createTask(
        @RequestBody taskRequestDto: TaskRequestDto
    ): ResponseEntity<TaskResponseDto> {
        val taskResponseDto = taskService.createTask(taskRequestDto)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(taskResponseDto)
    }

    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: Long): ResponseEntity<TaskDetailResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.getTask(taskId))
    }


    @GetMapping("")
    fun getTasks(
        @RequestParam authorName: String?
    ): ResponseEntity<TasksResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.getTasks(authorName))
    }

    @PutMapping("{taskId}")
    fun updateTask(
        @PathVariable taskId: Long,
        @RequestBody taskRequestDto: TaskRequestDto
    ): ResponseEntity<TaskResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.updateTask(taskId, taskRequestDto))
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId: Long): ResponseEntity<StatusResponseDto> {
        taskService.deleteTask(taskId)
        return ResponseEntity.status(HttpStatus.OK)
            .body(StatusResponseDto("할 일이 삭제되었습니다."))
    }

    @PostMapping("/{taskId}")
    fun completeTask(@PathVariable taskId: Long): ResponseEntity<StatusResponseDto> {
        taskService.completeTask(taskId)
        return ResponseEntity.status(HttpStatus.OK)
            .body(StatusResponseDto("할 일이 완료처리 되었습니다."))
    }

}