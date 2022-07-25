package com.example.domain.base

abstract class UseCase<T,E> {
    abstract suspend fun execute(data: T):E
}

abstract class UseCaseToken<H,T,E>{
    abstract suspend fun execute( header: H,data: T): E
}