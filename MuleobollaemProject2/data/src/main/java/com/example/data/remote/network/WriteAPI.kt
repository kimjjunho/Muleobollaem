package com.example.data.remote.network

import com.example.data.remote.model.write.SendWriteRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface WriteAPI {
    @POST("posts")
    suspend fun sendWrite(
        @Header("Authorization") header: String,
        @Body sendWriteRequest: SendWriteRequest
    )

}