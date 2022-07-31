package com.example.data.remote.datasource.see

import com.example.data.remote.model.see.CommentResponse
import com.example.data.remote.network.CommentAPI
import com.example.domain.handler.CommentErrorHandler
import javax.inject.Inject

class RemoteGetCommentDataSourceImpl @Inject constructor(
    private val commentAPI: CommentAPI,
    private val errorHandler: CommentErrorHandler
    ): RemoteGetCommentDataSource{
    override suspend fun getComment(id: Int): CommentResponse =
        try {
            commentAPI.getComment(id)
        }catch (e: Throwable){
            throw errorHandler.getCommentErrorHandler(e)
        }
}