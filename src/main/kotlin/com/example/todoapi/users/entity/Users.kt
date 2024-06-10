package com.example.todoapi.users.entity

import com.example.todoapi.task.entity.Task
import com.example.todoapi.users.entity.socialUsers.NaverSocialUsers
import jakarta.persistence.*

@Entity
class Users(
    val name: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany
    var tasks: List<Task> = ArrayList<Task>()
}