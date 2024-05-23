package com.example.todoapi.comment.controller

import com.example.todoapi.comment.dto.CommentCreateRequestDto
import com.example.todoapi.comment.dto.CommentDeleteRequestDto
import com.example.todoapi.comment.dto.CommentResponseDto
import com.example.todoapi.comment.dto.CommentUpdateRequestDto
import com.example.todoapi.comment.service.CommentService
import com.example.todoapi.common.dto.StatusResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/task/{taskId}/comments")
@RestController
class CommentController(
    val commentService: CommentService
) {

    @PostMapping("")
    fun createComment(@RequestBody commentRequestDto: CommentCreateRequestDto)
            : ResponseEntity<CommentResponseDto> {
        val commentResponseDto: CommentResponseDto = commentService.createComment(commentRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(commentResponseDto)
    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable commentId: Long,
        @RequestBody commentUpdateRequestDto: CommentUpdateRequestDto
    )
            : ResponseEntity<CommentResponseDto> {
        val commentResponseDto = commentService.updateComment(commentId, commentUpdateRequestDto)
        return ResponseEntity.status(HttpStatus.OK)
            .body(commentResponseDto)
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable commentId: Long,
        @PathVariable taskId: Long,
        @RequestBody commentDeleteRequestDto: CommentDeleteRequestDto
    ): ResponseEntity<StatusResponseDto> {
        commentService.deleteComment(commentId, taskId, commentDeleteRequestDto)
        return ResponseEntity.status(HttpStatus.OK)
            .body(StatusResponseDto("댓글이 삭제되었습니다."))
    }

}