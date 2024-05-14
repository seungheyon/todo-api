package com.example.todoapi.task.service

import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.entity.Task
import com.example.todoapi.task.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(
    val taskRepository: TaskRepository
) {

    fun createTask(taskRequestDto: TaskRequestDto): TaskResponseDto {
        val task = Task(
            taskRequestDto.taskTitle,
            taskRequestDto.taskDetails,
            taskRequestDto.userName
        )
        val savedTask: Task = taskRepository.save(task)
        return TaskResponseDto(
            savedTask.id,
            savedTask.taskTitle,
            savedTask.taskDetails,
            savedTask.userName
        )
    }
}