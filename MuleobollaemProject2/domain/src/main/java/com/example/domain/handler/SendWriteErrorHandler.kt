package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface SendWriteErrorHandler {
    fun sendWriteErrorHandler(throwable: Throwable): ErrorHandlerEntity
}