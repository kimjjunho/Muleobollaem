package com.example.data.remote.datasource

import com.example.data.remote.model.SignUpRequest
import com.example.data.remote.network.SignUpAPI
import com.example.domain.handler.SignUpErrorHandler
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject

class RemoteSignUpDataSourceImpl @Inject constructor(
    private val signUpAPI : SignUpAPI,
    private val errorHandler : SignUpErrorHandler
) :RemoteSignUpDataSource{
    override suspend fun signUp(data: SignUpRequest) {
        try {
            signUpAPI.signUp(data)
        }catch (e: Throwable){
            throw errorHandler.signUpErrorHandler(e)
        }
    }

}