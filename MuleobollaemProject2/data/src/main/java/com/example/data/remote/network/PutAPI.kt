package com.example.data.remote.network

import com.example.data.remote.model.put.PutCommentRequest
import com.example.data.remote.model.put.PutPostRequest
import retrofit2.http.*

interface PutAPI {

    @PUT("posts/{post_id}")
    suspend fun putPostApi(
        @Header("Authorization") header: String,
        @Body putPostRequest: PutPostRequest,
        @Path("post_id") post_id: Int
        )

    @POST("comments")
    suspend fun putCommentAPi(
        @Header("Authorization") header: String,
        @Body putCommentRequest: PutCommentRequest
    )
}