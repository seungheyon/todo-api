package com.example.todoapi.task.dto

import com.example.todoapi.common.dto.GeneralResponseDto
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
    ) : GeneralResponseDto {
}