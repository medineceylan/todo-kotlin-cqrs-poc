package com.cqrsexample.ports.rest

import com.cqrsexample.infrastructure.queries.*
import com.cqrsexample.infrastructure.repositories.QueryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/query")
class TodoQueryController(private val repository: QueryRepository) {


    @GetMapping("/find-by-id/{id}")
    fun findById(@PathVariable id: UUID): QueryResult {
        return TodosQueryHandler.processQuery(GetTodo(id), repository)
    }

    @GetMapping("/all-active-todos/{userId}")
    fun findUserAllActiveTodos(@PathVariable userId: UUID): QueryResult {
        return TodosQueryHandler.processQuery(GetAllActiveTodos(userId), repository)
    }

    @GetMapping("/all-inactive-todos/{userId}")
    fun findUserAllInActiveTodos(@PathVariable userId: UUID): QueryResult {
        return TodosQueryHandler.processQuery(GetAllInactiveTodos(userId), repository)
    }

    @GetMapping("/all-todos/{userId}")
    fun findUserAllTodos(@PathVariable userId: UUID): QueryResult {
        return TodosQueryHandler.processQuery(GetAllTodos(userId), repository)
    }
}