package com.example.data.remote.datasorce

import com.example.data.remote.model.MainResponse
import com.example.data.remote.network.MainAPI
import com.example.domain.handler.MainErrorHandler
import javax.inject.Inject

class RemoteMainDataSourceImpl @Inject constructor(
    private val mainAPI: MainAPI,
    private val errorHandler: MainErrorHandler
): RemoteMainDataSource {
    override suspend fun getMain(): MainResponse =
        try {
            mainAPI.getMain()
        }catch (e: Throwable){
            throw errorHandler.getMainErrorHandler(e)
        }
}