package com.cqrsexample.domain.validator

import java.util.*

sealed class DomainError(override var message: String) : Exception(message)

data class TodoItemError(val e: String, val id: UUID) : DomainError(e)

