package com.example.todoapi.task.service

import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.dto.TasksResponseDto
import com.example.todoapi.task.entity.Task
import com.example.todoapi.task.repository.TaskRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    fun getTask(taskId: Long): TaskResponseDto {
        val task = taskRepository.findById(taskId).orElseThrow()
        return TaskResponseDto(
            task.id,
            task.taskTitle,
            task.taskDetails,
            task.userName
        )
    }

    fun getTasks(): TasksResponseDto {
        return TasksResponseDto(taskRepository.findAll())
    }

    @Transactional
    fun updateTask(taskId : Long, taskRequestDto: TaskRequestDto) : TaskResponseDto{
        val task = taskRepository.findById(taskId).orElseThrow()
        task.updateTask(taskRequestDto)
        return TaskResponseDto(
            task.id,
            task.taskTitle,
            task.taskDetails,
            task.userName
        )
    }

    fun deleteTask(taskId: Long) {
        taskRepository.deleteById(taskId)
    }

}