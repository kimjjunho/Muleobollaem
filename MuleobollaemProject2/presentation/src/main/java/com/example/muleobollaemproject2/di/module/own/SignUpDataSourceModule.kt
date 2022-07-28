package com.example.muleobollaemproject2.di.module.own

import com.example.data.remote.datasource.signup.RemoteCheckIdDataSource
import com.example.data.remote.datasource.signup.RemoteCheckIdDataSourceImpl
import com.example.data.remote.datasource.signup.RemoteSignUpDataSource
import com.example.data.remote.datasource.signup.RemoteSignUpDataSourceImpl
import com.example.data.remote.network.CheckIdAPI
import com.example.data.remote.network.SignUpAPI
import com.example.domain.handler.CheckIdErrorHandler
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

@Module
@InstallIn(SingletonComponent::class)
object CheckIdDataSourceModule {
    @Singleton
    @Provides
    fun provideCheckIdRemoteModule(
        checkIdAPI: CheckIdAPI,
        errorHandler: CheckIdErrorHandler
    ): RemoteCheckIdDataSource = RemoteCheckIdDataSourceImpl(checkIdAPI,errorHandler)
}