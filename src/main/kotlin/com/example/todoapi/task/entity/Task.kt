package com.example.todoapi.task.entity

import com.example.todoapi.common.entity.TimeStamp
import com.example.todoapi.task.dto.TaskRequestDto
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.annotation.CreatedDate
import java.util.Date


@Table(name="todo-api")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
class Task(
    var taskTitle : String,
    var taskDetails : String,
    var userName : String,
) : TimeStamp() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    fun updateTask(taskRequestDto: TaskRequestDto){
        this.taskTitle = taskRequestDto.taskTitle
        this.taskDetails = taskRequestDto.taskDetails
        this.userName = taskRequestDto.userName
    }
}