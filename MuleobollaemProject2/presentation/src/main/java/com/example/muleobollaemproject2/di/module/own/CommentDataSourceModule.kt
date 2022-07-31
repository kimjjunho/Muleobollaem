package com.example.muleobollaemproject2.di.module.own

import com.example.data.local.dao.CommentDao
import com.example.data.local.datasource.comment.LocalGetCommentDataSource
import com.example.data.local.datasource.comment.LocalGetCommentDataSourceImpl
import com.example.data.remote.datasource.see.RemoteGetCommentDataSource
import com.example.data.remote.datasource.see.RemoteGetCommentDataSourceImpl
import com.example.data.remote.network.CommentAPI
import com.example.domain.handler.CommentErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommentDataSourceModule {
    @Singleton
    @Provides
    fun provideCommentRemoteDataSource(
        commentAPI: CommentAPI,
        errorHandler: CommentErrorHandler
    ): RemoteGetCommentDataSource = RemoteGetCommentDataSourceImpl(commentAPI, errorHandler)

    @Singleton
    @Provides
    fun provideCommentDataSource(
        commentDao: CommentDao
    ): LocalGetCommentDataSource = LocalGetCommentDataSourceImpl(commentDao)
}