package com.example.muleobollaemproject2.di.module

import com.example.data.repository.LoginRepositoryImpl
import com.example.data.repository.MainRepositoryImpl
import com.example.domain.repository.LoginRepository
import com.example.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMainRepositoryImpl(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository

    @Binds
    abstract fun bindLoginRepositoryImpl(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

}