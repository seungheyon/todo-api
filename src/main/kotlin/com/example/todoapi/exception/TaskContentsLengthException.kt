package com.example.todoapi.exception

data class TaskContentsLengthException(val contentsMinLength: Int, val contentsMaxLength: Int) : RuntimeException(
    "Task contents should be between $contentsMinLength and $contentsMaxLength characters."
) {
}
