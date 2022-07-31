package com.example.muleobollaemproject2.di.module.own

import com.example.data.remote.datasource.put.RemotePutCommentDataSource
import com.example.data.remote.datasource.put.RemotePutCommentDataSourceImpl
import com.example.data.remote.network.PutAPI
import com.example.domain.handler.PutCommentErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PutCommentDataSourceModule {
    @Singleton
    @Provides
    fun providePutCommentModule(
        putAPI: PutAPI,
        errorHandler: PutCommentErrorHandler
    ): RemotePutCommentDataSource = RemotePutCommentDataSourceImpl(putAPI,errorHandler)
}