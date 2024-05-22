package com.example.todoapi.comment.repository

import com.example.todoapi.comment.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>{
}