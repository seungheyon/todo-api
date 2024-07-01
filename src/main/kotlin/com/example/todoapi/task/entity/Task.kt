package com.example.todoapi.task.entity

import com.example.todoapi.comment.entity.Comment
import com.example.todoapi.common.entity.TimeStamp
import com.example.todoapi.exception.TaskContentsLengthException
import com.example.todoapi.exception.TaskTitleLengthException
import com.example.todoapi.task.constants.ContentsLengthPolicy
import com.example.todoapi.task.constants.TaskCategory
import com.example.todoapi.task.constants.TitleLengthPolicy
import com.example.todoapi.task.dto.TaskRequestDto
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.annotation.CreatedDate
import java.util.Date


@Table(name = "todo-api")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Task(
    var taskTitle: String,
    var taskDetails: String,
    var userName: String,
    val category: TaskCategory
) : TimeStamp() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    var isCompleted: Boolean = false

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    var comments: MutableList<Comment> = mutableListOf()

    init {
        validationTitleLength(TitleLengthPolicy.MIN.length, TitleLengthPolicy.MAX.length)
        validationContentsLength(ContentsLengthPolicy.MIN.length, ContentsLengthPolicy.MAX.length)
    }

    fun updateTask(taskRequestDto: TaskRequestDto) {
        this.taskTitle = taskRequestDto.taskTitle
        this.taskDetails = taskRequestDto.taskDetails
        this.userName = taskRequestDto.userName
        validationTitleLength(TitleLengthPolicy.MIN.length, TitleLengthPolicy.MAX.length)
        validationContentsLength(ContentsLengthPolicy.MIN.length, ContentsLengthPolicy.MAX.length)
    }

    fun setCompleteTrue() {
        this.isCompleted = true
    }

    private fun validationTitleLength(titleMinLength: Int, titleMaxLength: Int) {
        if (this.taskTitle.length !in titleMinLength..titleMaxLength) {
            throw TaskTitleLengthException(titleMinLength, titleMaxLength)
        }
    }

    private fun validationContentsLength(contentsMinLength: Int, contentsMaxLength: Int) {
        if (this.taskDetails.length !in contentsMinLength..contentsMaxLength) {
            throw TaskContentsLengthException(contentsMinLength, contentsMaxLength)
        }
    }

}