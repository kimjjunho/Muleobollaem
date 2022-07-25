package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface PutErrorHandler {
    fun putErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}