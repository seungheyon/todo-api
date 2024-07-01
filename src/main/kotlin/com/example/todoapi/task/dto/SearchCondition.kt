package com.example.todoapi.task.dto

import com.example.todoapi.task.constants.TaskCategory

data class SearchCondition(
    val title: String?,
    val category: String?,
    val isCompleted: Boolean?,
    val daysAgo: Int?
)
