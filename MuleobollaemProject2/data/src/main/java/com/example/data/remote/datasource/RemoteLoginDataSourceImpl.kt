package com.example.data.remote.datasource

import com.example.data.remote.model.LoginRequest
import com.example.data.remote.model.LoginResponse
import com.example.data.remote.network.LoginAPI
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.handler.LoginErrorHandler
import javax.inject.Inject

class RemoteLoginDataSourceImpl @Inject constructor(
    private val loginAPI: LoginAPI,
    private val errorHandler: LoginErrorHandler
) : RemoteLoginDataSource{
    override suspend fun getLogin(loginRequest: LoginRequest): LoginResponse =
        try{
            loginAPI.getLogin(loginRequest)
        }catch (e:Throwable){
            throw errorHandler.getLoginErrorHandler(e)
        }
}