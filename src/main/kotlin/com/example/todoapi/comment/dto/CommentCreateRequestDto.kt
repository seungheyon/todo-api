package com.example.todoapi.comment.dto

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
data class CommentCreateRequestDto(
    val commentDetails : String,
    val password : String,
    val userName : String
)
