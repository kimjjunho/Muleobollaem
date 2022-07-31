package com.example.data.repository

import com.example.data.mapper.PutCommentMapper.mapperToPutComment
import com.example.data.remote.datasource.put.RemotePutCommentDataSource
import com.example.data.remote.model.put.PutCommentRequest
import com.example.domain.entity.comment.PutCommentRequestEntity
import com.example.domain.repository.PutCommentRepository
import javax.inject.Inject

class PutCommentRepositoryImpl @Inject constructor(
    private val remotePutCommentDataSource: RemotePutCommentDataSource
): PutCommentRepository
{
    override suspend fun putComment(header: String, data: PutCommentRequestEntity) {
        remotePutCommentDataSource.putComment(header,mapperToPutComment(data))
    }
}