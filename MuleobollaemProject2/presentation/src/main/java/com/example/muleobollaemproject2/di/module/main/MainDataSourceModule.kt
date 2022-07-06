package com.example.muleobollaemproject2.di.module.main

import com.example.data.local.dao.MainDao
import com.example.data.local.datasource.LocalMainDataSource
import com.example.data.local.datasource.LocalMainDataSourceImpl
import com.example.data.remote.datasource.RemoteMainDataSource
import com.example.data.remote.datasource.RemoteMainDataSourceImpl
import com.example.data.remote.network.MainAPI
import com.example.domain.handler.MainErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainDataSourceModule {
    @Singleton
    @Provides
    fun provideMainRemoteDataSource(
        mainAPI: MainAPI,
        errorHandler: MainErrorHandler
    ):RemoteMainDataSource = RemoteMainDataSourceImpl(mainAPI, errorHandler)

    @Singleton
    @Provides
    fun provideMainDataSource(
        mainDao: MainDao
    ) : LocalMainDataSource = LocalMainDataSourceImpl(mainDao)
}