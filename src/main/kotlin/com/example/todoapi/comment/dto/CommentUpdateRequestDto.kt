package com.example.todoapi.comment.dto

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
data class CommentUpdateRequestDto(
    val commentDetails: String,
    val userName: String,
    val password: String
)