package com.example.data.remote.datasource.put

import com.example.data.remote.model.put.PutPostRequest

interface RemotePutPostDataSource {
    suspend fun putPost(header: String, body: PutPostRequest, id: Int)
}