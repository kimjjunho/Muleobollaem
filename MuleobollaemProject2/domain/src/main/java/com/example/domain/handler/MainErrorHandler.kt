package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface MainErrorHandler {
    fun getMainErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}