package com.cqrsexample.infrastructure.queries

import com.cqrsexample.domain.validator.Invalid
import com.cqrsexample.domain.validator.Valid
import com.cqrsexample.infrastructure.queries.dtos.TodoDTO
import com.cqrsexample.infrastructure.repositories.QueryRepository

fun query(query: GetAllInactiveTodos, repository: QueryRepository): QueryResult {

    try {
        val todos = repository.findAll().filter { item -> item.isComplete && item.userId.equals(query.userId) }

        val todoDTO = TodoDTO(query.userId, TodoDTO.toDTO(todos))

        return Valid(todoDTO)

    } catch (e: Exception) {
        return Invalid(QueryError("Unexpected error happened:${e.message}"))
    }

}