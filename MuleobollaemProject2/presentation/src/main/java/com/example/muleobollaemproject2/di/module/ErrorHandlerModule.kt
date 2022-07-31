package com.example.muleobollaemproject2.di.module

import com.example.data.handler.*
import com.example.domain.handler.*
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

    @Singleton
    @Provides
    fun signUpErrorHandler(): SignUpErrorHandler = SignUpErrorHandlerImpl()

    @Singleton
    @Provides
    fun sendWriteErrorHandler(): SendWriteErrorHandler = SendWriteErrorHandlerImpl()

    @Singleton
    @Provides
    fun deletePostErrorHandler(): DeleteErrorHandler = DeleteErrorHandlerImpl()

    @Singleton
    @Provides
    fun putErrorHandler(): PutErrorHandler = PutErrorHandlerImpl()

    @Singleton
    @Provides
    fun checkIdErrorHandler(): CheckIdErrorHandler = CheckIdErrorHandlerImpl()

    @Singleton
    @Provides
    fun commentErrorHandler(): CommentErrorHandler = CommentErrorHandlerImpl()

    @Singleton
    @Provides
    fun postCommentErrorHandler(): PutCommentErrorHandler = PutCommentErrorHandlerImpl()
}