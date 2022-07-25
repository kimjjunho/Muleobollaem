package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface DeleteErrorHandler {
    fun deleteErrorHandler(throwable: Throwable): ErrorHandlerEntity
}