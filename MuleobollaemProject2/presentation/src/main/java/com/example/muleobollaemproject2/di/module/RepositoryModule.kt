package com.example.muleobollaemproject2.di.module

import com.example.data.remote.datasource.put.RemotePutPostDataSourceImpl
import com.example.data.repository.*
import com.example.domain.repository.*
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

    @Binds
    abstract fun bindSignUpRepositoryImpl(
        signUpRepositoryImpl: SignUpRepositoryImpl
    ): SignUpRepository

    @Binds
    abstract fun bindSendWriteRepositoryImpl(
        writeRepositoryImpl: SendWriteRepositoryImpl
    ): SendWriteRepository

    @Binds
    abstract fun deletePostRepositoryImpl(
        deleteRepositoryImpl: DeleteRepositoryImpl
    ): DeleteRepository

    @Binds
    abstract fun putPostRepositoryImpl(
        putPostRepositoryImpl: PutPostRepositoryImpl
    ): PutPostRepository
}