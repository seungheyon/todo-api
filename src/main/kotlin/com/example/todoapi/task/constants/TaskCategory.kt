package com.example.todoapi.task.constants

import java.io.InvalidObjectException

enum class TaskCategory {
    MAIN,
    SUB;
    companion object {
        fun fromString(category: String): TaskCategory {
            return try {
                valueOf(category.uppercase())
            } catch (e: IllegalArgumentException) {
                throw InvalidObjectException("Invalid category")
            }
        }
    }
}