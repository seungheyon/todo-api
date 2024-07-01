package com.example.todoapi.task.repository

import com.example.todoapi.task.dto.SearchCondition
import com.example.todoapi.task.entity.Task

interface TaskQueryDslRepository {
    fun search(searchCondition: SearchCondition): List<Task>
}