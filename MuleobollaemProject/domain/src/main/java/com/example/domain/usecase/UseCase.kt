package com.example.domain.usecase

abstract class UseCase<T, E> {
    abstract suspend fun execute(data: T):E
}