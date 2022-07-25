package com.example.muleobollaemproject2.di.module.own

import com.example.data.remote.datasource.write.RemoteSendWriteDataSource
import com.example.data.remote.datasource.write.RemoteSendWriteDataSourceImpl
import com.example.data.remote.network.WriteAPI
import com.example.domain.handler.SendWriteErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WriteDataSourceModule {
    @Singleton
    @Provides
    fun provideSendWriteRemoteModule(
        writeAPI: WriteAPI,
        errorHandler: SendWriteErrorHandler
    ): RemoteSendWriteDataSource = RemoteSendWriteDataSourceImpl(writeAPI, errorHandler)
}