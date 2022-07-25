package com.example.muleobollaemproject2.di.module.own

import com.example.data.remote.datasource.put.RemotePutPostDataSource
import com.example.data.remote.datasource.put.RemotePutPostDataSourceImpl
import com.example.data.remote.network.PutAPI
import com.example.domain.handler.PutErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PutDataSourceModule {
    @Singleton
    @Provides
    fun providePutRemoteModule(
        putAPI: PutAPI,
        errorHandler: PutErrorHandler
    ):RemotePutPostDataSource = RemotePutPostDataSourceImpl(putAPI, errorHandler)
}