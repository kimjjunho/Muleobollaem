package com.example.data.remote.datasource.put

import com.example.data.remote.model.put.PutCommentRequest
import com.example.data.remote.network.PutAPI
import com.example.domain.handler.PutCommentErrorHandler
import javax.inject.Inject

class RemotePutCommentDataSourceImpl @Inject constructor(
    private val putAPI: PutAPI,
    private val errorHandler: PutCommentErrorHandler
): RemotePutCommentDataSource {
    override suspend fun putComment(header: String, body: PutCommentRequest) {
        try {
            putAPI.putCommentAPi(header, body)
        }catch (e: Throwable){
            throw errorHandler.putCommentErrorHandler(e)
        }
    }

}