package com.example.todoapi.task.dto

import com.example.todoapi.task.entity.Task
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@AllArgsConstructor
@NoArgsConstructor
class TaskResponseDto(
    var id : Long?,
    var taskTitle : String,
    var taskDetail : String,
    var username : String
) {

    fun TaskResponseDto(task : Task){
        this.id = task.id
        this.taskTitle = task.taskTitle
        this.taskDetail = task.taskDetails
        this.username = task.userName
    }
}