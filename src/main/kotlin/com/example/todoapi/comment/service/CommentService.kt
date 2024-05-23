package com.example.todoapi.comment.service

import com.example.todoapi.comment.dto.CommentCreateRequestDto
import com.example.todoapi.comment.dto.CommentDeleteRequestDto
import com.example.todoapi.comment.dto.CommentResponseDto
import com.example.todoapi.comment.dto.CommentUpdateRequestDto
import com.example.todoapi.comment.entity.Comment
import com.example.todoapi.comment.repository.CommentRepository
import com.example.todoapi.exception.UserNotAuthorizedException
import com.example.todoapi.task.repository.TaskRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    val commentRepository: CommentRepository,
    val taskRepository: TaskRepository
) {
    fun createComment(commentRequestDto: CommentCreateRequestDto): CommentResponseDto {
        val task = taskRepository.findById(commentRequestDto.taskId).orElseThrow()
        val comment = Comment(
            commentDetails = commentRequestDto.commentDetails,
            userName = commentRequestDto.userName,
            password = commentRequestDto.password,
            task = task
        )
        val savedComment = commentRepository.save(comment)
        return CommentResponseDto(
            commentDetails = savedComment.commentDetails,
            userName = savedComment.userName,
            createdAt = savedComment.createdAt
        )
    }

    @Transactional
    fun updateComment(commentId : Long, commentUpdateRequestDto: CommentUpdateRequestDto): CommentResponseDto? {
        val comment = commentRepository.findById(commentId).orElseThrow()
        comment.updateComment(commentUpdateRequestDto)
        return CommentResponseDto(
            commentDetails = comment.commentDetails,
            userName = comment.userName,
            createdAt = comment.createdAt
        )
    }

    fun deleteComment(commentId: Long, taskId: Long, commentDeleteRequestDto: CommentDeleteRequestDto) {
        commentRepository.deleteById(commentId)
    }

}