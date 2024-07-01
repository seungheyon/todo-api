package com.example.todoapi.task.repository

import com.example.todoapi.task.constants.TaskCategory
import com.example.todoapi.task.dto.SearchCondition
import com.example.todoapi.task.entity.QTask
import com.example.todoapi.task.entity.Task
import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory

class TaskQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : TaskQueryDslRepository{

    private val task = QTask.task

    override fun search(searchCondition: SearchCondition): List<Task> {
        return queryFactory
            .selectFrom(task)
            .where(
                taskTitleContains(searchCondition.title),
                taskCategoryEquals(searchCondition.category),
                taskIsCompleted(searchCondition.isCompleted)
            )
            .fetch()
    }

    private fun taskTitleContains(string: String?): BooleanExpression? {
        return string?.let { task.taskTitle.contains(it) }
    }

    private fun taskCategoryEquals(string: String?): BooleanExpression? {
        return string?.let {
            try {
                val category = TaskCategory.valueOf(it)
                task.category.eq(category)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }

    private fun taskIsCompleted(isCompleted: Boolean?): BooleanExpression? {
        return isCompleted?.let { task.isCompleted.eq(it) }
    }

}