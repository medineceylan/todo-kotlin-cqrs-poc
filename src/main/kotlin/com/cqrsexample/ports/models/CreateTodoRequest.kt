package com.cqrsexample.ports.models

import java.util.*

data class CreateTodoRequest(var userId: UUID, var title: String = "", var isComplete: Boolean = false)
