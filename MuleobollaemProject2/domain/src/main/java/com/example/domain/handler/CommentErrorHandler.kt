package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity

interface CommentErrorHandler {
    fun getCommentErrorHandler(throwable: Throwable): ErrorHandlerEntity
}