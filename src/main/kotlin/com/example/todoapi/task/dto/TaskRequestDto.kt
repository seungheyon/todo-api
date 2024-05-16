package com.example.todoapi.task.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@AllArgsConstructor
@NoArgsConstructor
data class TaskRequestDto(
    var taskTitle : String,
    var taskDetails : String,
    var userName : String
) {}