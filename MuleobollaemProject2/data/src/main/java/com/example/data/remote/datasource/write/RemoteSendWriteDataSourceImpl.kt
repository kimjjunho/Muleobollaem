package com.example.data.remote.datasource.write

import com.example.data.remote.model.write.SendWriteRequest
import com.example.data.remote.network.WriteAPI
import com.example.domain.handler.SendWriteErrorHandler
import java.lang.Exception
import javax.inject.Inject

class RemoteSendWriteDataSourceImpl @Inject constructor(
    private val writeAPI: WriteAPI,
    private val errorHandler: SendWriteErrorHandler
): RemoteSendWriteDataSource {
    override suspend fun sendWriteDataSource(header: String, sendWriteRequest: SendWriteRequest) {
        try {
            writeAPI.sendWrite(header,sendWriteRequest)
        }catch (e: Throwable){
            throw errorHandler.sendWriteErrorHandler(e)
        }
    }

}