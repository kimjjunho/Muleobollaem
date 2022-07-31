package com.example.data.remote.datasource.put

import com.example.data.remote.model.put.PutCommentRequest

interface RemotePutCommentDataSource {
    suspend fun putComment(header: String, body: PutCommentRequest)
}