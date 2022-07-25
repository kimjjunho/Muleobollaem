package com.example.data.remote.network

import com.example.data.remote.model.put.PutPostRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Path

interface PutAPI {

    @PUT("posts/{post_id}")
    suspend fun putPostApi(
        @Header("Authorization") header: String,
        @Body putPostRequest: PutPostRequest,
        @Path("post_id") post_id: Int
        )
}