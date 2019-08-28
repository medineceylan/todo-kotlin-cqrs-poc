package com.cqrsexample.application.handlers

import com.cqrsexample.application.commands.RemoveTodoCommand
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.Todo

fun execute(command: RemoveTodoCommand, todo: Todo): CmdResult {

    return todo.removeTodo(command.id)


}