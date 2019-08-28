package com.cqrsexample.application.handlers

import com.cqrsexample.application.commands.RenameTodoCommand
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.Todo

fun execute(command: RenameTodoCommand, todo: Todo): CmdResult {

    return todo.renameTodo(command.id, command.title)

}