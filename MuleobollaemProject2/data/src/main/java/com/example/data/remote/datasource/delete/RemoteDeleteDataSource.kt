package com.example.data.remote.datasource.delete

interface RemoteDeleteDataSource {
    suspend fun deletePost(header: String,id: Int)
}