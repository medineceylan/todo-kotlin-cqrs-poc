package com.cqrsexample.application.handlers

import com.cqrsexample.application.commands.CreateTodoCommand
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.Todo

fun execute(command: CreateTodoCommand, todo: Todo): CmdResult {

    return todo.createTodo(command.userId, command.title, command.isComplete)

}


// Client - request -> Controller -> CommandFactory(request) - command -> CommandBus -> CommandHandler -> Map<UUID, CommandResponse> -> Controller -> CmdResult