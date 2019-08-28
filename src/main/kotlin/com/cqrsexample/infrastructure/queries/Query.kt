package com.cqrsexample.infrastructure.queries

import java.util.*


sealed class Query

data class GetAllInactiveTodos(val userId: UUID, val isComplete: Boolean = false) : Query()
data class GetTodo(val todoId: UUID) : Query()
data class GetAllActiveTodos(val userId: UUID, val isCoomplete: Boolean = true) : Query()
data class GetAllTodos(val userId: UUID) : Query()
