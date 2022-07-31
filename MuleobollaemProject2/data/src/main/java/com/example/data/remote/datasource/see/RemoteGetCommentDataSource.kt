package com.example.data.remote.datasource.see

import com.example.data.remote.model.see.CommentResponse

interface RemoteGetCommentDataSource {
    suspend fun getComment(id: Int): CommentResponse
}