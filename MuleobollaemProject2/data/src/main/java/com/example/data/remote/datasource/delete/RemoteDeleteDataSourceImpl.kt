package com.example.data.remote.datasource.delete

import com.example.data.remote.network.DeleteAPI
import com.example.domain.handler.DeleteErrorHandler
import javax.inject.Inject

class RemoteDeleteDataSourceImpl @Inject constructor(
    private val deleteAPI: DeleteAPI,
    private val errorHandler: DeleteErrorHandler
):RemoteDeleteDataSource {
    override suspend fun deletePost(header: String, id: Int) {
        try {
            deleteAPI.deletePost(header,id)
        }catch (e:Throwable){
            throw errorHandler.deleteErrorHandler(e)
        }
    }
}