package com.example.data.remote.datasource.write

import com.example.data.remote.model.write.SendWriteRequest

interface RemoteSendWriteDataSource {
    suspend fun sendWriteDataSource(header: String,sendWriteRequest: SendWriteRequest)
}