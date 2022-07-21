package com.example.data.repository

import androidx.room.PrimaryKey
import com.example.data.mapper.SignUpMapper.mapperToSignUpRequest
import com.example.data.remote.datasource.RemoteSignUpDataSource
import com.example.domain.entity.SignUpEntity
import com.example.domain.repository.SignUpRepository
import kotlinx.coroutines.flow.Flow
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