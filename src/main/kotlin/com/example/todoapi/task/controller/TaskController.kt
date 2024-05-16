package com.example.todoapi.task.controller

import com.example.todoapi.common.dto.GeneralResponseDto
import com.example.todoapi.common.dto.StatusResponseDto
import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
class TaskController(
    val taskService : TaskService
) {

    @PostMapping("/tasks")
    fun createTask(
        @RequestBody taskRequestDto: TaskRequestDto
    ) : GeneralResponseDto {
        return taskService.createTask(taskRequestDto)
    }

    @GetMapping("/tasks/{taskId}")
    fun getTask(@PathVariable taskId : Long) : GeneralResponseDto {
        return try{
            taskService.getTask(taskId)
        } catch (e : NoSuchElementException){
            StatusResponseDto("조회한 ID 에 해당하는 task 가 존재하지 않습니다.")
        }
    }

    @GetMapping("/tasks")
    fun getTasks() : GeneralResponseDto {
        return taskService.getTasks()
    }

    @PutMapping("/tasks/{taskId}")
    fun updateTask(
        @PathVariable taskId : Long,
        @RequestBody taskRequestDto : TaskRequestDto
    ) : GeneralResponseDto {
        return try{
            taskService.updateTask(taskId, taskRequestDto)
        } catch (e : NoSuchElementException){
            StatusResponseDto("조회한 ID 에 해당하는 task 가 존재하지 않습니다.")
        }
    }

    @DeleteMapping("/tasks/{taskId}")
    fun deleteTask(@PathVariable taskId : Long) : GeneralResponseDto {
        try{
            taskService.deleteTask(taskId)
        }
        catch (e: IllegalArgumentException){
            return StatusResponseDto("잘못된 요청입니다.")
        }
        return StatusResponseDto("할 일이 삭제되었습니다.")
    }
}