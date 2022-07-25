package com.example.data.remote.datasource.main

import com.example.data.remote.model.main.MainResponse


interface RemoteMainDataSource {
    suspend fun getMain(header: String) : MainResponse
}