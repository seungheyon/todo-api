package com.example.todoapi.users.service

import com.example.todoapi.social.oauth2.dto.NaverUserInfoBodyDto
import com.example.todoapi.users.entity.Users
import com.example.todoapi.users.entity.socialUsers.NaverSocialUsers
import com.example.todoapi.users.repository.NaverSocialUsersRepository
import com.example.todoapi.users.repository.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsersService(
    private val usersRepository: UsersRepository,
    private val naverSocialUsersRepository: NaverSocialUsersRepository
) {
    @Transactional
    fun signin(userInfo: NaverUserInfoBodyDto) {
        val user = Users(
            name = userInfo.name
        )
        usersRepository.save(user)

        val naverUsers = NaverSocialUsers(
            naverId = userInfo.id,
            name = userInfo.name,
            users = user
        )
        naverSocialUsersRepository.save(naverUsers)
    }

}