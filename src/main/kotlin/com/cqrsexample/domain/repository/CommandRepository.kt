package com.cqrsexample.domain.repository

import com.cqrsexample.domain.Todo
import java.util.*

interface CommandRepository {

    fun findById(id: UUID): Optional<Todo.TodoItem>
    fun save(todo: Todo.TodoItem)
    fun deleteById(id: UUID)

}