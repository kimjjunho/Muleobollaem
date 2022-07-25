package com.example.data.remote.datasource.main

import com.example.data.remote.model.main.MainResponse
import com.example.data.remote.network.MainAPI
import com.example.domain.handler.MainErrorHandler
import javax.inject.Inject

class RemoteMainDataSourceImpl @Inject constructor(
    private val mainAPI: MainAPI,
    private val errorHandler: MainErrorHandler
) : RemoteMainDataSource {
    override suspend fun getMain(header: String): MainResponse =
        try {
            mainAPI.getMain(header)
        } catch (e: Throwable) {
            throw errorHandler.getMainErrorHandler(e)
        }
}