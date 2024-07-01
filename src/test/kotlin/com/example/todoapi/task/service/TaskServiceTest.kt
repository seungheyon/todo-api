package com.example.todoapi.task.service

import com.example.todoapi.security.jwt.JwtUtil
import com.example.todoapi.task.constants.TaskCategory
import com.example.todoapi.task.dto.TaskRequestDto
import com.example.todoapi.task.repository.TaskQueryDslRepositoryImpl
import com.example.todoapi.task.repository.TaskRepository
import com.example.todoapi.users.repository.UsersRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
class TaskServiceTest @Autowired constructor(
    //private val taskService: TaskService,
    private val taskRepository: TaskRepository,
    private val userRepository: UsersRepository,
    private val jwtUtil: JwtUtil
) {

    @Test
    fun createTaskTest() {
        // Arrange
        val sut = TaskService(taskRepository, userRepository, jwtUtil)
        val taskTitle = "testTitle"
        val taskDetails = "testDetails"
        val taskAuthor = "testAuthor"
        val taskCategory = "MAIN"
        val taskRequestDto = TaskRequestDto(taskTitle, taskDetails, taskAuthor, taskCategory)

        // Act
        val actual = sut.createTask(taskRequestDto)

        // Assert
        assertThat(actual.id).isNotNull
        assertThat(actual.taskTitle).isEqualTo(taskTitle)
        assertThat(actual.taskDetail).isEqualTo(taskDetails)
        assertThat(actual.username).isEqualTo(taskAuthor)
    }


}