package com.example.data.repository

import com.example.data.mapper.WriteMapper.mapperToSendWriteRequest
import com.example.data.remote.datasource.write.RemoteSendWriteDataSource
import com.example.domain.entity.write.SendWriteEntity
import com.example.domain.repository.SendWriteRepository
import javax.inject.Inject

class SendWriteRepositoryImpl @Inject constructor(
    private val remoteSendWriteDataSource: RemoteSendWriteDataSource
): SendWriteRepository {
    override suspend fun sendWrite(header: String, data: SendWriteEntity) {
        remoteSendWriteDataSource.sendWriteDataSource(header, mapperToSendWriteRequest(data))
    }
}