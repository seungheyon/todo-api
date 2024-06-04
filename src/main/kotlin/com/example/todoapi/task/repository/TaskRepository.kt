package com.example.todoapi.task.repository

import com.example.todoapi.task.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : JpaRepository<Task, Long> {
    fun findAllByOrderByCreatedAtDesc(): List<Task>
    fun findAllByUserNameOrderByCreatedAtDesc(authorName: String) : List<Task>
}