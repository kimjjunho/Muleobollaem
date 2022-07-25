package com.example.muleobollaemproject2.di.module.main

import com.example.data.remote.datasource.RemoteLoginDataSource
import com.example.data.remote.datasource.RemoteLoginDataSourceImpl
import com.example.data.remote.network.LoginAPI
import com.example.domain.handler.LoginErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginDataSourceModule {
    @Singleton
    @Provides
    fun provideLoinRemoteModule(
        loginAPI: LoginAPI,
        errorHandler: LoginErrorHandler
    ): RemoteLoginDataSource = RemoteLoginDataSourceImpl(loginAPI,errorHandler)
}