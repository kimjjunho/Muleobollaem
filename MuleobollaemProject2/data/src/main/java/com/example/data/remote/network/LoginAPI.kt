package com.example.data.remote.network

import com.example.data.remote.model.login.LoginRequest
import com.example.data.remote.model.main.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("auths/login")
    suspend fun getLogin(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}