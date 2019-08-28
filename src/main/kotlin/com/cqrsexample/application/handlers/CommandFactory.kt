package com.cqrsexample.application.handlers

import com.cqrsexample.application.commands.*
import com.cqrsexample.domain.CmdResult
import com.cqrsexample.domain.Todo
import com.cqrsexample.domain.repository.CommandRepository

class CommandFactory {


    companion object {

        fun apply(c: Command, repository: CommandRepository): CmdResult {
            val todo = Todo(repository)

            val cmdResult = when (c) {

                is CreateTodoCommand -> execute(c, todo)
                is MarkAsDoneTodoCommand -> execute(c, todo)
                is RemoveTodoCommand -> execute(c, todo)
                is RenameTodoCommand -> execute(c, todo)
            }
            return cmdResult
        }
    }

}