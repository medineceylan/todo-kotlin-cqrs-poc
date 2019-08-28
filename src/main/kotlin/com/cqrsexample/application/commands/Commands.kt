package com.cqrsexample.application.commands

import java.util.*

sealed class Command
data class CreateTodoCommand(val userId: UUID, val title: String, val isComplete: Boolean) : Command()
data class MarkAsDoneTodoCommand(val id: UUID) : Command()
data class RenameTodoCommand(val id: UUID, val title: String) : Command()
data class RemoveTodoCommand(val id: UUID) : Command()


