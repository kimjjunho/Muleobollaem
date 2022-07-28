package com.example.data.remote.network

import com.example.data.remote.model.signup.CheckIdRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface CheckIdAPI {
    @POST("auths")
    suspend fun checkId(
        @Body checkIdRequest: CheckIdRequest
    )
}