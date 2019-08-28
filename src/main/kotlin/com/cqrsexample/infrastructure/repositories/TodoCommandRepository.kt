package com.cqrsexample.infrastructure.repositories

import com.cqrsexample.domain.Todo
import com.cqrsexample.domain.repository.CommandRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface TodoCommandRepository : JpaRepository<Todo.TodoItem, UUID>,CommandRepository {


}

