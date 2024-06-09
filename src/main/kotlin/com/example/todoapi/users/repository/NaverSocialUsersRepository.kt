package com.example.todoapi.users.repository

import com.example.todoapi.users.entity.socialUsers.NaverSocialUsers
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NaverSocialUsersRepository : JpaRepository<NaverSocialUsers, String> {
}