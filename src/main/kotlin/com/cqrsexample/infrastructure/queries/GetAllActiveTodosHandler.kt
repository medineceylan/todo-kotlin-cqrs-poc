package com.cqrsexample.infrastructure.queries

import com.cqrsexample.domain.validator.Invalid
import com.cqrsexample.domain.validator.Valid
import com.cqrsexample.infrastructure.queries.dtos.TodoDTO
import com.cqrsexample.infrastructure.repositories.QueryRepository

fun query(query: GetAllActiveTodos, repository: QueryRepository): QueryResult {


    val todos = repository.findAll().filter { item -> !item.isComplete && item.userId.equals(query.userId) }

    val todoDTO = TodoDTO(query.userId, TodoDTO.toDTO(todos))


    return Valid(todoDTO)

}