package com.example.muleobollaemproject2.di.module.own

import com.example.data.remote.datasource.delete.RemoteDeleteDataSource
import com.example.data.remote.datasource.delete.RemoteDeleteDataSourceImpl
import com.example.data.remote.network.DeleteAPI
import com.example.domain.handler.DeleteErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DeleteDataSourceModule {
    @Singleton
    @Provides
    fun provideDeleteRemoteModule(
        deleteAPI: DeleteAPI,
        errorHandler: DeleteErrorHandler
    ): RemoteDeleteDataSource = RemoteDeleteDataSourceImpl(deleteAPI, errorHandler)
}