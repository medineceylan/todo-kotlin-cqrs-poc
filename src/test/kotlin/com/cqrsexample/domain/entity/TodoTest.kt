package com.cqrsexample.domain.entity

import com.cqrsexample.domain.Todo
import com.cqrsexample.domain.repository.CommandRepository
import com.cqrsexample.domain.validator.Invalid
import com.cqrsexample.domain.validator.TodoItemError
import com.cqrsexample.domain.validator.Valid
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner
import java.util.*
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class TodoTest {


    @Mock
    lateinit var repo: CommandRepository


    var todo:Todo=Todo(repo)

    @Before
    fun init() {

    }

    @Test
    fun `should create a todo`() {

        var result = todo.createTodo(UUID.randomUUID(), "go to doctor", false)

        assertTrue { result is Valid }

    }

    @Test(expected = TodoItemError::class)
    fun `should throw error when there isn't any todo a problem while creating`() {

        var userId = UUID.randomUUID()

        //  `when`(repo.save(Todo.TodoItem(userId, userId, "go to doctor", false))).thenThrow(Error::class.java)


        var result = todo.createTodo(userId, "go to doctor", false)

        verify(repo)

        assertTrue { result is Invalid }


    }
}