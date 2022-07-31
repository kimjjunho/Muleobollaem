package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface PutCommentErrorHandler {
    fun putCommentErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}