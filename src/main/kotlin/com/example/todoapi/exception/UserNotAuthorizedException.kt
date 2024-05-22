package com.example.todoapi.exception

data class UserNotAuthorizedException(val userName : String, val password : String) : RuntimeException(
    "UserName $userName and Password $password is Not valid"
) {
}