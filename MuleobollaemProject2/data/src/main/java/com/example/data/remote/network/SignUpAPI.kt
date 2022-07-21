package com.example.data.remote.network

import com.example.data.remote.model.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface SignUpAPI {
    @POST("auths/signups")
    fun signUp(
        @Body signUpRequest: SignUpRequest
    )
}