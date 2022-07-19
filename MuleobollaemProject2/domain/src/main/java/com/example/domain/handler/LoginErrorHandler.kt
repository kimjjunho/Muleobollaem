package com.example.domain.handler

import com.example.domain.base.ErrorHandlerEntity
import org.xml.sax.ErrorHandler

interface LoginErrorHandler {
    fun getLoginErrorHandler(throwable: Throwable) : ErrorHandlerEntity
}