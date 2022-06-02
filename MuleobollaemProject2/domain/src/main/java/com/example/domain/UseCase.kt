package com.example.domain

abstract class UseCase<T,E> {
    abstract suspend fun execute(data: T):E
}