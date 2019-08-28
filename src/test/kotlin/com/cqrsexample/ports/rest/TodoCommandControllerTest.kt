package com.cqrsexample.ports.rest

import com.cqrsexample.domain.repository.CommandRepository
import com.cqrsexample.domain.validator.Valid
import com.cqrsexample.ports.models.CreateTodoRequest
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import java.util.*
import kotlin.test.assertTrue

class TodoCommandControllerTest {

    @Mock
    lateinit var repository: CommandRepository

    @InjectMocks
    var todoCommandController = TodoCommandController(repository)


    @Test
    fun createTodo() {

        val userId = UUID.randomUUID()
        val request = CreateTodoRequest(userId, "go to dr", false)


        val result = Valid(userId)

        // Mockito.`when`(repository.save(ArgumentMatchers.any())).thenReturn(ArgumentMatchers.any())

        val response = todoCommandController.createTodo(request)
      //  assertTrue { response.body.equals(result) }


        //  var todoId = template.postForObject("/todos", createTodoRequest, CreateTodoRequest::class.java)
        // Assert.assertNotNull(todoId)
    }




//    @Test
//    fun renameTodo() {
//
//        var renameTodoRequest = RenameTodoRequest(UUID.randomUUID(), "go to spec-saver")
//        var todoId = template.patchForObject("/todos/rename", renameTodoRequest, RenameTodoRequest::class.java)
//        Assert.assertNotNull(todoId)
//    }

}