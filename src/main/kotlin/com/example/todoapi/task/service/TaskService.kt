package com.example.todoapi.task.service

import com.example.todoapi.task.dto.TaskDetailResponseDto
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
            savedTask.userName,
            savedTask.isCompleted
        )
    }

    fun getTask(taskId: Long): TaskDetailResponseDto {
        val task = taskRepository.findById(taskId).orElseThrow()
        val comments = task.comments.map{it.toResponseDto()}
        return TaskDetailResponseDto(
            task.id,
            task.taskTitle,
            task.taskDetails,
            task.userName,
            task.isCompleted,
            comments
        )
    }

    fun getTasks(): TasksResponseDto {
        return TasksResponseDto(taskRepository.findAllByOrderByCreatedAtDesc())
    }

    @Transactional
    fun updateTask(taskId : Long, taskRequestDto: TaskRequestDto) : TaskResponseDto{
        val task = taskRepository.findById(taskId).orElseThrow()
        task.updateTask(taskRequestDto)
        return TaskResponseDto(
            task.id,
            task.taskTitle,
            task.taskDetails,
            task.userName,
            task.isCompleted
        )
    }

    fun deleteTask(taskId: Long) {
        taskRepository.deleteById(taskId)
    }

    @Transactional
    fun completeTask(taskId: Long) {
        val task = taskRepository.findById(taskId).orElseThrow()
        task.setCompleteTrue()
    }

}