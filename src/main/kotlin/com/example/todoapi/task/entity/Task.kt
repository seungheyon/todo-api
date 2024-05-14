package com.example.todoapi.task.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import org.springframework.data.annotation.CreatedDate
import java.util.Date

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Task(
    var taskTitle : String,
    var taskDetails : String,
    var userName : String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}