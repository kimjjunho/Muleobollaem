package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface CheckIdErrorHandler {
    fun checkIdErrorHandler(throwable: Throwable): ErrorHandlerEntity
}