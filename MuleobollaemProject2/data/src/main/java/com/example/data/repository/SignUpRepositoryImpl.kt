package com.example.data.repository

import com.example.data.mapper.SignUpMapper.mapperToSignUpRequest
import com.example.data.remote.datasource.signup.RemoteSignUpDataSource
import com.example.domain.entity.signup.SignUpEntity
import com.example.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val remoteSignUpDataSource: RemoteSignUpDataSource
): SignUpRepository{
    override suspend fun signUp(
        data: SignUpEntity
    ) {
        remoteSignUpDataSource.signUp(mapperToSignUpRequest(data))
    }
}