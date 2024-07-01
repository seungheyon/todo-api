package com.example.todoapi.task.dto

import com.example.todoapi.task.constants.TaskCategory
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor


data class TaskRequestDto(
    var taskTitle : String,
    var taskDetails : String,
    var userName : String,
    var category: String
)