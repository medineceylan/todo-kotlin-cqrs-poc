package com.cqrsexample.infrastructure.queries.dtos

import com.cqrsexample.domain.Todo
import java.util.*

data class TodoDTO(val userId: UUID, val todos: List<TodoItemDTO>) {


    data class TodoItemDTO(val id: UUID, val title: String, val isComplete: Boolean)

    companion object {

        fun toDTO(todos: List<Todo.TodoItem>): List<TodoDTO.TodoItemDTO> {

            val todoItemDtos = mutableListOf<TodoDTO.TodoItemDTO>()

            todos.forEach { item -> todoItemDtos.add(TodoDTO.TodoItemDTO(item.id, item.title, item.isComplete)) }
            return todoItemDtos
        }
    }

}