package com.example.data.remote.network

import com.example.data.remote.model.signup.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPI {
    @POST("auths/signup")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    )
}