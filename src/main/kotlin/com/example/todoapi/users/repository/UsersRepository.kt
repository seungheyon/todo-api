package com.example.todoapi.users.repository

import com.example.todoapi.users.entity.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Users, Long> {
     //fun findByTaskId(taskId: Long): Users
}