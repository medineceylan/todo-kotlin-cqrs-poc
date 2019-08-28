package com.cqrsexample.application.handlers

import com.cqrsexample.application.commands.MarkAsDoneTodoCommand
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.Todo
import com.cqrsexample.domain.repository.CommandRepository


fun execute(command: MarkAsDoneTodoCommand, todo: Todo): CmdResult {

    return todo.markAsDoneTodo(command.id)

}



