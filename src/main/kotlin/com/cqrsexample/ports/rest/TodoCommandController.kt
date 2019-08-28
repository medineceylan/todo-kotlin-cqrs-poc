package com.cqrsexample.ports.rest

import com.cqrsexample.application.commands.CreateTodoCommand
import com.cqrsexample.application.commands.MarkAsDoneTodoCommand
import com.cqrsexample.application.commands.RemoveTodoCommand
import com.cqrsexample.application.commands.RenameTodoCommand
import com.cqrsexample.application.handlers.CommandFactory
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.repository.CommandRepository
import com.cqrsexample.domain.validator.Valid
import com.cqrsexample.ports.models.CreateTodoRequest
import com.cqrsexample.ports.models.MarkAsDoneRequest
import com.cqrsexample.ports.models.RemoveTodoRequest
import com.cqrsexample.ports.models.RenameTodoRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/todos")
class TodoCommandController(private val repository: CommandRepository) {


    @PostMapping("/create")
    fun createTodo(@RequestBody request: CreateTodoRequest): ResponseEntity<CmdResult> {

        //request validation yap sonra commanda cevir

        val command = CreateTodoCommand(request.userId, request.title, request.isComplete)
        val cmdResult = CommandFactory.apply(command, repository)

        if (cmdResult == Valid(request.userId)) {
            return ResponseEntity(cmdResult, HttpStatus.CREATED)
        }

        return ResponseEntity(cmdResult, HttpStatus.INTERNAL_SERVER_ERROR)

    }

    @PatchMapping("/rename")
    fun renameTodo(@RequestBody request: RenameTodoRequest): ResponseEntity<CmdResult> {

        val command = RenameTodoCommand(request.id, request.title)
        val cmdResult = CommandFactory.apply(command, repository)

        if (cmdResult == Valid(request.id)) {
            return ResponseEntity(cmdResult, HttpStatus.OK)
        }

        return ResponseEntity(cmdResult, HttpStatus.INTERNAL_SERVER_ERROR)

    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    fun removeTodo(@RequestBody request: RemoveTodoRequest) {

        val command = RemoveTodoCommand(request.todoId)
        CommandFactory.apply(command, repository)

    }

    @PatchMapping("/markAsDone")
    @ResponseStatus(HttpStatus.OK)
    fun markAsDone(@RequestBody request: MarkAsDoneRequest) {

        val command = MarkAsDoneTodoCommand(request.todoId)
        CommandFactory.apply(command, repository)
    }


}