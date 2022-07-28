package com.example.data.repository

import com.example.data.mapper.SignUpMapper.mapperToCheckIdRequest
import com.example.data.remote.datasource.signup.RemoteCheckIdDataSource
import com.example.domain.entity.signup.CheckIdEntity
import com.example.domain.repository.CheckIdRepository
import javax.inject.Inject

class CheckIdRepositoryImpl @Inject constructor(
    private val remoteCheckIdDataSource: RemoteCheckIdDataSource
): CheckIdRepository {
    override suspend fun checkId(data: CheckIdEntity) {
        remoteCheckIdDataSource.checkId(mapperToCheckIdRequest(data))
    }
}