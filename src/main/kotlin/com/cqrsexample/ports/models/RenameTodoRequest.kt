package com.cqrsexample.ports.models

import java.util.*

data class RenameTodoRequest(var id: UUID = UUID.fromString("0"), var title: String = "")

