package com.example.data.remote.datasource.signup

import com.example.data.remote.model.signup.SignUpRequest
import com.example.data.remote.network.SignUpAPI
import com.example.domain.handler.SignUpErrorHandler
import javax.inject.Inject

class RemoteSignUpDataSourceImpl @Inject constructor(
    private val signUpAPI : SignUpAPI,
    private val errorHandler : SignUpErrorHandler
) : RemoteSignUpDataSource {
    override suspend fun signUp(data: SignUpRequest) {
        try {
            signUpAPI.signUp(data)
        }catch (e: Throwable){
            throw errorHandler.signUpErrorHandler(e)
        }
    }

}