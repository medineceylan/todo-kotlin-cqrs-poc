package com.cqrsexample.infrastructure.repositories

import com.cqrsexample.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface QueryRepository : JpaRepository<Todo.TodoItem, UUID> {




}