package com.example.todoapi.users.repository

import org.springframework.stereotype.Repository

@Repository
interface ISocialUserRepository {
    fun isExistUserById(socialId : String): Boolean
}