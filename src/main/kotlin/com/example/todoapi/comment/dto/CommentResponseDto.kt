package com.example.todoapi.comment.dto

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import java.util.Date

@Getter
@AllArgsConstructor
@NoArgsConstructor
data class CommentResponseDto(
    val commentDetails: String,
    val userName : String,
    val createdAt : Date?
)