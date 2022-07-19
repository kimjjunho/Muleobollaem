package com.example.muleobollaemproject2.di.module

import com.example.data.handler.LoginErrorHandlerImpl
import com.example.data.handler.MainErrorHandlerImpl
import com.example.domain.handler.LoginErrorHandler
import com.example.domain.handler.MainErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ErrorHandlerModule {

    @Singleton
    @Provides
    fun mainErrorHandler() : MainErrorHandler = MainErrorHandlerImpl()

    @Singleton
    @Provides
    fun loginErrorHandler() : LoginErrorHandler = LoginErrorHandlerImpl()

}