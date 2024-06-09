package com.example.todoapi.users.repository

import com.example.todoapi.users.entity.Users
import org.springframework.data.jpa.repository.JpaRepository

interface UsersRepository : JpaRepository<Users, Long> {
}