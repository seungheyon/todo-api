package com.example.todoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class TodoApiApplication

fun main(args: Array<String>) {
    runApplication<TodoApiApplication>(*args)
}
