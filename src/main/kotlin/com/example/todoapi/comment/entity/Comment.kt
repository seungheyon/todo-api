package com.example.todoapi.comment.entity

import com.example.todoapi.comment.dto.CommentResponseDto
import com.example.todoapi.comment.dto.CommentUpdateRequestDto
import com.example.todoapi.common.entity.TimeStamp
import com.example.todoapi.exception.UserNotAuthorizedException
import com.example.todoapi.task.entity.Task
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comment")
class Comment(
    var commentDetails: String,
    var password: String,
    var userName: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    val task: Task
) : TimeStamp() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    fun updateComment(commentUpdateRequestDto: CommentUpdateRequestDto) {
        if(validateCommentAuthor(commentUpdateRequestDto.userName, commentUpdateRequestDto.password)){
            this.commentDetails = commentUpdateRequestDto.commentDetails
            return
        }
        throw UserNotAuthorizedException(commentUpdateRequestDto.userName, commentUpdateRequestDto.password)
    }

    fun validateCommentAuthor(inputUserName: String, inputPassword: String): Boolean {
        return (this.userName == inputUserName &&
                this.password == inputPassword)

    }

    fun toResponseDto(): CommentResponseDto {
        return CommentResponseDto(
            commentDetails = this.commentDetails,
            userName = this.userName,
            createdAt = this.createdAt
        )
    }

}

//fun Comment.toResponseDto(): CommentResponseDto {
//    return CommentResponseDto(
//        commentDetails = this.commentDetails,
//        userName = this.userName,
//        createdAt = this.createdAt
//    )
//}