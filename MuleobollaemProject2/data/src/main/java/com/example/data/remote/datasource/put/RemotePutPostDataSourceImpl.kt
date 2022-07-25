package com.example.data.remote.datasource.put

import com.example.data.remote.model.put.PutPostRequest
import com.example.data.remote.network.PutAPI
import com.example.domain.handler.PutErrorHandler
import javax.inject.Inject

class RemotePutPostDataSourceImpl @Inject constructor(
    private val putAPI: PutAPI,
    private val errorHandler: PutErrorHandler
): RemotePutPostDataSource {
    override suspend fun putPost(header: String, body: PutPostRequest, id: Int) {
        try {
            putAPI.putPostApi(header,body,id)
        }catch (e: Throwable){
            throw errorHandler.putErrorHandler(e)
        }
    }
}