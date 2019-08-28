package com.cqrsexample.ports.rest.integration

import com.cqrsexample.ports.models.CreateTodoRequest
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.test.assertTrue


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoCommandControllerIntegrationTest {

    @Autowired
    lateinit var template: TestRestTemplate

    val userId = UUID.fromString("036b0e08-2dba-4afd-8e4f-f7922e7fe522")


    @Test
    fun `Should create todo item and return as valid`() {

        val request = CreateTodoRequest(userId, "go to dr", false)
        val response = template.postForObject("/todos/create", request, String::class.java)

        assertTrue { response.contains("{value:036b0e08-2dba-4afd-8e4f-f7922e7fe522}") }

    }

    @Test
    fun `Should rename todo item and return as valid`(){


    }

//
//    @Test
//    fun `Should return valid  while renaming`() {
//
//        val renameTodoRequest = RenameTodoRequest(UUID.fromString("036b0e08-2dba-4afd-8e4f-f7922e7fe522"), "go to spec-saver")
//        val todoId = template.patchForObject("/todos/rename", renameTodoRequest, String::class.java)
//        Assert.assertNotNull(todoId)
//        assertTrue { todoId.contains("Valid(value=036b0e08-2dba-4afd-8e4f-f7922e7fe522") }
//    }
//
//    @Test
//    fun `Should return valid  while markAsDone`() {
//
//        val renameTodoRequest = RenameTodoRequest(UUID.fromString("036b0e08-2dba-4afd-8e4f-f7922e7fe522"), "go to spec-saver")
//        val todoId = template.patchForObject("/todos/rename", renameTodoRequest, String::class.java)
//        Assert.assertNotNull(todoId)
//        assertTrue { todoId.contains("Valid(value=") }
//    }
//
//    @Test
//    fun `Should return valid  while deleting todo item`() {
//
//        val removeTodoRequest = RemoveTodoRequest(UUID.fromString("036b0e08-2dba-4afd-8e4f-f7922e7fe522"))
//        val todoId = template.patchForObject("/todos/remove", removeTodoRequest, String::class.java)
//        assertTrue { todoId.contains("Valid(value=") }
//    }


}