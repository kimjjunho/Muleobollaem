package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface SignUpErrorHandler {
    fun signUpErrorHandler(throwable: Throwable): ErrorHandlerEntity
}