package com.example.todoapi.task.service

import com.example.todoapi.security.jwt.JwtUtil
import com.example.todoapi.task.dto.TaskDetailResponseDto
import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.dto.TaskResponseDto
import com.example.todoapi.task.dto.TasksResponseDto
import com.example.todoapi.task.entity.Task
import com.example.todoapi.task.repository.TaskRepository
import com.example.todoapi.users.repository.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskService(
    val taskRepository: TaskRepository,
    val usersRepository: UsersRepository,
    val jwtUtil: JwtUtil
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

    @Transactional(readOnly = true)
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


    fun getTasks(authorName: String?): TasksResponseDto {
        if(authorName==null){
            return TasksResponseDto(taskRepository.findAllByOrderByCreatedAtDesc())
        }
        return TasksResponseDto((taskRepository.findAllByUserNameOrderByCreatedAtDesc(authorName)))
    }



    @Transactional
    fun updateTask(accessToken: String, taskId: Long, taskRequestDto: TaskRequestDto) : TaskResponseDto{
        val task = taskRepository.findById(taskId).orElseThrow()
        jwtUtil.validateToken(accessToken).onSuccess {
            if(usersRepository.findById(it.payload.subject.toLong()).orElseThrow().name!=task.userName){
                throw IllegalArgumentException()
            }
        }.onFailure { throw IllegalArgumentException() }

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