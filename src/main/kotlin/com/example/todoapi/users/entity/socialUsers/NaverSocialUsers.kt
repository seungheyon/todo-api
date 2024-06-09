package com.example.todoapi.users.entity.socialUsers

import com.example.todoapi.users.entity.Users
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
class NaverSocialUsers(
    @Id
    val naverId: String,
    val name: String,
    @OneToOne
    @JoinColumn(name = "users_id")
    val users: Users
) {
}