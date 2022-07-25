package com.example.data.repository

import com.example.data.mapper.PutPostMapper.mapperToPutPostRequest
import com.example.data.remote.datasource.put.RemotePutPostDataSource
import com.example.data.remote.model.put.PutPostRequest
import com.example.domain.entity.put.PutPostRequestEntity
import com.example.domain.repository.PutPostRepository
import javax.inject.Inject

class PutPostRepositoryImpl @Inject constructor(
    private val remotePutPostDataSource: RemotePutPostDataSource
):PutPostRepository{
    override suspend fun putPost(header: String, body: PutPostRequestEntity, id: Int) {
        remotePutPostDataSource.putPost(header,mapperToPutPostRequest(body),id)
    }
}