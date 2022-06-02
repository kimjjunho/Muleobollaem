package com.example.data.remote.datasorce

import com.example.data.remote.model.MainResponse

interface RemoteMainDataSource {
    suspend fun getMain(): MainResponse
}