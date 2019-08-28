package com.cqrsexample.infrastructure.queries

import com.cqrsexample.domain.validator.Invalid
import com.cqrsexample.domain.validator.Valid
import com.cqrsexample.infrastructure.queries.dtos.TodoDTO
import com.cqrsexample.infrastructure.repositories.QueryRepository
import java.util.*

fun query(query: GetTodo, repository: QueryRepository): QueryResult {

    try {
        val todoId = query.todoId
        val todo = repository.findById(todoId)

        if (todo.isPresent) {

            return Valid(TodoDTO(UUID.randomUUID(), listOf(TodoDTO.TodoItemDTO(todoId, todo.get().title, todo.get().isComplete))))

        }
        return Invalid(QueryError("There isn't any Todo with given id: $todoId"))
//todo: option monadi don
    } catch (e: Exception) {
        return Invalid(QueryError("Unexpected error happened:${e.message}"))
    }


}