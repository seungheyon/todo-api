package com.example.todoapi.exception

data class TaskTitleLengthException(val titleMinLength: Int, val titleMaxLength: Int) : RuntimeException(
    "Task Title should be between $titleMinLength and $titleMaxLength characters."
) {
}