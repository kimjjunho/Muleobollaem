package com.example.muleobollaemproject2.di.module.main

import com.example.data.local.dao.LoginDao
import com.example.data.local.datasource.login.LocalLoginDataSource
import com.example.data.local.datasource.login.LocalLoginDataSourceImpl
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

    @Singleton
    @Provides
    fun provideLoginDataSource(
        loginDao: LoginDao
    ) : LocalLoginDataSource = LocalLoginDataSourceImpl(loginDao)
}