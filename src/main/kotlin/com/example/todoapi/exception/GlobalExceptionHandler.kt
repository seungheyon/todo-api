package com.example.todoapi.exception

import com.example.todoapi.exception.dto.ErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException :: class)
    fun noSuchElementExceptionHandler(e : NoSuchElementException) : ResponseEntity<ErrorResponseDto>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ErrorResponseDto(e.message))
    }

    @ExceptionHandler(UserNotAuthorizedException :: class)
    fun userNotAuthorizedExceptionHandler(e : UserNotAuthorizedException) : ResponseEntity<ErrorResponseDto>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponseDto(e.message))
    }

    @ExceptionHandler(TaskTitleLengthException :: class)
    fun taskTitleLengthExceptionHandler(e : TaskTitleLengthException) : ResponseEntity<ErrorResponseDto>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponseDto(e.message))
    }

    @ExceptionHandler(TaskContentsLengthException :: class)
    fun taskContentsLengthExceptionHandler(e : TaskContentsLengthException) : ResponseEntity<ErrorResponseDto>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponseDto(e.message))
    }
}