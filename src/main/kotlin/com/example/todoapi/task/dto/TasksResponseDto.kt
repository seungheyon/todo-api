package com.example.todoapi.task.dto

import com.example.todoapi.common.dto.GeneralResponseDto
import com.example.todoapi.task.entity.Task

class TasksResponseDto(
    taskList: List<Task>
) : GeneralResponseDto {
    val taskResponseList: List<TaskResponseDto> = taskList.map {
        TaskResponseDto(
            id = it.id,
            taskTitle = it.taskTitle,
            taskDetail = it.taskDetails,
            username = it.userName
        )
    }
}