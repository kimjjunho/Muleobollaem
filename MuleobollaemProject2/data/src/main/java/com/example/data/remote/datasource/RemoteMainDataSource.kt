package com.example.data.remote.datasource

import com.example.data.remote.model.MainResponse

interface RemoteMainDataSource {
    suspend fun getMain() : MainResponse
}