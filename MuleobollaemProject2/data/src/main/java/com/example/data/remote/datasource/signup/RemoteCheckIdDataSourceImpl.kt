package com.example.data.remote.datasource.signup

import android.util.Log
import com.example.data.remote.model.signup.CheckIdRequest
import com.example.data.remote.network.CheckIdAPI
import com.example.domain.handler.CheckIdErrorHandler
import javax.inject.Inject

class RemoteCheckIdDataSourceImpl @Inject constructor(
    private val checkIdAPI: CheckIdAPI,
    private val errorHandler: CheckIdErrorHandler
): RemoteCheckIdDataSource {
    override suspend fun checkId(data: CheckIdRequest) {
        try {
            checkIdAPI.checkId(data.id)
        }catch (e: Throwable){
            throw errorHandler.checkIdErrorHandler(e)
        }
    }

}