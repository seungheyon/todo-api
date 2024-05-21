package com.example.todoapi.exception

data class ModelNotFoundException(val modelName : String, val id : Long) : RuntimeException(
    "Model $modelName is Not found by id $id"
) {
}