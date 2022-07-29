package com.example.data.remote.network

import com.example.data.remote.model.signup.CheckIdRequest
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CheckIdAPI {
    @POST("auths?")
    suspend fun checkId(
        @Query("id") id: String
    )
}