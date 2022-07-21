package com.example.muleobollaemproject2.di.module.main

import com.example.data.remote.datasource.RemoteSignUpDataSource
import com.example.data.remote.datasource.RemoteSignUpDataSourceImpl
import com.example.data.remote.network.SignUpAPI
import com.example.domain.handler.SignUpErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignUpDataSourceModule {
    @Singleton
    @Provides
    fun provideSignUpRemoteModule(
        signUpAPI: SignUpAPI,
        errorHandler: SignUpErrorHandler
    ): RemoteSignUpDataSource = RemoteSignUpDataSourceImpl(signUpAPI,errorHandler)

}