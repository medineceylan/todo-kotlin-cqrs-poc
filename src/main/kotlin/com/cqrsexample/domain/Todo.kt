package com.cqrsexample.domain

import com.cqrsexample.domain.repository.CommandRepository
import com.cqrsexample.domain.validator.*
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


typealias CmdResult = Validated<DomainError, UUID>

class Todo(val repository: CommandRepository) {


    fun createTodo(userId: UUID, title: String, isComplete: Boolean): CmdResult {

        val todoItem = TodoItem(userId, userId, title, isComplete)

        repository.save(todoItem)
        return Valid(userId)

    }


    fun renameTodo(id: UUID, newTitle: String): CmdResult {

        val todoItem = repository.findById(id)
        if (!todoItem.isPresent) return Invalid(TodoItemError("There isn't any todo with id:$id", id))

        todoItem.get().apply { title = newTitle }

        repository.save((todoItem.get()))

        return Valid(id)


    }


    fun removeTodo(id: UUID): CmdResult {

        val todoItem = repository.findById(id)

        if (todoItem.isPresent) return Invalid(TodoItemError("There isn't any todo with id: $id", id))

        repository.deleteById((todoItem.get().id))

        return Valid(todoItem.get().id)


    }

    //Todo:do it as functional format and eliminate code duplication

    fun markAsDoneTodo(id: UUID): CmdResult {


        val todoItem = repository.findById(id)

        if (!todoItem.isPresent) return Invalid(TodoItemError("There isn't any todo with id: $id", id))

        todoItem.get().apply { isComplete = true }

        repository.save(todoItem.get())

        return Valid(todoItem.get().id)


    }

    @Entity
    data class TodoItem(
            @Id
            @GeneratedValue(generator = "UUID")
            val id: UUID,
            var userId: UUID,
            var title: String,
            var isComplete: Boolean
    )

    @Entity
    data class User(
            @Id
            @GeneratedValue(generator = "UUID")
            @GenericGenerator(
                    name = "UUID",
                    strategy = "org.hibernate.id.UUIDGenerator"
            )
            @ColumnDefault("random_uuid()")
            val id: UUID,
            val name: String,
            val surname: String

    )

}