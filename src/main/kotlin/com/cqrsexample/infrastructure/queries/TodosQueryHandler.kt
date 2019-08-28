package com.cqrsexample.infrastructure.queries

import com.cqrsexample.domain.validator.Validated
import com.cqrsexample.infrastructure.queries.dtos.TodoDTO
import com.cqrsexample.infrastructure.repositories.QueryRepository
import org.springframework.stereotype.Service

typealias QueryResult = Validated<QueryError, TodoDTO>

@Service
class TodosQueryHandler {


    companion object {

        fun processQuery(q: Query, repository: QueryRepository): QueryResult {

            return when (q) {
                is GetAllActiveTodos -> query(q, repository)
                is GetAllTodos -> query(q, repository)
                is GetAllInactiveTodos -> query(q, repository)
                is GetTodo -> query(q, repository)
            }
        }
    }
}


