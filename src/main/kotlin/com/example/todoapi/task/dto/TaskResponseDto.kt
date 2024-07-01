package com.example.todoapi.task.dto

import com.example.todoapi.comment.entity.Comment
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

data class TaskResponseDto(
    var id : Long?,
    var taskTitle : String,
    var taskDetail : String,
    var username : String,
    var isCompleted : Boolean
    ) {
}