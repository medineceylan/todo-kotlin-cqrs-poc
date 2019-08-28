package com.cqrsexample.infrastructure.queries

data class QueryError(override var message: String) : Exception(message)



