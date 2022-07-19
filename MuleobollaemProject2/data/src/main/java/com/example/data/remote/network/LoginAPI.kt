package com.example.data.remote.network

import com.example.data.remote.model.LoginRequest
import com.example.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("auths/signups")
    suspend fun getLogin(
        @Body loginRequest:LoginRequest
    ): LoginResponse
}