package com.example.todoapi.task.controller

import com.example.todoapi.common.dto.StatusResponseDto
import com.example.todoapi.security.jwt.JwtUtil
import com.example.todoapi.task.dto.*
import com.example.todoapi.task.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/tasks")
@RestController
class TaskController(
    val taskService: TaskService,
    val jwtUtil: JwtUtil
) {

    @PostMapping("")
    fun createTask(
        @RequestBody taskRequestDto: TaskRequestDto,
        @RequestHeader("Authorization") accessToken: String
    ): ResponseEntity<TaskResponseDto> {
        jwtUtil.validateToken(accessToken).onFailure { throw IllegalArgumentException("잘못된 토큰입니다.") }
        val taskResponseDto = taskService.createTask(taskRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(taskResponseDto)
    }

    @GetMapping("/{taskId}")
    fun getTask(
        @PathVariable taskId: Long
    ): ResponseEntity<TaskDetailResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.getTask(taskId))
    }


//    @GetMapping("")
//    fun getTasks(
//        @RequestParam authorName: String?
//    ): ResponseEntity<TasksResponseDto> {
//        return ResponseEntity.status(HttpStatus.OK)
//            .body(taskService.getTasks(authorName))
//    }

    @GetMapping("")
    fun searchTasks(
        @ModelAttribute searchCondition: SearchCondition
    ): ResponseEntity<TasksResponseDto>{
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.searchTasks(searchCondition))
    }

    @PutMapping("{taskId}")
    fun updateTask(
        @PathVariable taskId: Long,
        @RequestBody taskRequestDto: TaskRequestDto,
        @RequestHeader("Authorization") accessToken: String
    ): ResponseEntity<TaskResponseDto> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(taskService.updateTask(accessToken, taskId, taskRequestDto))
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